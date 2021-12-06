package com.kh.spring10.entity;

import lombok.Data;

@Data
public class ProductDto {
	private int no;
	private String name;
	private String type;
	private int price;
	private String made;
	private String expire;
}