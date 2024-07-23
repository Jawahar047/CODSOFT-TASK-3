import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class QuizApp{
    static int score=0;
    static boolean timeUp=false;
public static void main(String[]args){
    Scanner scanner=new Scanner(System.in);
    Timer timer=new Timer();
    TimerTask task=new TimerTask() {
        public void run(){
            timeUp=true;
            System.out.println("\nTime's up!Quiz over.");
            showFinalScore();
            scanner.close();
            System.exit(0);
        }
    };
    timer.schedule(task,6000);
    String[][]questions={
    {"What is the capital of france?","Paris","Londan","Berlin","Madrid","1"},
    {"What is the largest planet in our solar system?","Jupiter","Saturn","Mars","Earth","1"},
    {"Who wrote Romeo and Juliet?","Shakesphere","Dickens","Austen","Hemingway","1"},
    {"What is the tallest mountain in the world?","Mount Everest","K2","Kangchenjunga","Makalu","1"},
    {"Which planet known as the red planet?","Mars","Venus","Jupiter","Mercury","1"},
    {"Who pained the Mona Lisa?","Leonardo da Vinci","Vincent van Gogh","Pablo Picasso","Claude Monet","1"},
    {"Which country won the FIFA world cup in 2018?","France","Brazil","Germany","Argentina","1"},
    {"Who invented Telephone?","Alexander Graham Bell","Thomas Edison","Nikola Tesla","Albert Einsten","1"},
    {"Which element has the chemical symbol 'H'?","Hydrogen","Helium","Oxygen","Nitrogen","1"},
    {"What was the largest ocean on earth?","Pacific ocean","Atlantic ocean","Indian ocean","Artic ocean","1"}
};
for(int i=0;i<questions.length&&!timeUp;i++){
    String question=questions[i][0];
    String option1=questions[i][1];
    String option2=questions[i][2];
    String option3=questions[i][3];
    String option4=questions[i][4];
    String answer=questions[i][5];
    System.out.println("Question"+(i+1)+":"+question);
    System.out.println("1."+option1);
    System.out.println("2."+option2);
    System.out.println("3."+option3);
    System.out.println("4."+option4);
    System.out.print("Enter your answer(1-4):");
    String userAnswer=scanner.nextLine();
    if(userAnswer.equals(answer)){
        System.out.println("Correct!\n");
        score++;
    }else{
        System.out.println("Incorrect.The correct answer is:"+answer+"\n");
    }
}
showFinalScore();
timer.cancel();
scanner.close();
}
static void showFinalScore(){
    System.out.println("Quiz complete!");
    System.out.println("Your score:"+score);
}
}
