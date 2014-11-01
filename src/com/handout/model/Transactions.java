package com.handout.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Transactions")
public class Transactions {

	@Id
	@Column(name="transactionId")
	String transactionId;
	
	@Column(name="transactionAmount")
	double transactionAmount;
	
	@Column(name="transactionDate")
	Date transactionDate;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "transactionSetInGroup")
	Set<GroupProfile> groupSetInTransaction = new HashSet<GroupProfile>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "transactionSetInContributor")
	Set<Contributor> contributorSetInTransaction = new HashSet<Contributor>();


	public Transactions() {
		super();
	}
	
	
}