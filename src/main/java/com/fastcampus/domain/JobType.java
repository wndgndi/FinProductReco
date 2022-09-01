package com.fastcampus.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat
public enum JobType {
	EMPLOYEE,
	UNEMPLOYED, 
	BUSINESS, 
	STUDENT, 
	FREELANCER;  
}