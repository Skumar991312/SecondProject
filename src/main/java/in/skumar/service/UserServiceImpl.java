package in.skumar.service;

import java.beans.Beans;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.skumar.bindig.LoginForm;
import in.skumar.bindig.SignUpForm;
import in.skumar.bindig.UnlockForm;
import in.skumar.entity.UserDtlsEntity;
import in.skumar.repo.UserDtlsRepo;
import in.skumar.utility.EmailUtils;
import in.skumar.utility.PwdUtils;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDtlsRepo userDtlsRepo;
	
	@Autowired
	private EmailUtils emailutils;
	
	@Override
	public boolean signup(SignUpForm form) {
		
		UserDtlsEntity entity=new UserDtlsEntity();
		BeanUtils.copyProperties(form, entity);
		//generate pwd random
		String tempPwd=PwdUtils.generateRandomPwd();
	     entity.setPwd(tempPwd);
	     
	   //set Account status as lock
	     entity.setAccStatus("LOCKED");
		
	       // insert the data in data base
	      userDtlsRepo.save(entity);
		
		//send the email and unlock the account
	      String to=form.getEmail();
	      String subject="Unlock Your Account";
	      
	      StringBuffer body=new StringBuffer("");
	      body.append("<h1> Use below Temparary password to unlock your account</h1>");
	      body.append("Temporary pwd :"+ tempPwd); 
	      body.append("<br/>");
	      body.append("<a href=\"unlock?email="+ to +"\">Click Here To unlock your Account</a>");
          	      
		 emailutils.sendEmail(to, subject, body.toString() );
		
		return false;
	}

	@Override
	public String login(LoginForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String unlockAccouunt(UnlockForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String forgot(String email) {
		// TODO Auto-generated method stub
		return null;
	}
   
	
}
