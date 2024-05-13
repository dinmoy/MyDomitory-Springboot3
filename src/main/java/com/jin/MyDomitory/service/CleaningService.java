package com.jin.MyDomitory.service;

import com.jin.MyDomitory.domain.Cleaning;
import com.jin.MyDomitory.dto.cleaning.AddCleaningRequest;
import com.jin.MyDomitory.repository.CleaningRepository;
import org.springframework.stereotype.Service;

@Service
public class CleaningService {
    private final CleaningRepository cleaningRepository;

    public CleaningService(CleaningRepository cleaningRepository) {
        this.cleaningRepository = cleaningRepository;
    }

    public Cleaning addCleaning(AddCleaningRequest request){
        return cleaningRepository.save(request.toEntity());
    }
}
