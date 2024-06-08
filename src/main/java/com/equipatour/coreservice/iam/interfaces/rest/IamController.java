package com.equipatour.coreservice.iam.interfaces.rest;

import com.equipatour.coreservice.iam.domain.model.aggregates.User;
import com.equipatour.coreservice.iam.domain.model.commands.SignInCommand;
import com.equipatour.coreservice.iam.domain.model.commands.SignUpCommand;
import com.equipatour.coreservice.iam.domain.services.UserCommandService;
import com.equipatour.coreservice.iam.interfaces.rest.resources.CreateUserResource;
import com.equipatour.coreservice.iam.interfaces.rest.resources.SignInResource;
import com.equipatour.coreservice.iam.interfaces.rest.resources.SignInUserResource;
import com.equipatour.coreservice.iam.interfaces.rest.resources.UserResource;
import com.equipatour.coreservice.iam.interfaces.rest.transform.SignInResourceAssembler;
import com.equipatour.coreservice.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/iam")
@Tag(name="Identity access management Controller")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IamController {
    private final UserCommandService userCommandService;
    @Autowired
    public IamController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }
    @PostMapping("sign-up")
    public ResponseEntity<UserResource> signUp(@RequestBody @Valid CreateUserResource createUserResource) {
        var user = userCommandService.handle(new SignUpCommand(createUserResource.username(), createUserResource.password(),createUserResource.role())).orElseThrow();
        return ResponseEntity.ok(UserResourceFromEntityAssembler.toResourceFromEntity(user));
    }
    @PostMapping("sign-in")
    public ResponseEntity<SignInUserResource> signIn(@RequestBody @Valid SignInResource createUserResource) {
        var user = userCommandService.handle(new SignInCommand(createUserResource.username(), createUserResource.password())).orElseThrow();
        return new ResponseEntity<>(SignInResourceAssembler.toResourceFromEntity(user), HttpStatus.OK);
    }
}
