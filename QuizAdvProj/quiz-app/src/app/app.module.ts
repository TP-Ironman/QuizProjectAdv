import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { QuizListComponent } from './components/quiz-list/quiz-list.component';
import { QuizFormComponent } from './components/quiz-form/quiz-form.component';
import { Http } from '@angular/http';
import { AdminComponent } from './components/admin/admin.component';
import { ChoiceComponent } from './components/choice/choice.component';
import { DisplayListComponent } from './components/display-list/display-list.component';
import { UpdateQuestionComponent } from './components/update-question/update-question.component';
import { UpdateChoiceComponent } from './components/update-choice/update-choice.component';
import { DeleteComponent } from './components/delete/delete.component';
import { AddQuestChoicesComponent } from './components/add-quest-choices/add-quest-choices.component';
import { AppRoutingModule } from './app-routing.modules';


@NgModule({
  declarations: [
    AppComponent,
    QuizListComponent,
    QuizFormComponent,
    AdminComponent,
    ChoiceComponent,
    DisplayListComponent,
    UpdateQuestionComponent,
    UpdateChoiceComponent,
    DeleteComponent,
    AddQuestChoicesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
