package com.cityblockmap.cityblockmap.config;

import com.cityblockmap.cityblockmap.model.Neighborhood;
import com.cityblockmap.cityblockmap.repository.NeighborhoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private NeighborhoodRepository neighborhoodRepository;


    @Override
    public void run(String... args) throws Exception {

        Neighborhood n1 = new Neighborhood(null, "Centro");
        Neighborhood n2 = new Neighborhood(null, "Parque");

        neighborhoodRepository.saveAll(Arrays.asList(n1,n2));
    }
}
