import { Component, OnInit } from '@angular/core';
import { Question } from 'src/app/datamodel/question.datamodel';
import { Choice } from 'src/app/datamodel/choice.datamodel';
import { QuizService } from 'src/app/services/quiz.service';

@Component({
  selector: 'app-add-quest-choices',
  templateUrl: './add-quest-choices.component.html',
  styleUrls: ['./add-quest-choices.component.css']
})
export class AddQuestChoicesComponent implements OnInit {

  question:Question;
  choices:Choice;
  constructor(private quizService : QuizService) { }

  ngOnInit() {
  }

  addQnsChoices (question : Question) {
    console.log("=> saveQuestion", 'jhhj');
    this.question.mp.set(question.choiceA,question.choiceAisC);
    this.question.mp.set(question.choiceB,question.choiceBisC);
    this.question.mp.set(question.choiceC,question.choiceCisC);
    this.question.mp.set(question.choiceD,question.choiceDisC);
    this.quizService.addQnsChoices(this.question);
    

   }


}
