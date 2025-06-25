package com.library.service;

import com.library.model.Magazine;
import com.library.repository.MagazineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MagazineService {

    @Autowired
    private MagazineRepository magazineRepository;

    public List<Magazine> findAll() {
        return magazineRepository.findAll();
    }

    public Optional<Magazine> findById(Long id) {
        return magazineRepository.findById(id);
    }

    public Magazine save(Magazine magazine) {
        return magazineRepository.save(magazine);
    }

    public Magazine update(Long id, Magazine magazineDetails) {
        return magazineRepository.findById(id)
                .map(magazine -> {
                    magazine.setTitle(magazineDetails.getTitle());
                    magazine.setPublicationDate(magazineDetails.getPublicationDate());
                    magazine.setCategory(magazineDetails.getCategory());
                    magazine.setIssueNumber(magazineDetails.getIssueNumber());
                    magazine.setPublisher(magazineDetails.getPublisher());
                    return magazineRepository.save(magazine);
                })
                .orElseThrow(() -> new RuntimeException("Magazine not found with id: " + id));
    }

    public void delete(Long id) {
        magazineRepository.deleteById(id);
    }
}