import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddQuestChoicesComponent } from './add-quest-choices.component';

describe('AddQuestChoicesComponent', () => {
  let component: AddQuestChoicesComponent;
  let fixture: ComponentFixture<AddQuestChoicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddQuestChoicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddQuestChoicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
