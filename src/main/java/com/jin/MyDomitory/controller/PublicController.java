package com.jin.MyDomitory.controller;

import com.jin.MyDomitory.dto.housemaster.HouseMasterResponse;
import com.jin.MyDomitory.service.HouseMasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class PublicController {
    @Autowired
    private HouseMasterService houseMasterService;

    @GetMapping("/housemaster")
    public ResponseEntity<List<HouseMasterResponse>> findAll(){
        List<HouseMasterResponse> housemasters=houseMasterService.findAll()
                .stream()
                .map(HouseMasterResponse::new)
                .toList();
        return ResponseEntity.ok().body(housemasters);
    }
}
