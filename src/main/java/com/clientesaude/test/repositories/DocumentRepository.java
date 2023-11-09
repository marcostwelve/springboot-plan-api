package com.clientesaude.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clientesaude.test.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{
	
}
