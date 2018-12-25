package service.user.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import service.user.db.User;
import service.user.db.UserRepository;

@RestController
public class UserServiceController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/api/v1/addcredits")
	public String addMoreCredits(
			@RequestParam(value="userid") Integer userid,
			@RequestParam(value="credits") Double credits
			) {
		
		Gson json = new Gson();
		userRepository.addCredits(userid, credits);
		Optional<User> userDetails = userRepository.findById(userid);
		String response = json.toJson(userDetails.get());
		
		return response;
	}
	
	@RequestMapping(value="/api/v1/getcredits", method=RequestMethod.GET)
	public double getUserCredits(
			@RequestParam(value="userid", required=true) Integer userid
			) {
		return userRepository.findById(userid).get().getCredits();
	}
	
	@RequestMapping(value="/api/v1/getemail", method=RequestMethod.GET)
	public String getUserEmail(
			@RequestParam(value="userid", required=true) Integer userid
			) {
		return userRepository.findById(userid).get().getEmail();
	}
	
	@RequestMapping(value="/api/v1/getuserdetails", method=RequestMethod.GET)
	public String getUserDetails(
			@RequestParam(value="userid", required=true) Integer userid
			) {
		
			User user = userRepository.findById(userid).get();
			Gson json = new Gson();
			String jsonString = json.toJson(user);
			
			return jsonString;
	}
	
	@RequestMapping(value="/api/v1/updateCredits", method=RequestMethod.GET)
	public boolean updateUserCredits(
			@RequestParam(value="userid") Integer userid,
			@RequestParam(value="credits") Double credits
			) {
		userRepository.updateCredits(userid, credits);
		
		return true;
	}
	
	
	
}
