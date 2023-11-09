package com.clientesaude.test.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientesaude.test.entities.Document;
import com.clientesaude.test.services.DocumentService;

@RestController
@RequestMapping(value = "/documents")
public class DocumentResource {
	
	@Autowired
	private DocumentService service;
	
	@GetMapping
	public ResponseEntity<List<Document>> findAll() {
		List<Document> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Document> findById(@PathVariable Long id) {
		Document ben = service.findById(id);
		return ResponseEntity.ok().body(ben);
	}
}
