export class Choice{

    choice: string;
    qid: number;
    chOpid:string;
    isCorrect: string;
  
  
    constructor(id: number, choice:string, optid:string, corval:string){
      this.qid = id;
      this.choice = choice;
      this.chOpid = optid;
      this.isCorrect = corval;
    }
  
  }