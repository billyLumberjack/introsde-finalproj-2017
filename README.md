# introsde-finalproj-2017
Final project for the course of introduction to service design and engineering.

## General Description
I implemented a modular web service application where each user can save data about her diet or physical activity. Furthermore It's possibile to find useful information about foods, exercises and statistics.

I wanted to keep the data structures as elastic as possible in order to leave the user free to save the info he's interested in.

## Communication schema
![Alt text](storage.png?raw=true "Communication architecture")

## Components

* Client
Using SOAP technology offers a basic demonstration about the application via a command line interface.

* Process Centric Service
Provides the access to the system functionalities to fronted applications, it basically farwards all the requests to the right Service of the application.
PCS can be used both via SOAP and REST

* Storage Service
Retrieves data from the external adapter and from the database service it works with rest rest using XML and JSON

* Business Logic Service
Computes many indexes about the users physical parameters and allows to compute a calories balance

* External Adapter Service
Integrate the system with an external service in order to provide detailsed information about food and physical/daily activities

* Database Service
Handle the interaction with the lower noSql database using EclipseLink JPA implementation

* MongoDb Server
Host the NoSql MongoDb Server

## Documentation
The documentation is in each project folder, docs/apidocs/index.html

## Student
Samuele Malavasi
mat. 182551
samuele.malavasi@studenti.unitn.it
