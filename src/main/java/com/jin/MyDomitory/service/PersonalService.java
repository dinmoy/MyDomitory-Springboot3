package com.jin.MyDomitory.service;

import com.jin.MyDomitory.domain.Personal;
import com.jin.MyDomitory.domain.User;
import com.jin.MyDomitory.dto.personal.AddPersonalScoreRequest;
import com.jin.MyDomitory.repository.PersonalRepository;
import com.jin.MyDomitory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonalService {
    @Autowired
    private final PersonalRepository personalRepository;
    @Autowired
    private UserRepository userRepository;

    public PersonalService(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    public Personal addPersonalScore(AddPersonalScoreRequest request){
        Long userId = request.getUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        return personalRepository.save(request.toEntity());
    }
    public List<Personal> findByUserId(Long userId) { return personalRepository.findByUserId(userId);}

    public Long findTotalScoreByUserId(Long userId){
        List<Personal> scores=personalRepository.findByUserId(userId);
        Long totalScore=0l;
        for(Personal score: scores) totalScore+=score.getScore();
        return totalScore;
    }
}
