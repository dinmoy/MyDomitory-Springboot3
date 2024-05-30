package com.jin.MyDomitory.controller;

import com.jin.MyDomitory.domain.Schedule;
import com.jin.MyDomitory.dto.schedule.AddScheduleRequest;
import com.jin.MyDomitory.dto.schedule.ScheduleResponse;
import com.jin.MyDomitory.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<Schedule> addSchedule(@RequestBody AddScheduleRequest dto){
        Schedule newSchedule=scheduleService.addSchedule(dto);
        return (newSchedule!=null)?
                ResponseEntity.status(HttpStatus.CREATED).body(newSchedule):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponse>> findAllSchedule(){
        List<ScheduleResponse> schedules=scheduleService.findAll()
                .stream()
                .map(ScheduleResponse::new)
                .toList();
        return ResponseEntity.ok().body(schedules);
    }

}
