package com.cityblockmap.cityblockmap.service;

import com.cityblockmap.cityblockmap.model.Block;
import com.cityblockmap.cityblockmap.repository.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlockService {

    @Autowired
    private final BlockRepository blockRepository;

    public BlockService(BlockRepository blockRepository){
        this.blockRepository = blockRepository;
    }

    //GET
    public List<Block> getAll(){
        return blockRepository.findAll();
    }


    public Optional<Block> getById(Long id) {
        return blockRepository.findById(id);
    }


    //CREATE
    public Block createBlock(Block block){
        return blockRepository.save(block);
    }


    //UPDATE
    public Block updateBlock(Long id, Block obj){
        Block block = blockRepository.getReferenceById(id);
        updateData(block, obj);
        return blockRepository.save(block);
    }


    private void updateData(Block block, Block obj) {
        block.setNumber(obj.getNumber());
        block.setLatitude(obj.getLatitude());
        block.setLongitude(obj.getLongitude());
    }


    //DELETE
    public void deleteById(Long id){
        blockRepository.deleteById(id);
    }
}