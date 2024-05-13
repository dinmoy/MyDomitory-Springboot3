package com.jin.MyDomitory.dto.cleaning;

import com.jin.MyDomitory.domain.Cleaning;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CleaningResponse {
    private String roomNum;
    private String cleanPoint;
    private LocalDate date;

    public CleaningResponse(Cleaning cleaning){
        this.roomNum=cleaning.getRoomNum();
        this.cleanPoint=cleaning.getCleanPoint();
        this.date=cleaning.getDate();
    }

}
