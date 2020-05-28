g3J  ~ BilShare ~ A web app that enables college students to sell and buy second hand materials.

Project is currently up and working. However there are some remaining parts to be done. When the user runs the program for the first time the signup page is available and the user is able to sign up via the form, however users are not able to sign up twice on the same machine (at the same runtime environment) at the moment. Although the users are able to upload images we are not able to display them in our advert list view. Also, we were not able to create a chat view in which the users would be able to directly contact the seller of a product. Instead, we have decided the users would enter their contact details to the additional info section of the product form. 

We have used Spring Boot (version 2.2.0) and Vaadin (version 14.1.27) framework for our application. For the database, we have used Java Persistence API (JPA) (version. 2.2.6) which is an interface specification that describes the management of relational data in applications, Hibernate (version 5.4.6) which is a mapping tool that enables us to interact with the database and MySQL (version 8.0.2). Also, we have used Maven (version 3.6.3) as our project management and comprehension tool. In order to connect our database to a cloud we have used Amazon Relational Database Service (RDS). For enabling users from any network to easily connect and use our application we have used Amazon Elastic Beanstalk and connected our application to a cloud. Also, in order to change our domain to "www.bil-share.com" we have used Amazon Route 53.

We split into groups of 2 Berk and Oğulcan worked on sign up and login pages, Elif and Yağmur worked on MyProfile and Inventory pages, Melih and İdil worked on About and ContactUs pages. Also Berk and Oğulcan worked on creating the, “UserRepository” interface, “UserService” class, “AbstractEntity” class and security classes. Yağmur and Elif worked on creating the “User” class, “Product” class, “ProductRepository” interface, “ProductService” class and “CurrentUser” class. Melih and İdil worked on creating the “Category” and “Type” classes. 

~ INSTALLATION GUIDE ~

Prerequisites

The project can be imported into the IDE of your choice, with Java 8 or 11 installed, as a Maven project. But additionally you need node.js installed in your System, and available in your PATH. See the Node.js page for the installation instructions.
---------------------------------------------------------------------------
Running the Project in Developer Mode

Navigate to the com.bilshare.src.main.java.Applicaton class and run it as a Java application.
Wait for the application to boot and start
Open http://localhost:5000/ to view the application
Default credentials are “admin” for the username and “password” for the password field.

Also you can open www.bil-share.com from your browser in order. to open and use the applicaiton.
