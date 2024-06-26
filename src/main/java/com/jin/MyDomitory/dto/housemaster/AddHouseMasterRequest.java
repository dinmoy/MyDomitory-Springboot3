package com.jin.MyDomitory.dto.housemaster;

import com.jin.MyDomitory.domain.Housemaster;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddHouseMasterRequest {
    private String teacherName;
    private LocalDate date;

    public AddHouseMasterRequest(Housemaster housemaster) {
    }


    public Housemaster toEntity(){
        return Housemaster.builder()
                .teacherName(teacherName)
                .date(date)
                .build();
    }
}
