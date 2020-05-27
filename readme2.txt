g3J  ~ BilShare ~ A web app that enables college students to sell and buy second hand materials.


Project is currently up and working. However there are some remaining parts to be done. When the user runs the program for the first time the signup page is available and the user is able to sign up via the form, however users are not able to sign up twice on the same machine (at the same runtime environment) at the moment. Although the users are able to upload images we are not able to display them in our advert list view. Also, we were not able to create a chat view in which the users would be able to directly contact the seller of a product. Instead, we have decided the users would enter their contact details to the additional info section of the product form. We split into groups of 2 Berk and Oğulcan worked on sign up and login view, Elif and Yağmur worked on MyProfile and Inventory view, Melih and İdil worked on About and ContactUs view.






~ INSTALLATION GUIDE ~
Prerequisites
The project can be imported into the IDE of your choice, with Java 8 or 11 installed, as a Maven project. But additionally you need node.js installed in your System, and available in your PATH. See the Node.js page for the installation instructions.
Dependencies
Dependencies are managed by Vaadin platform and vaadin-maven-plugin.

Running the Project in Developer Mode
Navigate to the com.bilshare.src.main.java.Applicaton class and run it as a Java application.
Wait for the application to boot and start
Open http://localhost:5000/ to view the application
Default credentials are “admin” for the username and “password” for the password field.
Structure
Vaadin web applications are full-stack and include both client-side and server-side code in the same project.
Directory
Description
frontend/
Client-side source directory
    views/
UI views Web Components (TypeScript / HTML)
    styles/
Styles directory (CSS)
com.bilshare/src/main/java
Server-side source directory
    Application.java
Server entrypoint

Branching information
master the latest version of the starter, using the latest platform version

