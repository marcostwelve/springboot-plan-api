package com.clientesaude.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clientesaude.test.entities.Beneficiary;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long>{
	
}
