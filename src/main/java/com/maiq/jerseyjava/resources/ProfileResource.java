package com.maiq.jerseyjava.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.maiq.jerseyjava.model.Profile;
import com.maiq.jerseyjava.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ProfileResource {
	
	ProfileService profileService = new ProfileService();

	@GET
	//@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles() {
		
		return profileService.getAllProfiles();
	}
	
	
	@GET
	@Path("/{profileId}")
	//@Produces(MediaType.APPLICATION_JSON)
	public Profile getMessage(@PathParam("profileId") String profileName) {
		
		return profileService.getProfile(profileName);
	}
	
	
	@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile) {
		
		return profileService.addProfile(profile);
	}
	
	
	@PUT
	@Path("/{profileId}")
	public Profile updateMessage(@PathParam("profileId") String profileName, Profile profile) {
		
		profile.setProfileName(profileName);;
		return profileService.updateProfile(profile);
	}
	
	
	@DELETE
	@Path("/{profileId}")
	//@Produces(MediaType.APPLICATION_JSON)
	public void deleteProfile(@PathParam("profileId") String profileName) {
		
		profileService.deleteProfile(profileName);
		
		//System.out.println("Got delete");
	}
	
}
