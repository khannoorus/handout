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
@Table(name="EmailLinkActivation")
public class EmailLinkActivation {

	@Id
	@Column(name="userProfileEmailVerificationId")
	String userProfileEmailVerificationId ;
	
	@Column(name="emailAddress")
	String emailAddress;
	
	@Column(name="isEmailVerificationLinkClicked")
	short isEmailVerificationLinkClicked;
	
	@Column(name="userProfileEmailVerificationDate")
	Date userProfileEmailVerificationDate;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "EmailLinkSetInUser")
	Set<UserProfile> userSetInEmailLinkActivation = new HashSet<UserProfile>();
	
	public EmailLinkActivation() {
		super();
	}
	
	
}
