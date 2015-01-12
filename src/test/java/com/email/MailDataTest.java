package com.email;

import static org.junit.Assert.*;

import org.junit.Test;

public class MailDataTest {
  @Test
  public void testValidate() {
    MailData mData = new MailData();
    mData.setToAddress("to");
    mData.setFromAddress("from");
    mData.setSubject("subject");
    mData.setBody("body");
    
    assertTrue(mData.validate());
  }
  
  @Test
  public void testValidateLong() {
    MailData mData = new MailData();
    StringBuffer longString = new StringBuffer();
    for (int i = 0; i < 1000; i++) {
      longString.append("alskjdlkasjgkalsdjglkasjklajglkdajsgklajg");
    }
    mData.setToAddress(longString.toString());
    mData.setFromAddress("from");
    mData.setSubject("subject");
    mData.setBody("body");
    
    assertFalse(mData.validate());
  }
}
