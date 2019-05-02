import { Component, OnInit } from '@angular/core';
import { Question } from 'src/app/datamodel/question.datamodel';
import { QuizService } from 'src/app/services/quiz.service';

@Component({
  selector: 'app-update-question',
  templateUrl: './update-question.component.html',
  styleUrls: ['./update-question.component.css']
})
export class UpdateQuestionComponent implements OnInit {

  question:Question;
  constructor( private quizservice:QuizService) {}

  ngOnInit() {
  }

  updateQn(){
    this.quizservice.updateQn(this.question);
  }

}
