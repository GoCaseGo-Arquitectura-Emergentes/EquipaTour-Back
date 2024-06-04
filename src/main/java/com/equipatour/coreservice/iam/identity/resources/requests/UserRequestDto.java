package com.equipatour.coreservice.iam.identity.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(description="Usuario (Request)")
public class UserRequestDto {
    @Schema(description="Nombre del Usuario")
    private String name;
    @Schema(description="Email del Usuario")
    private String email;
    @Schema(description="Url de la foto del Usuario")
    private String photoUrl;

}
