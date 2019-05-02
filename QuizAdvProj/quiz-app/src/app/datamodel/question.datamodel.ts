export class Question{

  questionLabel: string;
  id: number;
  difficulty: string;
  choiceA:string;
  choiceAisC:string;
  choiceB:string;
  choiceBisC:string;
  choiceC:string;
  choiceCisC:string;
  choiceD:string;
  choiceDisC:string;
  mp = new Map();
  choicesList:Array<String>;



  constructor(id: number, label:string, diff:string){
    this.id = id;
    this.questionLabel = label;
    this.difficulty = diff;
  }

}