package com.equipatour.coreservice.assets.resources.summaries;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(description = "Weight Balance (Summary)")
public class WeightBalanceSummaryDto {

    @Schema(description = "Peso Actual Sumarizado")
    private Double actualWeight;

}
