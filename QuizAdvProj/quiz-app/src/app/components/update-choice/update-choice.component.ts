import { Component, OnInit } from '@angular/core';
import { Question } from 'src/app/datamodel/question.datamodel';
import { Choice } from 'src/app/datamodel/choice.datamodel';
import { QuizService } from 'src/app/services/quiz.service';

@Component({
  selector: 'app-update-choice',
  templateUrl: './update-choice.component.html',
  styleUrls: ['./update-choice.component.css']
})
export class UpdateChoiceComponent implements OnInit {

  question: Question;
  choice:Choice;

  constructor(private quizService: QuizService) { }

  ngOnInit() {
  }

  updateChoices(){
    this.choice.qid = this.question.id;
    this.quizService.updateChoices(this.choice);
  }
}
