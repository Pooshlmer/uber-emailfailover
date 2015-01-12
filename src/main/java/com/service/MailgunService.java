package com.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import com.email.MailData;

public class MailgunService implements EmailService{

  private String name = "Mailgun";
  
  public String getName() {
    return name;
  }

  // Sends an email, returns true if successful and false otherwise
  public boolean sendEmail(MailData mData) {
    Client client = ClientBuilder.newClient();
    HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("api", System.getProperty("mailgunApikey"));
    client.register(feature);
    WebTarget webtarget =
        client.target(System.getProperty("mailgunServer") +
            "/messages");
    MultivaluedMap<String, String> formData = new MultivaluedHashMap<String, String>();
    formData.add("from", mData.getFromAddress());
    formData.add("to", mData.getToAddress());
    formData.add("subject", mData.getSubject());
    formData.add("text", mData.getBody());
    Response response = webtarget.request().post(Entity.form(formData));
    return (response.getStatus() == 200);
  }

}