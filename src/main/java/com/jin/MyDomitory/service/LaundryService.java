package com.jin.MyDomitory.service;

import com.jin.MyDomitory.domain.Laundry;
import com.jin.MyDomitory.dto.laundry.AddLaundryRequest;
import com.jin.MyDomitory.repository.LaundryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaundryService {
    @Autowired
    private final LaundryRepository laundryRepository;

    public LaundryService(LaundryRepository laundryRepository) {
        this.laundryRepository = laundryRepository;
    }

    public Laundry addLaundry(AddLaundryRequest request){
        return laundryRepository.save(request.toEntity());
    }

    public List<Laundry> findAll(){ return laundryRepository.findAll(); }

    public List<Laundry> findByUserId(Long userId) {
        return laundryRepository.findByUserId(userId);
    }
}
