package comAction;

import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendEmail {
    public void sendCode(String address, String key, int state) throws MessagingException{
        // ���� ���� ����
        String host = "smtp.gmail.com"; /*�̸��� ����*/
        String user = "team.uding@gmail.com"; /*�̸��� ����*/
        String password = "kh$20160725"; /*�̸��� ���� ���*/
        String subject = null;
        String code = null;
        String content = null;
        
        // ���� ����
        String recipient = address;
        if (state == 1) {
	        subject = "U-ding ������ �����մϴ�."; /*�̸����� ����*/
	        code = "http://localhost:8088/FORKI/content/join/factor/company2/certifyKey.do?key=" + key; /*Ű���� Ű �Ķ���Ϳ� �Է�*/
	        content = "�� �ּҸ� Ŭ���Ͻø� ȸ�������� �Ϸ�˴ϴ�."; /*������ �޼���*/
    	}
        if (state == 2) {
	        subject = "U-ding �����ȣ ��߱� �ȳ�"; /*�̸����� ����*/
	        code = "http://localhost:8088/FORKI/content/join/factor/company2/findPW.do?key=" + key; /*Ű���� Ű �Ķ���Ϳ� �Է�*/
	        content = "�� �ּҸ� Ŭ���Ͻø� ��й�ȣ�� �缳�� �Ͻ� �� �ֽ��ϴ�."; /*������ �޼���*/
    	}
        
        //properties ����
        Properties props = new Properties();
        props.put("mail.smtps.auth", "true");
        
        // ���� ����
        Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session); /*������ ������ ���� MimeMessageŸ�� ���� ����*/
 
        // ���� ����
        msg.setSubject(subject); /*�̸��� ���� ����*/
        msg.setText(code + "\n" + content); /*�̸��� ���� ���� :: Ű���� ���Ե� ���� �ּҿ� �޼��� ����*/
        msg.setFrom(new InternetAddress(user)); /*������� �̸��� �ּ� ����*/
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); /*�޴»�� �ּҸ� �߰�*/
 
        // �߼� ó��
        Transport transport = session.getTransport("smtps");
        transport.connect(host, user, password);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();     
    }
}