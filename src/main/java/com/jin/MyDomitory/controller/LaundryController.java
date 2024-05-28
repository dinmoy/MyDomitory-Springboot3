package com.jin.MyDomitory.controller;

import com.jin.MyDomitory.domain.Laundry;
import com.jin.MyDomitory.dto.laundry.AddLaundryRequest;
import com.jin.MyDomitory.dto.laundry.LaundryResponse;
import com.jin.MyDomitory.service.LaundryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/laundry")
@RequiredArgsConstructor
public class LaundryController {
    @Autowired
    private LaundryService laundryService;

    public LaundryController(LaundryService laundryService) {
        this.laundryService = laundryService;
    }

    @GetMapping
    public ResponseEntity<List<LaundryResponse>> findAllLaundry(){
        List<LaundryResponse> laundries=laundryService.findAll()
                .stream()
                .map(LaundryResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(laundries);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<LaundryResponse>> getLaundryByUserId(@PathVariable("userId") Long userId) {
        List<LaundryResponse> laundryList = laundryService.findByUserId(userId)
                .stream()
                .map(LaundryResponse::new)
                .toList();
        if (laundryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body((laundryList));
    }

    @PostMapping
    public ResponseEntity<Laundry> addLaundry(@RequestBody AddLaundryRequest request){
        Laundry newLaundry=laundryService.addLaundry(request);
        return (newLaundry!=null)?
                ResponseEntity.status(HttpStatus.OK).body((newLaundry)):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
