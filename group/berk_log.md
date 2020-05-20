# CS102 ~ Personal Log page ~
****
## Mehmet Berk Turkcapar 
****

On this page I will keep a weekly record of what I have done for the CS102 group project. This page will be submitted together with the rest of the repository, in partial fulfillment of the CS102 course requirements.

### ~ 25.04.2020 ~
As opposed to our previous intention, we have decided it would be much better to create a web-app rather than a desktop app. We have found a framework called Vaadin which enables the developers to create web-apps with Java. We believe it would be the best fit since most of us are not really experienced at html. We have asked Mr. Davenport and we are waiting for his advice.

### ~ 28.04.2020 ~
After getting a confirmation from Mr. Davenport we have focused on learning more about Vaadin. We have started watching the tutorial on YouTube about the Vaadin 14. However, as I watch more videos I realize there is a lot to learn such as Maven, hibernate, MySQL, JPA and so on. But, I must say the idea of creating a web app is much more attractive for me rather than a desktop app. From my little experience with Vaadin so far, I believe the UI looks really good. We have splitted into 3 teams in our 6 member group and assigned each team with a task to do. Me and Ogulcan started working on the Sign-up Page and the Login Page. 

### ~ 01.05.2020 ~
Most of the UI seems to be looking good. However we realize there is a much bigger concern: DATABASE. We are planning to use MySQL and we decided we should be researching about how to connect MySQL to our Vaadin application. I am curious to learn about database since I believe it is an important of any app. I will try to download MySQL to my computer and see how I can integrate the code with the database. Also, we have successfully set up version control to our IDE and we are able to pull from and commit, push to our project repository. 

### ~ 05.05.2020 ~
I have successfully installed MySQL to my computer. Although I couldn't really understand at the beginnig, I was able to create databases and tables from the terminal. However, it seems like connecting the app to the database won't be easy. I have started creating repository and service classes for connection to database.   

### ~ 11.05.2020 ~
We have connected our database to a cloud so that all users would be able to have the same data when using the application. Ogulcan suggested we used an app called Sequel Pro in order to manage our database and, from my initial experience, it is much more efficient than using terminal. We have used AWS in order to connect it to a cloud. By using the JPA Repository class, we are able to save, delete and update products in our database. Now, we have to implement a similar database connection for the log-in page and sign-up page. However, we are not able to save the image to our database just yet. 

### ~ 18.05.2020 ~
After having some difficulties with saving new users to our database, we eventually were able to create new users via the signup page. It seems like it was a minor issue about the properties of User class. Me and Ogulcan worked on authenticating users according to the user information from our database. Now we are able to authenticate only the users who are saved to our database. Also, Elif and Yagmur were able to get the current user of our app. So, we will be able to automatically assign the seller when a new advert is added and show the adverts of the current user in the MyProfile page. Oğulcan had the idea to create links to our LinkedIn accounts in About page. So, we added them to the view. Now, we will be creating our video. 
****
