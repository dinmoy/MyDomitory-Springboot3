package com.jin.MyDomitory.controller;

import com.jin.MyDomitory.domain.Personal;
import com.jin.MyDomitory.dto.personal.AddPersonalScoreRequest;
import com.jin.MyDomitory.dto.personal.PersonalResponse;
import com.jin.MyDomitory.service.PersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/personal")
@RequiredArgsConstructor
public class PersonalController {
    @Autowired
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

    @GetMapping("/{userId}")
    public ResponseEntity<List<PersonalResponse>> findByUserId(@PathVariable("userId") Long userId){
        List<PersonalResponse> personalScoreList=personalService.findByUserId(userId)
                .stream()
                .map(PersonalResponse::new)
                .toList();
        if(personalScoreList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body((personalScoreList));
    }

    @GetMapping("/penalties/{userId}")
    public ResponseEntity<List<PersonalResponse>> findPenalties(@PathVariable("userId") Long userId) {
        List<PersonalResponse> penaltyList = personalService.findByUserId(userId)
                .stream()
                .filter(personal -> personal.getType().equals("벌점"))
                .map(PersonalResponse::new)
                .toList();
        if (penaltyList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body(penaltyList);
    }

    @GetMapping("/award/{userId}")
    public ResponseEntity<List<PersonalResponse>> findAward(@PathVariable("userId") Long userId) {
        List<PersonalResponse> awardList = personalService.findByUserId(userId)
                .stream()
                .filter(personal -> personal.getType().equals("상점"))
                .map(PersonalResponse::new)
                .toList();
        if (awardList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body(awardList);
    }

    @GetMapping("/total/{userId}")
    public ResponseEntity<Long> findTotalScore(@PathVariable("userId") Long userId){
        Long personTotal=personalService.findTotalScoreByUserId(userId);
        return (personTotal!=null)?
                ResponseEntity.status(HttpStatus.OK).body(personTotal):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
