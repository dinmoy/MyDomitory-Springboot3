package com.jin.MyDomitory.dto.laundry;

import com.jin.MyDomitory.domain.Laundry;
import lombok.Getter;

@Getter
public class LaundryResponse {
    private Long userId;
    private Long room_num;
    private Long washer_num;

    public LaundryResponse(Laundry laundry){
        this.userId=laundry.getUserId();
        this.room_num=laundry.getRoom_num();
        this.washer_num=laundry.getWasher_num();
    }

}
