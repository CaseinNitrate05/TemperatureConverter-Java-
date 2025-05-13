import java.util.Scanner;
class InvalidMarksException extends Exception{
 public InvalidMarksException(String msg)
 {
    super(msg);
 }
}
public class StudentGrade{
    protected int[] S;
    protected int sub;
    protected int total;
    protected float percentage;

    public void inputMarks() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.print("Enter the number of subjects:");
            sub = s.nextInt();
            S = new int[sub];
            for (int i = 0; i < sub; i++) {
                try {
                    System.out.print("Enter the marks for subject " + (i + 1) + " (out of 100):");
                    int marks=s.nextInt();
                    if (marks<0 || marks>100) {
                        throw new InvalidMarksException("Invalid input. Marks should be between 0 and 100.");
                    }
                    S[i] = marks;
                } catch (InvalidMarksException e) {
                    System.out.println(e.getMessage());
                    i--; // Decrement i to retry input for the same subject
                }
            }
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }finally{
            s.close(); // Close the scanner to release resources
        }
    }
    public void calculateTotal(){
        total=0;
        for (int i=0;i<sub; i++){
            total +=S[i];
        }
        System.out.println("Total Marks: " + total);
    }
    public float avg(){
        return ((float)total/(sub*100))*100;
    }

    public void average()
    { 
        percentage=avg();
        System.out.println("Average Percentage:"+percentage);
        
    }
    public void gradeSubject(){
        for (int i=0;i<sub;i++)
        {
            if(S[i]>=90){
                System.out.println("Grade for subject " + (i + 1) + ": A+");
            } 
            else if(S[i]<90 && S[i]>=80){
                System.out.println("Grade for subject " + (i + 1) + ": A");
            } 
            else if(S[i]<80 && S[i]>=70){
                System.out.println("Grade for subject " + (i + 1) + ": B");
            } 
            else if(S[i]<70 && S[i]>=60){
                System.out.println("Grade for subject " + (i + 1) + ": C");
            } 
            else if(S[i]<60 && S[i]>=50){
                System.out.println("Grade for subject " + (i + 1) + ": D");
            } 
            else if(S[i]<50 && S[i]>=40){
                System.out.println("Grade for subject " + (i + 1) + ": E");
            } 
            else{
                System.out.println("Grade for subject " + (i + 1) + ": F");
            }
        }
    }

    public void gradeTotal(){
        if(percentage>=90){
            System.out.println("Grade for Total: A+");
        } 
        else if(percentage<90 && percentage>=80){
            System.out.println("Grade for Total: A");
        } 
        else if(percentage<80 && percentage>=70){
            System.out.println("Grade for Total: B");
        }
        else if(percentage<70 && percentage>=60){
            System.out.println("Grade for Total: C");
        } 
        else if(percentage<60 && percentage>=50){
            System.out.println("Grade for Total: D");
        } 
        else if(percentage<50 && percentage>=40){
            System.out.println("Grade for Total: E");
        } 
        else{
            System.out.println("Grade for Total: F");
        }
    }
    public static void main(String args[]){
        StudentGrade s=new StudentGrade();
        s.inputMarks();
        System.out.println("--------------------------------------");
        s.calculateTotal();
        System.out.println("---------------------------------------");
        s.average();
        System.out.println("---------------------------------------");
        s.gradeSubject();
        System.out.println("---------------------------------------");
        s.gradeTotal();
    }

}

