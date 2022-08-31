package com.fastcampus.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
//@JsonFormat   
public enum JobType {
	EMPLOYEE,
	UNIMPLOYED, 
	BUSINESS, 
	STUDENT, 
	FREELANCER; 

}