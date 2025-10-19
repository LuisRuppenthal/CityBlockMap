package com.cityblockmap.cityblockmap.service;

import java.util.List;
import java.util.Optional;

import com.cityblockmap.cityblockmap.model.Neighborhood;
import com.cityblockmap.cityblockmap.repository.NeighborhoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NeighborhoodService {

    @Autowired
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
    public Neighborhood updateNeighborhood(Long id, Neighborhood obj) {
        Neighborhood neighborhood = neighborhoodRepository.getReferenceById(id);
        updateData(neighborhood, obj);
        return neighborhoodRepository.save(neighborhood);
    }


    private void updateData(Neighborhood neighborhood, Neighborhood obj){
        neighborhood.setName(obj.getName());
    }


    //DELETE
    public void deleteById(Long id) {
        neighborhoodRepository.deleteById(id);
    }
}


