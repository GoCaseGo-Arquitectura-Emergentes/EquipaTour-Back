package com.equipatour.coreservice.iam.identity.api.REST;

import com.equipatour.coreservice.iam.identity.api.transformation.RegisterUserAgencyCommandFromRequestDtoAssembler;
import com.equipatour.coreservice.iam.identity.domain.model.User;
import com.equipatour.coreservice.iam.identity.domain.queries.GetUserByIdQuery;
import com.equipatour.coreservice.iam.identity.mapper.IdentityMapper;
import com.equipatour.coreservice.iam.identity.resources.requests.UserRequestDto;
import com.equipatour.coreservice.iam.identity.resources.summaries.UserSummaryDto;
import com.equipatour.coreservice.iam.identity.service.UserCommandService;
import com.equipatour.coreservice.iam.identity.service.UserQueryService;
import com.equipatour.coreservice.shared.constants.HeaderConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.equipatour.coreservice.shared.messages.ConfigurationMessages.USER_CREATED;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name="User Controller")
@CrossOrigin
public class UserController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;
    private final IdentityMapper identityMapper;

    @Autowired
    public UserController(UserCommandService userCommandService,
                          UserQueryService userQueryService,
                          IdentityMapper identityMapper) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
        this.identityMapper = identityMapper;
    }

    @GetMapping("/login/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Obtener usuario", description = "Permite obtener un usuario.")
    public UserSummaryDto getUser(@Parameter @PathVariable("id") Long id) {
        User user = userQueryService.handle(new GetUserByIdQuery(id));
        return identityMapper.userToSummaryDto(user);
    }

    @PostMapping("/register/user")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Registrar usuario", description = "Permite registrar un usuario.")
    public UserSummaryDto registerAgency(@RequestBody @Valid UserRequestDto userRequestDto,
                               HttpServletResponse response) {
        User user = userCommandService.handle(RegisterUserAgencyCommandFromRequestDtoAssembler.toCommandFromDto(userRequestDto));
        response.setHeader(HeaderConstants.MESSAGES, USER_CREATED);
        return identityMapper.userToSummaryDto(user);
    }

}
