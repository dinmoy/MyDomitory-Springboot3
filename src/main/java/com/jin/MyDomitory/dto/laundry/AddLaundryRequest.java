package com.jin.MyDomitory.dto.laundry;

import com.jin.MyDomitory.domain.Laundry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddLaundryRequest {
    private Long userId;
    private String washer_num;
    private String room_num;
    private LocalTime wash_time;

    public Laundry toEntity(){
        return Laundry.builder()
                .userId(userId)
                .washer_num(washer_num)
                .room_num(room_num)
                .wash_time(wash_time)
                .build();
    }
}
