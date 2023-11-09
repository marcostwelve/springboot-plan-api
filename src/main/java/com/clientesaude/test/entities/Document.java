package com.clientesaude.test.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_document")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String documentType;
	private String description;
	private LocalDate inclusionDate;
	private LocalDate updateDate;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Beneficiary client;
	
	public Document() {
		
	}

	public Document(Long id, String documentType, String description, LocalDate inclusionDate, LocalDate updateDate,
			Beneficiary client) {
		super();
		this.id = id;
		this.documentType = documentType;
		this.description = description;
		this.inclusionDate = inclusionDate;
		this.updateDate = updateDate;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getInclusionDate() {
		return inclusionDate;
	}

	public void setinclusionDate(LocalDate inclusionDate) {
		this.inclusionDate = inclusionDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	public Beneficiary getClient() {
		return client;
	}

	public void setClient(Beneficiary client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
