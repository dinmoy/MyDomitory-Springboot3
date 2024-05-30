package com.jin.MyDomitory.dto.schedule;

import com.jin.MyDomitory.domain.Schedule;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AddScheduleRequest {
    private String content;
    private LocalDate date;
    private boolean progress;

    @Builder
    public Schedule toEntity(){
        return Schedule.builder()
                .content(content)
                .date(date)
                .progress(progress)
                .build();
    }

}
