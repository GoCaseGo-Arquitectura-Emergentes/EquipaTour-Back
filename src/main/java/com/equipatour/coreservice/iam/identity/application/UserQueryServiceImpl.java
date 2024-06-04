package com.equipatour.coreservice.iam.identity.application;

import com.equipatour.coreservice.iam.identity.domain.model.User;
import com.equipatour.coreservice.iam.identity.domain.queries.GetUserByIdQuery;
import com.equipatour.coreservice.iam.identity.domain.repositories.UserRepository;
import com.equipatour.coreservice.iam.identity.service.UserQueryService;
import com.equipatour.coreservice.shared.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User handle(GetUserByIdQuery query) {
        return userRepository.findById(query.uid())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + query.uid()));
    }
}
