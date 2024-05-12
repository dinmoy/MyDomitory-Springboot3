package com.jin.MyDomitory.service;

import com.jin.MyDomitory.domain.Housemaster;
import com.jin.MyDomitory.repository.HouseMasterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseMasterService {
    private final HouseMasterRepository houseMasterRepository;

    public HouseMasterService(HouseMasterRepository houseMasterRepository) {
        this.houseMasterRepository = houseMasterRepository;
    }
    public List<Housemaster> findAll() { return houseMasterRepository.findAll(); }
}
