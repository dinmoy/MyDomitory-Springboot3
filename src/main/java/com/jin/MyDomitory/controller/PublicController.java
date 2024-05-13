package com.jin.MyDomitory.controller;

import com.jin.MyDomitory.domain.Cleaning;
import com.jin.MyDomitory.domain.Housemaster;
import com.jin.MyDomitory.dto.cleaning.AddCleaningRequest;
import com.jin.MyDomitory.dto.cleaning.CleaningResponse;
import com.jin.MyDomitory.dto.housemaster.AddHouseMasterRequest;
import com.jin.MyDomitory.dto.housemaster.HouseMasterResponse;
import com.jin.MyDomitory.service.CleaningService;
import com.jin.MyDomitory.service.HouseMasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class PublicController {
    @Autowired
    private HouseMasterService houseMasterService;
    @Autowired
    private CleaningService cleaningService;

    @GetMapping("/housemaster")
    public ResponseEntity<List<HouseMasterResponse>> findAll(){
        List<HouseMasterResponse> housemasters=houseMasterService.findAll()
                .stream()
                .map(HouseMasterResponse::new)
                .toList();
        return ResponseEntity.ok().body(housemasters);
    }

    @PostMapping("/housemaster")
    public ResponseEntity<Housemaster> addMaster(@RequestBody AddHouseMasterRequest request){
        Housemaster newHouseMaster=houseMasterService.addMaster(request);
        return (newHouseMaster!=null)?
                ResponseEntity.status(HttpStatus.OK).body(newHouseMaster):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/cleaning")
    public ResponseEntity<Cleaning> addCleaning(@RequestBody AddCleaningRequest request){
        Cleaning newCleaning=cleaningService.addCleaning(request);
        return (newCleaning!=null)?
                ResponseEntity.status(HttpStatus.OK).body(newCleaning):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/housemaster/today")
    public ResponseEntity<List<HouseMasterResponse>> findByDate(){
        List<HouseMasterResponse> housemasters=houseMasterService.findByDate()
                .stream()
                .map(HouseMasterResponse::new)
                .toList();
        return (housemasters!=null)?
                ResponseEntity.status(HttpStatus.OK).body(housemasters):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/cleaning/today")
    public ResponseEntity<List<CleaningResponse>> findByCleanDate(){
        List<CleaningResponse> cleanRooms=cleaningService.findByDate()
                .stream()
                .map(CleaningResponse::new)
                .toList();
        return (cleanRooms!=null)?
                ResponseEntity.status(HttpStatus.OK).body(cleanRooms):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
