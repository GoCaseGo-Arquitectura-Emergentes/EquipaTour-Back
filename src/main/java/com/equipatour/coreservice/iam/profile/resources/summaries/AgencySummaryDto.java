package com.equipatour.coreservice.iam.profile.resources.summaries;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(description="Agency (Summary)")
public class AgencySummaryDto {
    @Schema(description="Id del Usuario")
    private Long id;
    @Schema(description="Nombre del Usuario")
    private String legalName;
    @Schema(description="Foto de la agencia")
    private String agencyPhotoUrl;
    @Schema(description="Telefono del Usuario")
    private String phoneNumber;
    @Schema(description="Email del Usuario")
    private String email;

}