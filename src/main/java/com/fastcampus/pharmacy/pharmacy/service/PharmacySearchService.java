package com.fastcampus.pharmacy.pharmacy.service;

import com.fastcampus.pharmacy.pharmacy.entity.Pharmacy;
import com.fastcampus.pharmacy.pharmacy.entity.dto.PharmacyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class PharmacySearchService {

    private final PharmacyRepositoryService pharmacyRepositoryService;

    // redis

    // db
    public List<PharmacyDto> searchPharmacyDtoList() {
        return pharmacyRepositoryService.findAll()
                .stream()
                .map(this::convertToPharmacyDto)
                .collect(Collectors.toList());
    }

    private PharmacyDto convertToPharmacyDto(Pharmacy pharmacy) {
        return PharmacyDto.builder()
                .id(pharmacy.getId())
                .pharmacyName(pharmacy.getPharmacyName())
                .pharmacyAddress(pharmacy.getPharmacyAddress())
                .longitude(pharmacy.getLongitude())
                .latitude(pharmacy.getLatitude())
                .build();
    }
}