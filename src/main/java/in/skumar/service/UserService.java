package in.skumar.service;

import in.skumar.bindig.LoginForm;
import in.skumar.bindig.SignUpForm;
import in.skumar.bindig.UnlockForm;

public interface UserService {
	
	public String login(LoginForm form);
	
	public boolean signup(SignUpForm form);
	
	public String unlockAccouunt(UnlockForm form);
	
	public String forgot(String email);
	
	
	
	

}
