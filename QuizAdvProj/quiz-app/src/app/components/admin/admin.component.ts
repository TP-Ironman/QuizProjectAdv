import { Component, OnInit } from '@angular/core';
import { QuizService } from 'src/app/services/quiz.service';
import { Admin } from 'src/app/datamodel/admin.datamodel';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  admin: Admin;


  constructor(private service : QuizService) { }

  ngOnInit() {
    this.admin = new Admin('','',);
  }

  login() {
    this.service.loginAdmin(this.admin);
     
  }

}
