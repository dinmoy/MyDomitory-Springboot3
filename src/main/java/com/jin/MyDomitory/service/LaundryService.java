package com.jin.MyDomitory.service;

import com.jin.MyDomitory.domain.Laundry;
import com.jin.MyDomitory.domain.User;
import com.jin.MyDomitory.dto.laundry.AddLaundryRequest;
import com.jin.MyDomitory.repository.LaundryRepository;
import com.jin.MyDomitory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaundryService {
    @Autowired
    private final LaundryRepository laundryRepository;
    @Autowired
    private UserRepository userRepository;

    public LaundryService(LaundryRepository laundryRepository) {
        this.laundryRepository = laundryRepository;
    }

    public Laundry addLaundry(AddLaundryRequest request){
        Long userId = request.getUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        return laundryRepository.save(request.toEntity());
    }

    public List<Laundry> findAll(){ return laundryRepository.findAll(); }

    public List<Laundry> findByUserId(Long userId) {
        return laundryRepository.findByUserId(userId);
    }
}
