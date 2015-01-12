package com.service;

import com.sendgrid.*;
import com.email.MailData;

public class SendGridService implements EmailService {
  
  private String name = "Sendgrid";
  
  public String getName() {
    return name;
  }
  
  // Sends an email, returns true if successful and false otherwise
  public boolean sendEmail(MailData mData) {
    SendGrid sendgrid = new SendGrid(System.getProperty("sendgridUser"), 
        System.getProperty("sendgridPassword"));

    SendGrid.Email email = new SendGrid.Email();
    email.addTo(mData.getToAddress());
    email.setFrom(mData.getFromAddress());
    email.setSubject(mData.getSubject());
    email.setText(mData.getBody());

    try {
      SendGrid.Response response = sendgrid.send(email);
      return response.getStatus();
    }
    catch (SendGridException e) {
      System.err.println(e);
      return false;
    }
  }
}