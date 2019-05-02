import { AdminComponent } from './components/admin/admin.component';
import { ChoiceComponent } from './components/choice/choice.component';
import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { QuizListComponent } from './components/quiz-list/quiz-list.component';
import { QuizFormComponent } from './components/quiz-form/quiz-form.component';
import { DisplayListComponent } from './components/display-list/display-list.component';
import { UpdateQuestionComponent } from './components/update-question/update-question.component';
import { UpdateChoiceComponent } from './components/update-choice/update-choice.component';
import { DeleteComponent } from './components/delete/delete.component';
import { AddQuestChoicesComponent } from './components/add-quest-choices/add-quest-choices.component';
const routes: Routes = [
    {
      path: 'admin',
      component: AdminComponent
    }, {
      path: 'choice',
      component: ChoiceComponent
    }
    , {
      path: 'quiz',
      component: QuizListComponent
    }
  ];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }