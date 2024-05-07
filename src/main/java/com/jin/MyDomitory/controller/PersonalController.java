package com.jin.MyDomitory.controller;

import com.jin.MyDomitory.domain.Personal;
import com.jin.MyDomitory.dto.personal.AddPersonalScoreRequest;
import com.jin.MyDomitory.service.PersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personal")
@RequiredArgsConstructor
public class PersonalController {
    private PersonalService personalService;

    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    @PostMapping
    public ResponseEntity<Personal> addPersonalScore(@RequestBody AddPersonalScoreRequest request) {
        Personal newScore = personalService.addPersonalScore(request);
        return (newScore != null) ?
                ResponseEntity.status(HttpStatus.OK).body(newScore) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
