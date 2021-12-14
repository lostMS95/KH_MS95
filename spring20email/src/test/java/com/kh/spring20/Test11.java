package com.kh.spring20;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;

//목표 : 첨부파일이 있는 메세지를 전송하는 방법
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@WebAppConfiguration
@Slf4j
public class Test11 {

	@Autowired
	private JavaMailSender sender;

	@Test
	public void mimeMessageTest() throws MessagingException, FileNotFoundException, IOException {
		// 1. 메세지 객체 생성
		MimeMessage message = sender.createMimeMessage();

		// 2. 설정 도우미 생성
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

		// 3. 정보 설정(helper)
		// = To, cc , bcc
		helper.setTo("testmszero@gmail.com");

		helper.setSubject("KH정보교육원 12월 소식지");

		// 4. 파일을 읽어서 내용을 설정
		// = src에 배치하면 ClassPath로 설정되기 때문에 손쉽게 읽을 수 있다.
		ClassPathResource resource = new ClassPathResource("email/template2.html");

		StringBuffer buffer = new StringBuffer();
		try (Scanner sc = new Scanner(resource.getFile());) {
			while (sc.hasNext()) {
				buffer.append(sc.nextLine());
				buffer.append('\n');
			}
		}

		String html = buffer.toString();
		html = html.replace("{{id}}", "testmszero@gmail.com");
		helper.setText(html, true);
		
		//(중요) 만약 링크가 첨부된다면 무조건 full 주소로 작성해야 한다(http://....)
		
		//5. 첨부파일 추가(attachment)
		//= javax.actvation.DataSource 형태로 자원을 첨부(주의 : javax.sql.DataSource와 구분)
		DataSource dataSource = new FileDataSource("C:/upload/kh84/product/군침이싹도노.png");
		helper.addAttachment("군침이싹도노.png", dataSource);
		
		//6. 전송(message)
		sender.send(message);

	}
}