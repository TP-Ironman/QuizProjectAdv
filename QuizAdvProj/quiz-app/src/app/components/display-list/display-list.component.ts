import { Component, OnInit, Input, SimpleChanges } from '@angular/core';
import { Question } from 'src/app/datamodel/question.datamodel';
import { QuizService } from 'src/app/services/quiz.service';

@Component({
  selector: 'app-display-list',
  templateUrl: './display-list.component.html',
  styleUrls: ['./display-list.component.css']
})
export class DisplayListComponent implements OnInit {

  @Input()
  questions:Question[];


  ngOnChanges(changes: SimpleChanges){
    this.questions = changes.questions.currentValue;
  }
  
  constructor(private service: QuizService) { }

  ngOnInit() {
    this.service.displayAll().subscribe(questions =>{
      this.questions = questions;
    });
  }

}
