package com.jin.MyDomitory.dto.housemaster;

import com.jin.MyDomitory.domain.Housemaster;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class HouseMasterResponse {
    private String teacherName;
    private LocalDate date;

    public HouseMasterResponse(Housemaster houseMaster){
        this.teacherName=houseMaster.getTeacherName();
        this.date=houseMaster.getDate();
    }

}
