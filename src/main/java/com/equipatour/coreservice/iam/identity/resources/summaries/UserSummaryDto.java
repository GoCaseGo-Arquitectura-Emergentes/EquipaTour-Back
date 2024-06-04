package com.equipatour.coreservice.iam.identity.resources.summaries;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(description="Usuario (Summary)")
public class UserSummaryDto {
    @Schema(description="Id del Usuario")
    private Long id;
    @Schema(description="Nombre del Usuario")
    private String name;
}
