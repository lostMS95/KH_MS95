package com.kh.spring.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SortVO {
	private String order;//정렬항목
	private String sort;//정렬방식
}