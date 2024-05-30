package com.jin.MyDomitory.dto.schedule;


import com.jin.MyDomitory.domain.Schedule;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ScheduleResponse {
    private String content;
    private LocalDate date;
    private boolean progress;

    public ScheduleResponse(Schedule schedule){
        this.content=schedule.getContent();
        this.date=schedule.getDate();
        this.progress=schedule.isProgress();
    }
}
