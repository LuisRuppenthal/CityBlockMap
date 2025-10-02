package com.cityblockmap.cityblockmap.controller;

import com.cityblockmap.cityblockmap.model.Neighborhood;
import com.cityblockmap.cityblockmap.service.NeighborhoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/neighborhoods")
public class NeighborhoodController {

    private final NeighborhoodService neighborhoodService;

    public NeighborhoodController(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }

    // GET
    // /neighborhoods
    @GetMapping
    public List<Neighborhood> getAll() {
        return neighborhoodService.getAll();
    }


    // /neighborhoods/{id}
    @GetMapping("/{id}")
    public Optional<Neighborhood> getById(@PathVariable Long id) {
        return neighborhoodService.getById(id);
    }


    // POST
    // /neighborhoods
    @PostMapping
    public Neighborhood create(@RequestBody Neighborhood neighborhood) {
        return neighborhoodService.createNeighborhood(neighborhood);
    }


    // PUT
    // /neighborhoods/{id}
    @PutMapping("/{id}")
    public Neighborhood update(@PathVariable Long id, @RequestBody Neighborhood neighborhood) {
        return neighborhoodService.updateNeighborhood(id, neighborhood);
    }


    // DELETE
    // /neighborhoods/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        neighborhoodService.deleteById(id);
    }

}