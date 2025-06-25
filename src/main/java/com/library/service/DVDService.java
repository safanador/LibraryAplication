package com.library.service;

import com.library.model.DVD;
import com.library.repository.DVDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DVDService {

    @Autowired
    private DVDRepository dvdRepository;

    public List<DVD> findAll() {
        return dvdRepository.findAll();
    }

    public Optional<DVD> findById(Long id) {
        return dvdRepository.findById(id);
    }

    public DVD save(DVD dvd) {
        return dvdRepository.save(dvd);
    }

    public DVD update(Long id, DVD dvdDetails) {
        return dvdRepository.findById(id)
                .map(dvd -> {
                    dvd.setTitle(dvdDetails.getTitle());
                    dvd.setPublicationDate(dvdDetails.getPublicationDate());
                    dvd.setDirector(dvdDetails.getDirector());
                    dvd.setGenre(dvdDetails.getGenre());
                    dvd.setDuration(dvdDetails.getDuration());
                    return dvdRepository.save(dvd);
                })
                .orElseThrow(() -> new RuntimeException("DVD not found with id: " + id));
    }

    public void delete(Long id) {
        dvdRepository.deleteById(id);
    }
}