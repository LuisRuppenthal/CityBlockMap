package com.cityblockmap.cityblockmap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_neighborhood")
public class Neighborhood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "neighborhood", cascade = CascadeType.ALL)
    //@JsonIgnore
    private List<Block> blocks;

    public Neighborhood() {

    }

    public Neighborhood(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Neighborhood(Long id, String name, List<Block> blocks) {
        this.id = id;
        this.name = name;
        this.blocks = blocks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}