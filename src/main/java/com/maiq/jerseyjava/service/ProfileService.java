package com.maiq.jerseyjava.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.maiq.jerseyjava.database.Database;
import com.maiq.jerseyjava.model.Profile;

public class ProfileService {
		
		private Map<String, Profile> profiles = Database.getProfiles();
		
		public ProfileService() {
			
			profiles.put("VinDiesel", new Profile(101, "Vin", "Diesel"));
			profiles.put("RobertDowney", new Profile(102, "Robert", "Downey"));
		}
		
		public List<Profile> getAllProfiles(){
			
			//Message m1 = new Message(101L, "Hi, let me do it", "Maiq");
			//Message m2 = new Message(102L, "Hi, let me do it again", "Ashutosh");
			
			//List<Message> list = new ArrayList<Message>();
			
			//list.add(m1);
			//list.add(m2);
			return new ArrayList<Profile>(profiles.values());
				
		}
		
		public Profile getProfile(String profileName) {
			
			return profiles.get(profileName);
		}
		
		public Profile addProfile(Profile profile) {
			
			profile.setId(profiles.size()+1);
			profiles.put(profile.getProfileName(), profile);
			return profile;
		}
		
		public Profile updateProfile(Profile profile) {
			
			if(profile.getProfileName().isEmpty() ) {
				
				return null;
			}
			
			profiles.put(profile.getProfileName(), profile);
			return profile;
		}
		
		public Profile deleteProfile(String profileName) {
			
			return profiles.remove(profileName);
		}

}
