package com.equipatour.coreservice.iam.application.internal.commandservices;

import com.equipatour.coreservice.iam.application.internal.outboundservices.hashing.HashingService;
import com.equipatour.coreservice.iam.application.internal.outboundservices.tokens.TokenService;
import com.equipatour.coreservice.iam.domain.model.aggregates.User;
import com.equipatour.coreservice.iam.domain.model.commands.SignInCommand;
import com.equipatour.coreservice.iam.domain.model.commands.SignUpCommand;
import com.equipatour.coreservice.iam.domain.services.UserCommandService;
import com.equipatour.coreservice.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.equipatour.coreservice.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    //private final HashingService hashingService;
    //private final TokenService tokenService;
    private final RoleRepository roleRepository;

    public UserCommandServiceImpl(UserRepository userRepository
            //, HashingService hashingService, TokenService tokenService
            , RoleRepository roleRepository) {
        this.userRepository = userRepository;
       // this.hashingService = hashingService;
        //this.tokenService = tokenService;
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<User> handle(SignUpCommand command) {
        if (userRepository.existsByUsername(command.username()))
            throw new RuntimeException("Username already exists");
        var rol = roleRepository.findByName(command.rol()).orElseThrow();
        var user = new User(command.username(), command.password(), rol);
        //var user = new User(command.username(), hashingService.encode(command.password()), roles);
        userRepository.save(user);
        return userRepository.findByUsername(command.username());
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByUsername(command.username())
                .orElseThrow(() -> new RuntimeException("User not found"));
//        if (!hashingService.matches(command.password(), user.getPassword()))
//            throw new RuntimeException("Invalid password");
//        var token = tokenService.generateToken(user.getUsername());
        return Optional.of(new ImmutablePair<>(user, ""));
    }
}
