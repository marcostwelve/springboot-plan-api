package com.clientesaude.test.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.clientesaude.test.entities.Beneficiary;
import com.clientesaude.test.entities.Document;
import com.clientesaude.test.repositories.BeneficiaryRepository;
import com.clientesaude.test.repositories.DocumentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private BeneficiaryRepository beneficiaryRepository;
	
	@Autowired
	private DocumentRepository documentRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Beneficiary b1 = new Beneficiary(null, "Maria Brown", "11999999999", LocalDate.parse("2000-10-05"), LocalDate.parse("2002-10-10"), LocalDate.parse("2002-10-10")); 
		Beneficiary b2 = new Beneficiary(null, "Alex Green", "21888888888",  LocalDate.parse("2010-07-10"), LocalDate.parse("2013-12-15"), LocalDate.parse("2013-12-15"));
		
		Document d1 = new Document(null, "RG", "12345678", LocalDate.parse("2000-10-05"), LocalDate.parse("2001-07-10"), b1); 
		Document d2 = new Document(null, "CPF", "4567891011", LocalDate.parse("2010-07-10"), LocalDate.parse("2013-11-10"), b2); 
		Document d3 = new Document(null, "CPF", "777777777",LocalDate.parse("2021-01-12"), LocalDate.parse("2021-01-12"), b1);
		
		beneficiaryRepository.saveAll(Arrays.asList(b1, b2));
		documentRepository.saveAll(Arrays.asList(d1, d2, d3));
	}
}

