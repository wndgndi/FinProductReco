package com.fastcampus.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)    // Enum -> Json (프론트에 보낼때)
public enum JobType {
	EMPLOYEE("직장인"),
	UNIMPLOYED("무직"), 
	BUSINESS("자영업자"), 
	STUDENT("학생"), 
	FREELANCER("프리랜서");    // FREELANCER = key (디비에 저장), 프리랜서 = name (UI에 노출)  

	private String name;

	public String getName() {
		return name;
	}
	
	@JsonCreator    // Json -> Enum (서버에 넣을때) 
    public static JobType fromJson(@JsonProperty("key") String name) {
        return valueOf(name);
    }
}