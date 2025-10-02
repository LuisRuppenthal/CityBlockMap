package com.cityblockmap.cityblockmap.service;

import java.util.List;
import java.util.Optional;

import com.cityblockmap.cityblockmap.model.Neighborhood;
import com.cityblockmap.cityblockmap.repository.NeighborhoodRepository;
import org.springframework.stereotype.Service;

@Service
public class NeighborhoodService {

    private final NeighborhoodRepository neighborhoodRepository;

    public NeighborhoodService(NeighborhoodRepository neighborhoodRepository) {
        this.neighborhoodRepository = neighborhoodRepository;
    }

    //GET
    public List<Neighborhood> getAll() {
        return neighborhoodRepository.findAll();
    }

    public Optional<Neighborhood> getById(Long id) {
        return neighborhoodRepository.findById(id);
    }

    //CREATE
    public Neighborhood createNeighborhood(Neighborhood neighborhood) {
        return neighborhoodRepository.save(neighborhood);
    }

    //UPDATE
    public Neighborhood updateNeighborhood(Long id, Neighborhood neighborhood) {
        return neighborhoodRepository.findById(id)
                .map(existingNeighborhood -> {
                    existingNeighborhood.setName(neighborhood.getName());
                    return neighborhoodRepository.save(existingNeighborhood);
                })
                .orElseThrow(() -> new RuntimeException("Neighborhood not found with id: " + id));
    }

    //DELETE
    public void deleteById(Long id) {
        neighborhoodRepository.deleteById(id);
    }

}
