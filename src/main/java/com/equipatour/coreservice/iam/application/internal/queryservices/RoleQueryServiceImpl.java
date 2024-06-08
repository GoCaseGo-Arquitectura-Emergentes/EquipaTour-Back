package com.equipatour.coreservice.iam.application.internal.queryservices;

import com.equipatour.coreservice.iam.domain.model.entities.Role;
import com.equipatour.coreservice.iam.domain.model.queries.GetAllRolesQuery;
import com.equipatour.coreservice.iam.domain.model.queries.GetRoleByIdQuery;
import com.equipatour.coreservice.iam.domain.services.RoleQueryService;
import com.equipatour.coreservice.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleQueryServiceImpl implements RoleQueryService {
    private final RoleRepository roleRepository;

    public RoleQueryServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> handle(GetAllRolesQuery query) {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> handle(GetRoleByIdQuery query) {
        return roleRepository.findById(query.roleId());
    }
}
