package com.library.controller;

import com.library.model.Magazine;
import com.library.service.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/magazines")
public class MagazineController {

    @Autowired
    private MagazineService magazineService;

    @GetMapping
    public List<Magazine> getAllMagazines() {
        return magazineService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Magazine> getMagazineById(@PathVariable Long id) {
        return magazineService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Magazine createMagazine(@RequestBody Magazine magazine) {
        return magazineService.save(magazine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Magazine> updateMagazine(
            @PathVariable Long id,
            @RequestBody Magazine magazineDetails
    ) {
        try {
            Magazine updatedMagazine = magazineService.update(id, magazineDetails);
            return ResponseEntity.ok(updatedMagazine);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMagazine(@PathVariable Long id) {
        magazineService.delete(id);
        return ResponseEntity.noContent().build();
    }
}