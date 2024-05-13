package com.jin.MyDomitory.dto.cleaning;

import com.jin.MyDomitory.domain.Cleaning;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class AddCleaningRequest {
    private String roomNum;
    private String cleanPoint;
    private LocalDate date;

    @Builder
    public Cleaning toEntity(){
        return Cleaning.builder()
                .roomNum(roomNum)
                .cleanPoint(cleanPoint)
                .date(date)
                .build();
    }
}
