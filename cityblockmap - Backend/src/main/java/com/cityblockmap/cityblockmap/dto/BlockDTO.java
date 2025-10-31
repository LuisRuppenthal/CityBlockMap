package com.cityblockmap.cityblockmap.dto;

import com.cityblockmap.cityblockmap.model.Neighborhood;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlockDTO {
    private Long id;
    private String number;
    private double latitude;
    private double longitude;
    private Neighborhood neighborhood;
}
