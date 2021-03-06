# widget-backend

1) I have changed the project structure to make it more organized and maintainable. The code is separated into controller, model, repository and dto packages.
2) The user API has been added to create a new user with a random UUID each time. For the widget, when serving the questions to users, a session can be maintained on the client side. On the server, we can create a hashmap where questionId is the key and a Boolean indicating if the question is served to the current user or not. 
3) Validations can be added either using a DAO class or inside the controller endpoint to validate if entries are duplicate or invalid.   
4) Project can be run using 
```shell
	cd target/
	java -jar demo-0.0.1-SNAPSHOT.jar
```
Here are some of the given queries and some new ones:

Create a user:
```shell
curl --header "Content-Type: application/json" --request POST --data '{  "userName" : "Test" }' http://localhost:8080/users/create
```
Create a site:
```shell
curl --header "Content-Type: application/json" --request POST --data '{  "url": "www.example.com" }' http://localhost:8080/sites
```

Create the Trivia Question for the Site
```shell
>curl --header "Content-Type: application/json" --request POST --data '{"siteId":1, "question": "how many toes does a pig have?",  "questionType": "trivia"}' http://localhost:8080/questions/create
```

Create some responses for the question
```shell
>curl --header "Content-Type: application/json" \
  	 --request POST \
  	 --data '{"answer": "4 toes","isCorrectAnswer": true}' \
  	 http://localhost:8080/questions/1/answers

>curl --header "Content-Type: application/json" \
  	 --request POST \
  	 --data '{"answer": "3 toes","isCorrectAnswer": false}' \
  	 http://localhost:8080/questions/1/answers
  	 
>curl --header "Content-Type: application/json" \
 	 --request POST \
 	 --data '{"answer": "The do not have toes silly","isCorrectAnswer": false}' \
 	 http://localhost:8080/questions/1/answers
```
5) In the Question Entity and the corresponding table in DB, a question type column has been added to handle different types of questions. Since the answer is mapped to the question, answer can be confirmed to be correct or incorrect. Answers can be verfied to be correct using the /answers API
6) For security purposes, Repository references which are autowired need to be private as they are class variables.
7) To scale the widget for multiple types of questions and multiple users, we can use a Redis for storing data. Since it provides persistence as well as fast speeds due to use of main memory to store data.


