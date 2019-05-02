import { Component, OnInit } from '@angular/core';
import { QuizService } from 'src/app/services/quiz.service';
import { Question } from 'src/app/datamodel/question.datamodel';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  question:Question;
  constructor(private quizservice:QuizService) { }

  ngOnInit() {
  }
  deleteQns(){
    this.quizservice.deleteQns(this.question);
  }

}
