package com.service;

import com.email.MailData;

public interface EmailService {
  
  public boolean sendEmail(MailData mData);  
  
  public String getName();
}
