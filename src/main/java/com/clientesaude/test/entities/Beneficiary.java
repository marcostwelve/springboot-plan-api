package com.clientesaude.test.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "beneficiary")
public class Beneficiary implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String name;
	private String phone;
	private LocalDate dateOfBirth;
	private LocalDate inclusionDate;
	private LocalDate updateDate;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Document> documents = new ArrayList<>();
	
	public Beneficiary() {
	}

	public Beneficiary(Long id, String name, String phone, LocalDate dateOfBirth, LocalDate inclusionDate, LocalDate updateDate) {
		super();
		Id = id;
		this.name = name;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.inclusionDate = inclusionDate;
		this.updateDate = updateDate;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public LocalDate getInclusionDate() {
		return inclusionDate;
	}
	
	public void setInclusionDate(LocalDate inclusionDate) {
		this.inclusionDate = inclusionDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}
	
	
	public List<Document> getDocuments() {
		return documents;
	}
	
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beneficiary other = (Beneficiary) obj;
		return Objects.equals(Id, other.Id);
	}

	
}
