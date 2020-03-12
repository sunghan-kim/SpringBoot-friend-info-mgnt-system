package com.springboot.project.friendinfomgntsystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Embeddable // Entity에 속해있는 DTO라고 명시
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Birthday {
    private int yearOfBirthday;

    @Min(1)
    @Max(12)
    private int monthOfBirthday;

    @Min(1)
    @Max(31)
    private int dayOfBirthday;
}
