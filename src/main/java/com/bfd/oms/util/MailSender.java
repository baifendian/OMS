package com.bfd.oms.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.bfd.oms.model.Mail;
import com.bfd.oms.model.WorkTime;

public class MailSender {
    /** 
     * 以文本格式发送邮件 (支持群发,带附件) 
     * @param senderInfo 待发送的邮件的信息  
     * @author wujun
     * @email: jun.wu@baifendian.com
     */  
    public static boolean sendMail(MailSenderInfo senderInfo){  
        boolean flag = false;  
          
        // 判断是否需要身份验证  
        AuthenticatorChild authenticator = null;  
        Properties props = senderInfo.getProperties();  
        if(senderInfo.isValidate()){  
            // 如果需要身份认证，则创建一个密码验证器     
            authenticator = new AuthenticatorChild(senderInfo.getUserName(), senderInfo.getPassword());  
        }  
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session  
        Session sendMailSession = Session.getDefaultInstance(props, authenticator);  
          
        try {  
            // 根据session创建一个邮件消息  
            Message sendMailMessage = new MimeMessage(sendMailSession);  
            // 创建邮件发送者地址  
            Address from = new InternetAddress(senderInfo.getFromAddress());  
            // 设置邮件消息的发送者  
            sendMailMessage.setFrom(from);  
              
            // 创建邮件接收者地址  
            String[] tos = senderInfo.getToAddress();  
            if(tos != null && tos.length != 0){  
                InternetAddress[] to = new InternetAddress[tos.length];  
                // 设置邮件消息的发送者  
                for (int i = 0; i < tos.length; i++) {  
                    to[i] = new InternetAddress(tos[i]);  
                }  
                sendMailMessage.setRecipients(Message.RecipientType.TO, to);  
            }  
              
            // 设置邮件抄送者地址  
            String[] toCCs = senderInfo.getToCarbonCopyAddress();  
            if(toCCs != null && toCCs.length != 0){  
                InternetAddress[] toCC = new InternetAddress[toCCs.length];  
                // 设置邮件消息的发送者  
                for (int i = 0; i < toCCs.length; i++) {  
                    toCC[i] = new InternetAddress(toCCs[i]);  
                }  
                sendMailMessage.addRecipients(Message.RecipientType.CC, toCC);  
            }  
              
            // 设置邮件密送者地址  
            String[] toBCCs = senderInfo.getToBlindCarbonCopyAddress();  
            if(toBCCs != null && toBCCs.length != 0){  
                InternetAddress[] toBCC = new InternetAddress[toBCCs.length];  
                for (int i = 0; i < toBCCs.length; i++) {  
                    toBCC[i] = new InternetAddress(toBCCs[i]);  
                }  
                sendMailMessage.addRecipients(Message.RecipientType.BCC, toBCC);  
            }  
              
            // 设置邮件主题  
            sendMailMessage.setSubject(MimeUtility.encodeText(senderInfo.getSubject(),"utf-8","B"));  
            // 设置邮件内容  
            //sendMailMessage.setText(senderInfo.getContent());  
            Multipart multipart = new MimeMultipart();  
            // 邮件文本内容  
            if(senderInfo.getContent() != null && !"".equals(senderInfo.getContent())){  
                BodyPart part = new MimeBodyPart();  
                part.setContent(senderInfo.getContent(), "text/plain;charset=utf-8");//设置邮件文本内容  
                multipart.addBodyPart(part);  
            }  
              
            // 附件  
            String attachFileNames[] = senderInfo.getAttachFileNames();  
            int leng = attachFileNames == null ? 0 : attachFileNames.length;  
            for (int i = 0; i < leng; i++) {  
                BodyPart part = new MimeBodyPart();  
                // 根据文件名获取数据源  
                DataSource dataSource = new FileDataSource(attachFileNames[i]);  
                DataHandler dataHandler = new DataHandler(dataSource);  
                // 得到附件本身并至入BodyPart  
                part.setDataHandler(dataHandler);  
                // 得到文件名同样至入BodyPart  
                part.setFileName(MimeUtility.encodeText(dataSource.getName()));  
                multipart.addBodyPart(part);  
            }  
              
            sendMailMessage.setContent(multipart);  
            // 设置邮件发送的时间  
            sendMailMessage.setSentDate(new Date());  
            // 发送邮件  
            //Transport.send(sendMailMessage);  
            Transport transport = sendMailSession.getTransport("smtp");  
            transport.connect(senderInfo.getUserName(), senderInfo.getPassword());  
            Transport.send(sendMailMessage,sendMailMessage.getAllRecipients());  
            transport.close();  
              
            flag = true;  
        } catch (AddressException e) {  
            e.printStackTrace();  
        } catch (MessagingException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
          
        return flag;  
    }  
    
     /**
      * 以html格式发送邮件 (支持群发,带附件) 
      * @author：wujun
      * @email: jun.wu@baifendian.com
      * @return_type：boolean
      */
    @SuppressWarnings("static-access")
	public static boolean sendHtmlMail(MailSenderInfo senderInfo){  
        boolean flag = false;  
          
        // 判断是否需要身份验证  
        AuthenticatorChild authenticator = null;  
        Properties props = senderInfo.getProperties();  
        if(senderInfo.isValidate()){  
            // 如果需要身份认证，则创建一个密码验证器     
            authenticator = new AuthenticatorChild(senderInfo.getUserName(), senderInfo.getPassword());  
        }  
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session  
        Session sendMailSession = Session.getDefaultInstance(props, authenticator);  
          
        try {  
            // 根据session创建一个邮件消息  
            Message sendMailMessage = new MimeMessage(sendMailSession);  
            // 创建邮件发送者地址  
            Address from = new InternetAddress(senderInfo.getFromAddress());  
            // 设置邮件消息的发送者  
            sendMailMessage.setFrom(from);  
              
            // 创建邮件接收者地址  
            String[] tos = senderInfo.getToAddress();  
            if(tos != null && tos.length != 0){  
                InternetAddress[] to = new InternetAddress[tos.length];  
                // 设置邮件消息的发送者  
                for (int i = 0; i < tos.length; i++) {  
                    to[i] = new InternetAddress(tos[i]);  
                }  
                sendMailMessage.setRecipients(Message.RecipientType.TO, to);  
            }  
              
            // 设置邮件抄送者地址  
            String[] toCCs = senderInfo.getToCarbonCopyAddress();  
            if(toCCs != null && toCCs.length != 0){  
                InternetAddress[] toCC = new InternetAddress[toCCs.length];  
                // 设置邮件消息的发送者  
                for (int i = 0; i < toCCs.length; i++) {  
                    toCC[i] = new InternetAddress(toCCs[i]);  
                }  
                sendMailMessage.addRecipients(Message.RecipientType.CC, toCC);  
            }  
              
            // 设置邮件密送者地址  
            String[] toBCCs = senderInfo.getToBlindCarbonCopyAddress();  
            if(toBCCs != null && toBCCs.length != 0){  
                InternetAddress[] toBCC = new InternetAddress[toBCCs.length];  
                for (int i = 0; i < toBCCs.length; i++) {  
                    toBCC[i] = new InternetAddress(toBCCs[i]);  
                }  
                sendMailMessage.addRecipients(Message.RecipientType.BCC, toBCC);  
            }  
              
            // 设置邮件主题  
            sendMailMessage.setSubject(MimeUtility.encodeText(senderInfo.getSubject(),"utf-8","B"));  
            // 设置邮件内容  
            //sendMailMessage.setText(senderInfo.getContent());  
            Multipart multipart = new MimeMultipart();  
            // 邮件文本内容  
            if(senderInfo.getContent() != null && !"".equals(senderInfo.getContent())){  
                BodyPart part = new MimeBodyPart();  
                part.setContent(senderInfo.getContent(), "text/html;charset=utf-8");//设置邮件文本内容  
                multipart.addBodyPart(part);  
            }  
              
            // 附件  
            String attachFileNames[] = senderInfo.getAttachFileNames();  
            int leng = attachFileNames == null ? 0 : attachFileNames.length;  
            for (int i = 0; i < leng; i++) {  
                BodyPart part = new MimeBodyPart();  
                // 根据文件名获取数据源  
                DataSource dataSource = new FileDataSource(attachFileNames[i]);  
                DataHandler dataHandler = new DataHandler(dataSource);  
                // 得到附件本身并至入BodyPart  
                part.setDataHandler(dataHandler);  
                // 得到文件名同样至入BodyPart  
                part.setFileName(MimeUtility.encodeText(dataSource.getName()));  
                multipart.addBodyPart(part);  
            }  
              
            sendMailMessage.setContent(multipart);  
            // 设置邮件发送的时间  
            sendMailMessage.setSentDate(new Date());  
            // 发送邮件  
            //Transport.send(sendMailMessage);  
            Transport transport = sendMailSession.getTransport("smtp");  
            transport.connect(senderInfo.getUserName(), senderInfo.getPassword());  
            transport.send(sendMailMessage,sendMailMessage.getAllRecipients());  
              
            // 关闭transport  
            transport.close();  
              
            flag = true;  
        } catch (AddressException e) {  
            e.printStackTrace();  
        } catch (MessagingException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
          
        return flag;  
    }  
      
    
    public static boolean sendMail(WorkTime work, String pwd){
    	MailSenderInfo mailSender = new MailSenderInfo();
    	SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	mailSender.setUserName(work.getUserName());  // eg:jun.wu@baifendian.com
    	mailSender.setPassword(pwd); // eg: 123456
    	mailSender.setFromAddress("jun.wu@baifendian.com");
    	mailSender.setToAddress(new String[]{"jun.wu@baifendian.com"});
    	mailSender.setToCarbonCopyAddress(new String[]{"mingyi.yu@baifendian.com"});
    	mailSender.setSubject(work.getUserName()+work.getTypename()+work.getMailwithblobs().getTypename());
    	StringBuffer body = new StringBuffer();
    			
    	String table = "<table "
    			+ "width=\"100%\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" style=\"align:center;text-align:center\">"
    			+ "<tr>"
    			+ "<td>申请人</td>"
    			+ "<td>申请类型</td>"
    			+ "<td>开始时间</td>"
    			+ "<td>结束时间</td>"
    			+ "<td>共计小时</td>"
    			+ "<td>申请邮件内容</td>";
    	body.append(table);
    	
    	//判断如果是审核,就把审核意见加入
    	if(work.getMailwithblobs().getType().equals(2)){
    		String tds =  "<td>审批意见</td><td>审批结果</td>";
    		body.append(tds);
    	}
    	
    	
    	String str = "</tr>"
 			   + "<tr>";		 
    	body.append(str);	 
    	
    	String value =  "<td>"+work.getUserName()+"</td>"
    			+ "<td>"+work.getTypename()+"</td>"
    			+ "<td>"+simp.format(work.getWorktimeBegin())+"</td>"
    			+ "<td>"+simp.format(work.getWorktimeEnd())+"</td>"
    			+ "<td>"+work.getTotal()+"</td>"
    			+ "<td>"+work.getMailwithblobs().getContents()+"</td>";
    	body.append(value);
    	
    	//判断如果是审核,就把审核意见加入
    	if(work.getMailwithblobs().getType().equals(2)){
    		String value2 = "<td>"+work.getMailwithblobs().getApproveContent()+"</td>";
    		body.append(value2);
    		String aduit_name="";
    		if("1".equals(work.getAuditStatus())){
    			aduit_name="审批通过";
    		}else if("2".equals(work.getAuditStatus())){
    			aduit_name="审批拒绝";
    		}
    		body.append("<td>"+aduit_name+"</td>");
    	}
    	 
    	
    			 
    	String end =  "</tr>"
    			+ "</table>"; 
    	
    	body.append(end);
    	
    	mailSender.setContent(body.toString());
		return MailSender.sendHtmlMail(mailSender);
    	
    }
    
    
    
    
    
    public static void main(String[] args) {  
        MailSenderInfo mailInfo = new MailSenderInfo();  
//        mailInfo.setMailServerHost("smtp.baifendian.com");  
//        mailInfo.setMailServerPort("25");  
//        mailInfo.setValidate(true);  
        mailInfo.setUserName("jun.wu@baifendian.com");  
        mailInfo.setPassword("******");// 您的邮箱密码  
        mailInfo.setFromAddress("jun.wu@baifendian.com");  
        String[] to = {"jun.wu@baifendian.com","mingyi.yu@baifendian.com"};  
        mailInfo.setToAddress(to);  
        String[] toCC = {"wujun20112011@163.com","472961209@qq.com"};  
        mailInfo.setToCarbonCopyAddress(toCC);  
//        String[] toBCC = {"*******@sina.com"};  
//        mailInfo.setToBlindCarbonCopyAddress(toBCC);  
//        mailInfo.setAttachFileNames(new String[]{"C:/BD-OS用户使用手册-V2.0-0619.doc","C:/wc.jar"});  
        mailInfo.setSubject("发送HTML邮件");  //邮件标题
        String body = "<table width=\"80%\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" style=\"align:center;text-align:center\"><tr><td>你好,测试邮件不用理会！</td><td>你好,测试邮件不用理会！</td><td>你好,测试邮件不用理会！</td></tr></table>";  
        mailInfo.setContent(body);  //邮件主体
        // 这个类主要来发送邮件  
//        System.out.println((MailSender.sendHtmlMail(mailInfo)==true)?"发送成功！":"发送失败！");//发送文体格式  
    }  
}
