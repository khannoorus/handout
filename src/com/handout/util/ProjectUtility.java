package com.handout.util;

import java.util.UUID;

public class ProjectUtility {

	public String generateUniqueId(){		
		String uniqueID = UUID.randomUUID().toString();
		return uniqueID;		
	}
	
	public static void main(String[] args) {
		System.out.println(new ProjectUtility().generateUniqueId());
	}
}
