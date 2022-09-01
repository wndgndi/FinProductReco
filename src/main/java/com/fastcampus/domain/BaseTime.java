package com.fastcampus.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTime {
	
    @CreatedDate
    private LocalDateTime createdDate; //계정 생성 날짜 저장

    @LastModifiedDate
    private LocalDateTime modifiedDate; //계정 수정 날짜 저장
}
