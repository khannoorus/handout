package com.handout.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="UserProfile")
public class UserProfile {

	@Id
	@Column(name="userId")
	String userId;
	
	@Column(name="userName")
	String userName;
	
	@Column(name="emailAddress")
	String emailAddress;
	
	@Column(name="userPassword")
	String userPassword;
	
	@Column(name="isUserProfileCreated")
	short isUserProfileCreated;
	
	@Column(name="userProfileCreationDate")
	Date userProfileCreationDate;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "usergroup",joinColumns = { 
			@JoinColumn(name = "userId", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "groupId", 
					nullable = false, updatable = false) })
	Set<GroupProfile> groupSetInUser = new HashSet<GroupProfile>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "userProfileVerification",joinColumns = { 
			@JoinColumn(name = "userId", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "userProfileActivationId", 
					nullable = false, updatable = false) })
	Set<ProfileActivation> profileActivationSetInUser = new HashSet<ProfileActivation>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "UserLinkVerification",joinColumns = { 
			@JoinColumn(name = "userId", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "userProfileEmailVerificationId", 
					nullable = false, updatable = false) })
	Set<EmailLinkActivation> EmailLinkSetInUser = new HashSet<EmailLinkActivation>();	

	public UserProfile() {
		super();
	}
	
	
	
	
}
