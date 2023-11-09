package com.clientesaude.test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientesaude.test.entities.Document;
import com.clientesaude.test.repositories.DocumentRepository;


@Service
public class DocumentService {
	
	@Autowired
	private DocumentRepository repository;
	
	public List<Document> findAll() {
		return repository.findAll();
	}
	
	public Document findById(Long id) {
		Optional<Document> obj = repository.findById(id);
		return obj.get();
	}
}
