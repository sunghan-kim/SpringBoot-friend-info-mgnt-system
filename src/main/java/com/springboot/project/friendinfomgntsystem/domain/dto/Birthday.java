package com.springboot.project.friendinfomgntsystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable // Entity에 속해있는 DTO라고 명시
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Birthday {
    private int yearOfBirthday;
    private int monthOfBirthday;
    private int dayOfBirthday;
}
