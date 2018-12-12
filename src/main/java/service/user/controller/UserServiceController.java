package service.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service.user.db.User;
import service.user.db.UserRepository;

@RestController
public class UserServiceController {

	@Autowired
	private UserRepository userRepository;
	
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
	
	@RequestMapping(value="/api/v1/updateCredits", method=RequestMethod.GET)
	public boolean updateUserCredits(
			@RequestParam(value="userid") Integer userid,
			@RequestParam(value="credits") Double credits
			) {
		userRepository.updateCredits(userid, credits);
		
		return true;
	}
}
