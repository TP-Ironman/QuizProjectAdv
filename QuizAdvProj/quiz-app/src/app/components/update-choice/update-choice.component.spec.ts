import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateChoiceComponent } from './update-choice.component';

describe('UpdateChoiceComponent', () => {
  let component: UpdateChoiceComponent;
  let fixture: ComponentFixture<UpdateChoiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateChoiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateChoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
