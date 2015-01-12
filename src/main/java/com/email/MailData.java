package com.email;

public class MailData {
  public String toAddress;
  public String fromAddress;
  public String subject;
  public String body;
  
  // Validation is done client side, and weird characters
  // are handled by the mail server, this is mainly
  // to avoid sending massive strings from bots
  public boolean validate() {
    return !(toAddress.length() > 500 || fromAddress.length() > 500 ||
        subject.length() > 500 || body.length() > 50000);
  }
  
  public String getToAddress() {
    return toAddress;
  }
  public void setToAddress(String toAddress) {
    this.toAddress = toAddress;
  }
  public String getFromAddress() {
    return fromAddress;
  }
  public void setFromAddress(String fromAddress) {
    this.fromAddress = fromAddress;
  }
  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }
  public String getBody() {
    return body;
  }
  public void setBody(String body) {
    this.body = body;
  }
}
