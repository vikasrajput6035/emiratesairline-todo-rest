# emiratesairline-todo-rest

A sample todo rest webservice. It includes following features:

1. Add new todo task
2. "mark as complete" any todo task
3. Show all pending task
4. Show all completed task
5. Show all task list
5. Allow to delete any task

This project is developed using Spring Boot and MongoDB. Please follow below steps to install this project:

1. Download the project and extract the zip file
2. Import the project in your favourite IDE (in my case it was eclipse IDE)
3. Install all the dependencies required for this project using Maven install
4. Run the TodoStandaloneApp.java as simple java application and you are good to go

How to setup MongoDB:

This project requires MongoDB. so please install it you can install it from the official website.
After installing mongodb executable file from the official site, please download any good IDE for quering MongoDB document base DB.

Download mongo db from:
https://www.mongodb.com/download-center?jmp=nav#community

Download mongo db studio 3T IDE from:
https://studio3t.com/download/

After installing Mongo installer in your machine. Go to the installation location in your machine in my case it is  C:\Program Files\MongoDB\Server\3.4\bin . It could be different depending upon your installation. Inside bin folder there’s a executable file called mongod. Please double click the file and it will open a command line window.

You don’t even need to open the Mongodb UI for firing query. And you are not required to create the database explicitly, mongodb will do it for yourself.

So after setting maven install and mongodb installation in your machine you can run the web-service on your browser. In my case it was running in http://localhost:8080. 
Following rest apis are there in this TODO application
Root Url of Webservice:
1.	Url and parameter to create new todo
http://localhost:8080/todo/create
{      
    "title": "Todo Tile comes here",
    "description": "Todo description comes here",
}

2.	Url to get list of all todo list
http://localhost:8080/todo/status/all
3.	Url to get list of all Pending todo list

http://localhost:8080/todo/status/Pending

4.	Url to get list of all Completed todo list

http://localhost:8080/todo/status/Completed

5.	Url and parameter to delete any todo instance

http://localhost:8080/todo/delete/{id}

6.	Url and parameter to mark complete any todo instance

http://localhost:8080/todo/markcomplete/
{      
    "title": "Todo Tile comes here",
    "description": "Todo description comes here",
}

