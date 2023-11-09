package com.clientesaude.test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientesaude.test.entities.Beneficiary;
import com.clientesaude.test.entities.Document;
import com.clientesaude.test.repositories.BeneficiaryRepository;


@Service
public class BeneficiaryService {
	
	@Autowired
	private BeneficiaryRepository repository;
	
	public List<Beneficiary> findAll() {
		return repository.findAll();
	}
	
	public Beneficiary findById(Long id) {
		Optional<Beneficiary> obj = repository.findById(id);
		return obj.get();
	}
	
	public Beneficiary insert(Beneficiary obj) {
		List<Document> documents = obj.getDocuments();
		if(documents != null && !documents.isEmpty()) {
			for(Document document: documents) {
				document.setClient(obj);
			}
		}
		return repository.save(obj);
	}
	
	public List<Document> findDocumentsByBeneficiaryId(Long id) {
		Optional<Beneficiary> beneficiary = repository.findById(id);
		
		Beneficiary findBeneficiary = beneficiary.get();
		return findBeneficiary.getDocuments();
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Beneficiary update(Long id, Beneficiary obj) {
		Beneficiary entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	
	private void updateData(Beneficiary entity, Beneficiary obj) {
		entity.setName(obj.getName());			
		entity.setPhone(obj.getPhone());			
		entity.setDateOfBirth(obj.getDateOfBirth());			
		entity.setInclusionDate(obj.getInclusionDate());
		entity.setUpdateDate(obj.getUpdateDate());
		entity.setDocuments(obj.getDocuments());
	}
}
