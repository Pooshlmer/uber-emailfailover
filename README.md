Web Email Form

This application takes in a mail message from the user and sends it to multiple
mail services in series, moving from service to service if one fails. It is
easy to expand to as many as you like, just provide a class extending
com.service.EmailService and add it to the list in SendEmailServlet->
initializeEmailServices(). It focuses on the backend.

INITAL CONFIGURATION:
To make it work, fill in these lines:
<property name="sendgridUser" value=""/>
<property name="sendgridPassword" value=""/>
<property name="mailgunApikey" value=""/>
<property name="mailgunServer" value=""/>
in src/main/webapp/WEB-INF/appengine-web.xml.

It uses Java/JSP and hosted on Google App Engine. I chose this because
I wanted to try Google App Engine and didn't want to learn a language
at the same time with the deadline. Most of the code is mine, some of
the config files were seeded by the setup for Google.

It is fairly simple overall. It only has the single front end page with
basic validation client side using validate.js. I don't bother with much 
validation on the back end as I am just submitting strings to a service, 
and if a bot gets an exception it doesn't matter much. I used the provided
library for Sendgrid and the Jersey library to connect to Mailgun.

To test the failover, use a blank subject. Sendgrid rejects this while
Mailgun accepts it.

I was unable to get to integration testing or Selenium testing of the front
end. On the backend side I only did a single test on validation and didn't
do the mailing functions because they only do one thing I didn't want to
run automatically. Other things I could have done were a more fleshed out
UI and other mailing services.

My Github has another project, scala-play-crud-example, which has a CRUD app
I wrote to learn the Scala/Play web framework.

My LinkedIn is at https://www.linkedin.com/profile/view?id=44287787.

The hosted application is at https://innate-sunrise-819.appspot.com.