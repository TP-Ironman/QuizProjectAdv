import { Injectable } from '@angular/core';
import { Question } from '../datamodel/question.datamodel';
import { Http, Response } from '@angular/http';
import { Observable, of } from 'rxjs';
import { map, catchError} from 'rxjs/operators';
import { Admin } from '../datamodel/admin.datamodel';
import { Choice } from '../datamodel/choice.datamodel';
 
const endpoint = 'http://localhost:8080/quiz-rest-services/rest';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  constructor(private http: Http) {
   }

   getQuestionList(): Observable<Question[]>{
     //todo fetch
    // return of(this.questions);
    return this.http.get("http://localhost:8080/quiz-rest-services/quiz/questions/questions").pipe(
      map(
        (response) => response.json().map(
          (item) => new Question(item.id, item.questionLabel,item.diff)
      )
    ), catchError(err => of('error in get')));

   }

   saveQuestion (question : Question) {
    console.log("=> saveQuestion", 'jhhj');
    question.questionLabel='jdsfdjs';
    question.id=1;
    return this.http.post("http://localhost:8080/quiz-rest-services/quiz/questions/addQns", question).pipe(
      map(
        (response) => response.headers.get('Location')
    ), catchError(err => of('error : ${err}')));
    

   }

    loginAdmin(admin:Admin){
      boolvalue: Boolean;
      console.log("dshgfdhsg");
      return this.http.post("http://localhost:8080/quiz-rest-services/quiz/admin/login", admin).pipe(
        map(
          (response) => response.headers.get('Location')
      ), catchError(err => of('error : ${err}')));
      
    }

    displayAll(): Observable<Question[]>{
      //todo fetch
     // return of(this.questions);
     return this.http.get("http://localhost:8080/quiz-rest-services/quiz/questions/displayAll").pipe(
       map(
         (response) => response.json().map(
           (item) => new Question(item.qnId, item.questions, item.diff)
       )
     ), catchError(err => of('error in get')));
 
    }

    addQnsChoices(question : Question) {
      console.log("=> addQnsChoices", 'jhhsaddj');
      return this.http.post("http://localhost:8080/quiz-rest-services/quiz/questions/addQns", question).pipe(
        map(
          (response) => response.headers.get('Location')
      ), catchError(err => of('error : ${err}')));
      
  
     }
     updateQn(question : Question) {
      console.log("=> updateQuestion", 'jhhsaddj');
      return this.http.post("http://localhost:8080/quiz-rest-services/quiz/questions/updateQns", question).pipe(
        map(
          (response) => response.headers.get('Location')
      ), catchError(err => of('error : ${err}')));
      
  
     }
     updateChoices(choice: Choice){
      console.log("=> updateChoice", 'jhhsaddj');
      return this.http.post("http://localhost:8080/quiz-rest-services/quiz/choices/updateChoices", choice).pipe(
        map(
          (response) => response.headers.get('Location')
      ), catchError(err => of('error : ${err}')));
      
  
     }

     deleteQns(question : Question) {
      console.log("=> deleteQuestion", 'jhhsaddj');
      return this.http.post("http://localhost:8080/quiz-rest-services/quiz/questions/deleteQns22", question).pipe(
        map(
          (response) => response.headers.get('Location')
      ), catchError(err => of('error : ${err}')));
      
  
     }

}
