package com.jin.MyDomitory.service;

import com.jin.MyDomitory.domain.Laundry;
import com.jin.MyDomitory.dto.laundary.AddLaundryRequest;
import com.jin.MyDomitory.repository.LaundryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
