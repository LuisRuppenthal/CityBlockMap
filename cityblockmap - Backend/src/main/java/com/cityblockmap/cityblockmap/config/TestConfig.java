package com.cityblockmap.cityblockmap.config;

import com.cityblockmap.cityblockmap.model.Block;
import com.cityblockmap.cityblockmap.repository.BlockRepository;
import com.cityblockmap.cityblockmap.model.Neighborhood;
import com.cityblockmap.cityblockmap.repository.NeighborhoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Override
    public void run(String... args) throws Exception {

        Neighborhood n1 = new Neighborhood(null, "Centro", new ArrayList<>());
        Neighborhood n2 = new Neighborhood(null, "Parque", new ArrayList<>());

        neighborhoodRepository.saveAll(Arrays.asList(n1,n2));

        Block b1 = new Block(null, "Quadra 1", -11.1234, -11.1234, n1);
        Block b2 = new Block(null, "Quadra 2", -22.1234, -22.1234, n1);
        Block b3 = new Block(null, "Quadra 3", -33.1234, -33.1234, n2);
        Block b4 = new Block(null, "Quadra 4", -44.1234, -44.1234, n2);

        blockRepository.saveAll(Arrays.asList(b1, b2, b3, b4));
    }
}
