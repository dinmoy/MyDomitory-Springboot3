package com.jin.MyDomitory.dto.laundary;

import com.jin.MyDomitory.domain.Laundry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddLaundryRequest {
    private String washer_num;
    private String room_num;

    public Laundry toEntity(){
        return Laundry.builder()
                .washer_num(washer_num)
                .room_num(room_num)
                .build();
    }
}
