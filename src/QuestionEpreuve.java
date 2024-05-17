class QuestionEpreuve {
   protected String ennonce;

   QuestionEpreuve(String ennonce) {
      this.ennonce = ennonce;
   }
}

class QuestionChoix extends QuestionEpreuve {
   protected String[] choix;

   QuestionChoix(String ennonce, String[] choix) {
      super(ennonce);
      this.choix = choix;
   }

}

class QuestionChoixMultiple extends QuestionChoix {
   private int[] reponsesCorrectes;

   QuestionChoixMultiple(String ennonce, String[] choix, int[] reponsesCorrectes) {
      super(ennonce, choix);
      this.reponsesCorrectes = reponsesCorrectes;
   }
}

class QuestionChoixUnique extends QuestionChoix {
   private int reponseCorrecte;

   QuestionChoixUnique(String ennonce, String[] choix, int reponseCorrecte) {
      super(ennonce, choix);
      this.reponseCorrecte = reponseCorrecte;
   }
}