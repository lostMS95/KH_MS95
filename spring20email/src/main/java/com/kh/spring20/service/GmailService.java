package com.kh.spring20.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.kh.spring20.entity.CertificationDto;
import com.kh.spring20.repository.CertificationDao;
import com.kh.spring20.util.RandomUtil;

@Service
public class GmailService implements EmailService{
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private RandomUtil randomUtil;
	
	@Autowired
	private CertificationDao certificationDao;

	@Override
	public void sendCertificationNumber(String to) {
		String number = randomUtil.generateRandomNumber(6);
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("[KH정보교육원] 인증번호 메일입니다");
		message.setText("인증번호 : " + number);
		sender.send(message);
		
		CertificationDto certificationDto = new CertificationDto();
		certificationDto.setEmail(to);
		certificationDto.setSerial(number);
		
		certificationDao.insert(certificationDto);
	}
	
}



