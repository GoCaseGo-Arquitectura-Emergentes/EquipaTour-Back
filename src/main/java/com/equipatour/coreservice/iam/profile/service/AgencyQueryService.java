package com.equipatour.coreservice.iam.profile.service;

import com.equipatour.coreservice.iam.profile.domain.model.Agency;
import com.equipatour.coreservice.iam.profile.domain.queries.GetAgencyByUserId;

public interface AgencyQueryService {

    Agency handle(GetAgencyByUserId query);
}
