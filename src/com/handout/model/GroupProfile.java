package com.handout.model;

import java.util.Date;
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
@Table(name="GroupProfile")
public class GroupProfile  {

	@Id
	@Column(name="groupId")
	String groupId;
	
	@Column(name="groupName")
	String groupName;
	
	@Column(name="groupAdmin")
	String groupAdmin;
	
	@Column(name="groupPassword")
	String groupPassword;
	
	@Column(name="groupCreationDate")
	Date groupCreationDate;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "groupSetInUser")
	Set<UserProfile> userSetInGroup = new HashSet<UserProfile>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "grouptransaction",joinColumns = { 
			@JoinColumn(name = "groupId", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "transactionId", 
					nullable = false, updatable = false) })
	Set<Transactions> transactionSetInGroup = new HashSet<Transactions>();

	public GroupProfile() {
		super();
	}
}
	