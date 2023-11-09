package com.clientesaude.test.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.clientesaude.test.entities.Beneficiary;
import com.clientesaude.test.entities.Document;
import com.clientesaude.test.services.BeneficiaryService;

@RestController
@RequestMapping(value = "/beneficiaries")
public class BeneficiaryResource {
	
	@Autowired
	private BeneficiaryService service;
	
	@GetMapping
	public ResponseEntity<List<Beneficiary>> findAll() {
		List<Beneficiary> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Beneficiary> findById(@PathVariable Long id) {
		Beneficiary ben = service.findById(id);
		return ResponseEntity.ok().body(ben);
	}
	
	@GetMapping(value = "/{id}/documents")
	public ResponseEntity<List<Document>> findDocumentsByBeneficiaryId(@PathVariable Long id) {
		List<Document> documents = service.findDocumentsByBeneficiaryId(id);
		return ResponseEntity.ok().body(documents);
	}
	
	@PostMapping
	public ResponseEntity<Beneficiary> insert(@RequestBody Beneficiary obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Beneficiary> update(@PathVariable Long id, @RequestBody Beneficiary obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
