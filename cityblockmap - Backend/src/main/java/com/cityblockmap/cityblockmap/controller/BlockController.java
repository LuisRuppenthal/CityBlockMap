package com.cityblockmap.cityblockmap.controller;

import com.cityblockmap.cityblockmap.model.Block;
import com.cityblockmap.cityblockmap.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blocks")
public class BlockController {

    @Autowired
    private final BlockService blockService;

    public BlockController(BlockService blockService){
        this.blockService = blockService;
    }

    //GET
    // /blocks
    @GetMapping
    public ResponseEntity<List<Block>> getAll(){
        List<Block> blocks = blockService.getAll();
        return ResponseEntity.ok().body(blocks);
    }


    //
    // /blocks/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Block> getById(@PathVariable("id") Long id) {
        Optional<Block> block = blockService.getById(id);
        return ResponseEntity.ok(block.get());
    }


    // POST
    // /blocks
    @PostMapping
    public ResponseEntity<Block> createBlock(@RequestBody Block block) {
        block = blockService.createBlock(block);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(block.getId()).toUri();
        return ResponseEntity.created(uri).body(block);
    }


    // PUT
    // /blocks/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Block> updateBlock(@PathVariable("id") Long id, @RequestBody Block block) {
        block = blockService.updateBlock(id, block);
        return ResponseEntity.ok().body(block);
    }


    // DELETE
    // /blocks/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        blockService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}