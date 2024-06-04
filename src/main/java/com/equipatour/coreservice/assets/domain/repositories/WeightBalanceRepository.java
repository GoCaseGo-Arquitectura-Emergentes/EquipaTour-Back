package com.equipatour.coreservice.assets.domain.repositories;

import com.equipatour.coreservice.assets.domain.model.WeightBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightBalanceRepository extends JpaRepository<WeightBalance, Long> {
}
