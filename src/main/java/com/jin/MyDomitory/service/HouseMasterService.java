package com.jin.MyDomitory.service;

import com.jin.MyDomitory.domain.Housemaster;
import com.jin.MyDomitory.dto.housemaster.AddHouseMasterRequest;
import com.jin.MyDomitory.repository.HouseMasterRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HouseMasterService {
    private final HouseMasterRepository houseMasterRepository;

    public HouseMasterService(HouseMasterRepository houseMasterRepository) {
        this.houseMasterRepository = houseMasterRepository;
    }
    public List<Housemaster> findAll() { return houseMasterRepository.findAll(); }

    public Housemaster addMaster(AddHouseMasterRequest request){ return houseMasterRepository.save(request.toEntity()); }

    public List<Housemaster> findByDate() {
        LocalDate today = LocalDate.now();
        return houseMasterRepository.findByDate(today); }
}
