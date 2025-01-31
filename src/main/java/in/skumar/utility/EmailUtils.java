package in.skumar.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {
	
	@Autowired
	public JavaMailSender mailSender;
	
	public boolean sendEmail(String to,String subject,String body) {
		boolean isSent=false;
		
		try {
		MimeMessage  mimemessage=mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimemessage);
		
		helper.setTo(to);
		helper.setSubject(subject);
	    helper.setText(body,true);
	    mailSender.send(mimemessage);
	    
	    isSent=true;
		}
		catch(Exception e) {
		e.printStackTrace();
		}
	    return isSent;
	}

}
