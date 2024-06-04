package com.equipatour.coreservice.iam.identity.application;

import com.equipatour.coreservice.iam.identity.domain.commands.RegisterUserAgencyCommand;
import com.equipatour.coreservice.iam.identity.domain.model.User;
import com.equipatour.coreservice.iam.identity.domain.repositories.UserRepository;
import com.equipatour.coreservice.iam.identity.resources.requests.UserRequestDto;
import com.equipatour.coreservice.iam.identity.service.UserCommandService;
import com.equipatour.coreservice.shared.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;

    @Autowired
    public UserCommandServiceImpl(UserRepository userRepository,
                                  ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
    }


    private User getUser(User user,  UserRequestDto userRequestDto) {
        user.setEmail(userRequestDto.getEmail());
        userRepository.save(user);
        return user;
    }

    @Override
    public User handle(RegisterUserAgencyCommand registerUserCommand) {
        User user = new User();

        return getUser(user, registerUserCommand.userRequestDto());
    }
}
