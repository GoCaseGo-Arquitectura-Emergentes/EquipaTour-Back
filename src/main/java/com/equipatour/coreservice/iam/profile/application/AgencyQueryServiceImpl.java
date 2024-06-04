package com.equipatour.coreservice.iam.profile.application;

import com.equipatour.coreservice.iam.profile.domain.model.Agency;
import com.equipatour.coreservice.iam.profile.domain.queries.GetAgencyByUserId;
import com.equipatour.coreservice.iam.profile.domain.repositories.AgencyRepository;
import com.equipatour.coreservice.iam.profile.service.AgencyQueryService;
import com.equipatour.coreservice.shared.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgencyQueryServiceImpl implements AgencyQueryService {

    private final AgencyRepository agencyRepository;

    @Autowired
    public AgencyQueryServiceImpl(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public Agency handle(GetAgencyByUserId query) {
        Optional<Agency> agency = agencyRepository.findByUserId(query.userId());

        if(agency.isEmpty()){
            throw new ResourceNotFoundException("Agency user id cant be found");
        }
        return agency.get();
    }
}
