package com.cityblockmap.cityblockmap.controller;

import com.cityblockmap.cityblockmap.model.Neighborhood;
import com.cityblockmap.cityblockmap.service.NeighborhoodService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/neighborhoods")
public class NeighborhoodController {

    @Autowired
    private final NeighborhoodService neighborhoodService;

    public NeighborhoodController(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }

    // GET
    // /neighborhoods
    @GetMapping
    public ResponseEntity<List<Neighborhood>> getAll() {
        List<Neighborhood> neighborhoods = neighborhoodService.getAll();

        return ResponseEntity.ok().body(neighborhoods);
    }


    // /neighborhoods/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Neighborhood> getById(@PathVariable("id") Long id) {
        Optional<Neighborhood> neighborhood = neighborhoodService.getById(id);
        return ResponseEntity.ok(neighborhood.get());
    }


    // POST
    // /neighborhoods
    @PostMapping
    public ResponseEntity<Neighborhood> createNeighborhood(@RequestBody Neighborhood neighborhood) {
        neighborhood = neighborhoodService.createNeighborhood(neighborhood);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(neighborhood.getId()).toUri();
        return ResponseEntity.created(uri).body(neighborhood);
    }


    // PUT
    // /neighborhoods/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Neighborhood> updateNeighborhood(@PathVariable("id") Long id, @RequestBody Neighborhood neighborhood) {
        neighborhood = neighborhoodService.updateNeighborhood(id, neighborhood);
        return ResponseEntity.ok().body(neighborhood);
    }


    // DELETE
    // /neighborhoods/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        neighborhoodService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}