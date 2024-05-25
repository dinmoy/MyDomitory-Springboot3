package com.jin.MyDomitory.dto.laundry;

import com.jin.MyDomitory.domain.Laundry;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class LaundryResponse {
    private Long userId;
    private String room_num;
    private String washer_num;
    private LocalTime wash_time;

    public LaundryResponse(Laundry laundry){
        this.userId=laundry.getUserId();
        this.room_num=laundry.getRoom_num();
        this.washer_num=laundry.getWasher_num();
        this.wash_time=laundry.getWash_time();
    }

}
