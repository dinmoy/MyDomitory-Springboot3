package com.jin.MyDomitory.dto.laundry;

import com.jin.MyDomitory.domain.Laundry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddLaundryRequest {
    private Long userId;
    private Long washer_num;
    private Long room_num;

    public Laundry toEntity(){
        return Laundry.builder()
                .userId(userId)
                .washer_num(washer_num)
                .room_num(room_num)
                .build();
    }
}
