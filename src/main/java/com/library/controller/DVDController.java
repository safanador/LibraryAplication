package com.library.controller;

import com.library.model.DVD;
import com.library.service.DVDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dvds")
public class DVDController {

    @Autowired
    private DVDService dvdService;

    @GetMapping
    public List<DVD> getAllDVDs() {
        return dvdService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DVD> getDVDById(@PathVariable Long id) {
        return dvdService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DVD createDVD(@RequestBody DVD dvd) {
        return dvdService.save(dvd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DVD> updateDVD(
            @PathVariable Long id,
            @RequestBody DVD dvdDetails
    ) {
        try {
            DVD updatedDVD = dvdService.update(id, dvdDetails);
            return ResponseEntity.ok(updatedDVD);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDVD(@PathVariable Long id) {
        dvdService.delete(id);
        return ResponseEntity.noContent().build();
    }
}