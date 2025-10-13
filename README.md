# Cookbook Website Backend

> This personal project is to showcase a website's backend using Java Spring Boot
<hr>

## Website Link

[Cookbook Website](https://creative-creponne-51f429.netlify.app/)
The website experiences significant delays and lags because I am using free-tier services. Thank you for your understanding 🙇. 

## Tech Stack

* **Java Spring Boot** as the framework
* **MongoDB** as the main database to store cookbook details
* **Backblaze B2 Cloud Storage** for storing cookbook image
* **Railway** free tiers for hosting the backend
* **Netlify** free tiers for hosting the frontend

## Features

* RESTful API with appropriate HTTP status & error codes for HTTP GET, POST, PUT and DELETE methods
* Proper separation of concerns between Repository, Service and Controller class
* Utilization of OOP principles through interfaces, inheritance, and object creation
* Implementation of Java Spring Boot's One-to-Many relationship between documents in MongoDB
* Hidden environment variables/keys by setting up a .env file and adding the proper exclusions in .gitignore
* Custom CORS configuration
* Custom JSON serializer for MongoDB's objectId
* Custom exception class & message
* Sending images as Base64 strings (I want to send images via URL, but the Backblaze B2 free tier storage only allows private bucket. Thus, to avoid authenticating the frontend to access the private bucket, I authenticated my backend to retrieve the images and send them back as Base64 string, hence why the website might be experiencing heavy lags)
* This repository is containerized into a docker image

## Future Features to be Implemented

* Adding methods to authenticate users by providing their username, password, and email for changing password
* Integration with SQL databases for storing username and password, as SQL databases offer better reliability and stability due to their ACID properties
* Secure password storage by hashing passwords and salts before storing them in the database
* Sanitizing user inputs before storing them in database
* Improved version control and main branch protection
* Application testing through unit tests, user tests and load tests
* Automatic deployment
* Further integration with other free-tier services
