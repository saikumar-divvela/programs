/*
 * Created on Mar 29, 2006 TODO To change the template for this generated file
 * go to Window - Preferences - Java - Code Style - Code Templates
 */
//package com.mobiapps.utils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.UnsupportedDataTypeException;
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
import javax.naming.InitialContext;
import javax.naming.NamingException;

//import org.apache.log4j.Logger;

/**
 * @author ragil TODO To change the template for this generated type comment go
 *         to Window - Preferences - Java - Code Style - Code Templates
 */
public class EmailService
{

    //private static Logger log           = Logger.getLogger("com.mobiapps.utils.EmailService");

    private String        strFromMailId = "saikumar_d@yahoo.com";                                         // Default
                                                                                              // Email
                                                                                              // Id.
                                                                                              // To
                                                                                              // know
                                                                                              // people
                                                                                              // from
                                                                                              // where

    private String        strFromName   = "SSS";                                         //Default
                                                                                              // Name

    private String        contentType   = "text/plain";

    public EmailService()
    {

    }

    public EmailService(String strFromMailId, String strFromName)
    {
        this.strFromMailId = strFromMailId;
        this.strFromName = strFromName;
    }

    public EmailService(String strFromMailId, String strFromName, String contentType)
    {
        this.strFromMailId = strFromMailId;
        this.strFromName = strFromName;
        this.contentType = contentType;
    }

    public EmailService(String contentType)
    {
        this.contentType = contentType;
    }

    public boolean sendMail(String to, String strMsgSubject, String strMsgText)
            throws MessagingException
    {
        System.out.println("hi2 ");
        String[] arEmailTo =
        { to };
        return sendMail(arEmailTo, null, strMsgSubject, strMsgText);
    }

    public boolean sendMail(String to, String cc, String strMsgSubject,
            String strMsgText) throws MessagingException
    {
        System.out.println("hi 3 ");
        String[] arEmailTo =
        { to };
        String[] arEmailcc =
        { cc };
        return sendMail(arEmailTo, arEmailcc, strMsgSubject, strMsgText);
    }

    public boolean sendMail(String[] toList, String strMsgSubject,
            String strMsgText) throws MessagingException
    {

        return sendMail(toList, null, strMsgSubject, strMsgText);
    }

    public boolean sendMail(String[] toList, String[] ccList,
            String strMsgSubject, String strMsgText) throws MessagingException
    {

        System.out.println("hi 4 ");
        boolean sendResult = false;

        try
        {

            //Set the host smtp address
			 java.util.Properties props = System.getProperties();
			 props.put("mail.smtp.host", "corp.internal.symbol.com");
			 // create some properties and get the default Session
		    Session session1 = Session.getDefaultInstance(props, null);
            session1.setDebug(false);
            //Message msg = new MimeMessage(session());
            Message msg = new MimeMessage(session1);
            System.out.println("hi !!!!!!!!! ");
            String cmpFromId = this.strFromName + " <" + this.strFromMailId
                    + ">";
            InternetAddress from = new InternetAddress(cmpFromId);

            msg.setFrom(from);
            System.out.println("hi 5 ");
            InternetAddress[] address = internetAddress(toList);

            msg.setRecipients(Message.RecipientType.TO, address);

            System.out.println("hi 6");

            if (ccList != null)
            {
                InternetAddress[] ccAddress = internetAddress(ccList);

                msg.setRecipients(Message.RecipientType.CC, ccAddress);
            }

            msg.setSubject(strMsgSubject);
            System.out.println("hi 7");

            msg.setContent(strMsgText, this.contentType);
            System.out.println("hi 8");

            //Transport.send(msg,address);
            //System.out.println("after sending");

            Transport.send(msg);
			System.out.println("hi 9");

            sendResult = true;
            System.out.println("message sent successfully");
            //log.info("....MAIL WAS SUCCESSFULLY SEND");
        }
        catch (MessagingException me)
        {

            sendResult = false;
            System.out.println("Exception occurred:"+me.getMessage());
            me.printStackTrace();
            //log.info("...FAILED TO SEND THE EMAIL");
            //log.error(me);

        }
        /*
        catch (NamingException ne)
        {

            sendResult = false;
            //log.info("...NAMING EXCEPTION");
            //log.error(ne);

        }*/
        catch (Exception e)
       {

          sendResult = false;
          //log.info(e.getMessage());
           System.out.println("Exception occurred:"+e.getMessage());
           e.printStackTrace();

       }



   // catch (UnsupportedDataTypeException e)
     //   {
       //    log.info(e.getMessage());
        // e.printStackTrace();

      // }


     return sendResult;

    }

    public boolean sendMailWithAttachment(String to, String strMsgSubject,
            String strMsgText, String fileName) throws MessagingException
    {
        String[] arEmailTo =
        { to };
        return sendMailWithAttachment(arEmailTo, null, strMsgSubject,
                strMsgText, fileName);
    }

    public boolean sendMailWithAttachment(String to, String cc,
            String strMsgSubject, String strMsgText, String fileName)
            throws MessagingException
    {
        String[] arEmailTo =
        { to };
        String[] arEmailcc =
        { cc };
        return sendMailWithAttachment(arEmailTo, arEmailcc, strMsgSubject,
                strMsgText, fileName);
    }

    public boolean sendMailWithAttachment(String[] toList,
            String strMsgSubject, String strMsgText, String fileName)
            throws MessagingException
    {
        return sendMailWithAttachment(toList, null, strMsgSubject, strMsgText,
                fileName);
    }

    public boolean sendMailWithAttachment(String[] toList, String[] ccList,
            String strMsgSubject, String strMsgText, String fileName)
            throws MessagingException
    {
        boolean sendResult = false;
        try
        {

            Message msg = new MimeMessage(session());

            String cmpFromId = this.strFromName + " <" + this.strFromMailId
                    + ">";
            InternetAddress from = new InternetAddress(cmpFromId);
            msg.setFrom(from);

            InternetAddress[] address = internetAddress(toList);

            msg.setRecipients(Message.RecipientType.TO, address);

            if (ccList != null)
            {
                InternetAddress[] ccAddress = internetAddress(ccList);

                msg.setRecipients(Message.RecipientType.CC, ccAddress);
            }

            msg.setSubject(strMsgSubject);

            msg.setContent(strMsgText, this.contentType);

            BodyPart messageBodyPart = new MimeBodyPart();

            //		 Fill the message
            messageBodyPart.setText(strMsgText);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            //		 Part two is attachment
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(fileName);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);

            //		 Put parts in message
           // msg.setContent(multipart);
            Transport.send(msg);
            sendResult = true;
            //log.info("MAIL WAS SUCCESSFULLY SEND");
        }
        catch (MessagingException me)
        {

            sendResult = false;
            //log.info("FAILED TO SEND THE EMAIL");
            //log.error(me);

        }
        catch (NamingException ne)
        {

            sendResult = false;
            //log.info("NAMING EXCEPTION");
            //log.error(ne);

        }
        return sendResult;
    }

    private InternetAddress[] internetAddress(String[] strEmailTo)
            throws AddressException
    {
        InternetAddress[] address = new InternetAddress[strEmailTo.length];
        for (int i = 0; i < strEmailTo.length; i++)
        {
            address[i] = new InternetAddress(strEmailTo[i]);
        }
        return address;
    }

    private Session session() throws NamingException
    {
        return (Session) new InitialContext().lookup("java:/Mail");
    }

    public static void main(String arg[]) throws Exception
    {
        System.out.println("hi 1");
        new EmailService().sendMail("saikumar_d@yahoo.com", "test", "test");
        //new Email().sendMailWithAttachment("ragil@renaissance-it.com","test","test","D:\\Achumaman.jpg");
        //new Email().sendMailWithAttachment("binoy.philip@renaissance-it.com","test","test","D:\\Achumaman.jpg");
    }

   }