# QuizProjectAdv
This is a quiz project with quiz-core(Spring, Hibernate, JUnit), quiz-rest-services(Rest), quiz-app(AngularJS) services.

## quiz-core:
This is the back end service with below classes.

### DAO:
 * AdminRefDAO (Authentication of admin)
 * ChoicesRefDAO (Deals with choices adding, update, delete)
 * QuestionsRefDAO (Deals with questions create, update, delete)
 * QuizServiceClass (deals with quiz display)
 * StudentRefDAO (Delas with student login, taking quiz and displaying score)


### DataModel:
 * AdminDetails(Providing Admin Auth)
 * ChoicesProvided(Choices provided for a question id) 
 * QuestionsPosed(Questions, Difficulty level for a question id)
 * StudentDetails(Student id and score)

## quiz-app:
This is the front end that is done using Angulas JS

### components:
 * add-quest-choices (create questions and choices)
 * admin(admin login)
 * delete (delete questions and choices)
 * display-list (display all questions and ansers)
 * quiz-list (display quiz)
 * update choice (update choice)
 * update question (update question)

### datamodel:
 * admin (admin services)
 * choice 
 * question

### services:
 * quiz services

app-routing.modules.ts for routing the components

## quiz-rest-services:
This is the middle ware between front end and back end communicating the requests and responses.

### resources:
 * AdminForJS (connecting js object)
 * AdminResource (Admin service)
 * ChoiceForJs
 * ChoiceResource (Choice service)
 * QuestionForJs
 * QuestionResource (Question service)
 * StudentResource (Student service)
