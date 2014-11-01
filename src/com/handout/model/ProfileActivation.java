package com.handout.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ProfileActivation")
public class ProfileActivation {

	@Id
	@Column(name="userProfileActivationId")
	String userProfileActivationId;
	
	@Column(name="isUserProfileActivated")
	short isUserProfileActivated;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "profileActivationSetInUser")
	Set<UserProfile> userSetInProfileActivation = new HashSet<UserProfile>();
	
	public ProfileActivation() {
		super();
	}
	
}
