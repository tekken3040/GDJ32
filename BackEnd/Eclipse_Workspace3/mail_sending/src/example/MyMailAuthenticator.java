package example;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 메일 인증(아이디/패쓰워드) 클래스
 * 
 * @author javateam
 *
 */
public class MyMailAuthenticator extends Authenticator {
		 
    PasswordAuthentication account;
 
    public MyMailAuthenticator(String id, String pw){
        account = new PasswordAuthentication(id, pw);
    }
 
    public PasswordAuthentication getPasswordAuthentication(){
        return account;
    }
    
}