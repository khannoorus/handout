package com.handout.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Contributor")
public class Contributor{

	@Id
	@Column(name="contributorId")
	String contributorId;
	
	@Column(name="lenderUserId")
	String lenderUserId;
	
	@Column(name="borrowerUserId")
	String borrowerUserId;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "contributortransaction",joinColumns = { 
			@JoinColumn(name = "contributorId", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "transactionId", 
					nullable = false, updatable = false) })
	Set<Transactions> transactionSetInContributor = new HashSet<Transactions>();

	public Contributor() {
		super();
	}
	
	
}
