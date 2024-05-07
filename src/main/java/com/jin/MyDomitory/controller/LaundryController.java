package com.jin.MyDomitory.controller;

import com.jin.MyDomitory.domain.Laundry;
import com.jin.MyDomitory.dto.laundary.AddLaundryRequest;
import com.jin.MyDomitory.service.LaundryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/laundry")
@RequiredArgsConstructor
public class LaundryController {
    @Autowired
    private LaundryService laundryService;

    public LaundryController(LaundryService laundryService) {
        this.laundryService = laundryService;
    }

    @PostMapping
    public ResponseEntity<Laundry> addLaundry(@RequestBody AddLaundryRequest request){
        Laundry newLaundry=laundryService.addLaundry(request);
        return (newLaundry!=null)?
                ResponseEntity.status(HttpStatus.OK).body((newLaundry)):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
