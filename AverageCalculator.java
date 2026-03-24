package averagecalculator_2_;

/*
 * Java GPA Calculator
 * Author: Amro Al-Hamdan
 * Description: Console-based program to calculate student GPA,
 * Multible calculation options for school and university student.  
 * determine pass/fail status, and assign letter grades (A–E).
 * Academic Level: First-year Software Engineering student.
 * Note : Letter grades (A–E) are assigned according to Zarqa University’s grading system.
 */

import java.util.Scanner;
public class AverageCalculator_2_ {
    
//Find Max Mark
    public static void maxMark (double arr[] , int size){
    double MaxNum = arr[0]; 
        for (int i = 1; i < size; i++) {
            if (arr[i] > MaxNum)
                MaxNum = arr[i];
    }
        System.out.println("Highest Mark: "+MaxNum);
    }
     //Find Min Mark
    public static void minMark (double arr[] , int size){
    double MinNum = arr[0];
        for (int j = 0; j < size; j++) {
            if (arr[j] < MinNum){
                MinNum = arr[j];
            }
        }
        System.out.println("Lowest Mark: "+ MinNum);
    }
    
    public static void finalResult (double avg , int A , int B , int C , int D , int E){
    
    if (avg >= A){ 
                System.out.println("Status: Pass\nAverage: "+ avg + "\nGrade: (A)");
                    System.out.println("Outstanding performance\nwith consistent academic excellence.");}
        else if (avg >= B) {
                System.out.println("Status: Pass\nAverage: "+ avg + "\nGrade: (B)");
                    System.out.println("High level of achievement and\nstrong understanding of the subjects.");}
        else if (avg >= C) {
                System.out.println("Status: Pass\nAverage: "+ avg + "\nGrade: (C)");
                    System.out.println("Satisfactory performance meeting\nall the necessary requirements.");}
        else if (avg >= D) {
                System.out.println("Status: Pass\nAverage: "+ avg + "\nGrade: (D)");
                    System.out.println("Marginal performance with\na need for further development.");}
        else if (avg >= E) {
                System.out.println("Status: Pass\nAverage: "+ avg + "\nGrade: (E)");
                    System.out.println("Insufficient performance. \nAdditional support and study are required.");}
    
    }
    
    
    public static void main(String[] args) {
        double sum = 0;
        boolean Fail = false;
        double currentGPA;
        double avg = 0;
        int prevHours;
        double prevPoints;
        double semesterPoints;
        int semesterHours;
        double semesterGPA;
        double totalPoints;
        int totalHours;
        int size;
        
        Scanner in = new Scanner (System.in);
        
            System.out.println("1- School student");
            System.out.println("2- University student");
        int studentType = in.nextInt();
        if (studentType != 1 && studentType != 2){
            System.out.println("please enter a valid Choice");}
        else if (studentType == 1){
            
        //Taking courses number from the user
        System.out.println("please enter number of courses:");
        size = in.nextInt();
        if (size<=0)
            System.out.println("invalid number!");
        else{
           double arr[] = new double[size];
           
        //taking marks from the user
        for (int i = 0; i < size; i++) {
            System.out.println("plese enter Mark #"+(i+1));
            arr[i] = in.nextDouble();
            while (arr[i] > 100 || arr[i] < 0){
                System.out.println("Marks must be between 0 and 100");
                System.out.println("plese enter Mark #"+(i+1));
                arr[i] = in.nextDouble();
            }
        }
        //check if there is any failed mark
            for (int j = 0; j < size; j++) {
                if (arr[j] < 50)
                    Fail = true;
            }
        if (Fail == true)
                System.out.println("you fail");
        
        //Calculating GPA
        else{
            for (int q = 0; q < size; q++) {
                sum += arr[q];
            }
            
        avg = sum / size ; }
        //showing final result
        finalResult(avg , 90 , 80 , 70 , 60 , 50);
            
            maxMark(arr , size);
            minMark(arr , size);
        
        } 
}
        else if (studentType == 2){
            
            //Taking requirements from user
            System.out.println("Please enter current GPA:");
                currentGPA = in.nextDouble();
            System.out.println("Please enter the Number of completed hours:");
                prevHours = in.nextInt();
            System.out.println("Please enter number of courses:");
                size = in.nextInt();
                if (size <= 0)
                    System.out.println("invalid number!");
                else{
                    double arr[] = new double[size];
                
            //Taking marks from the user
            int coursesHoursArr[] = new int [size];
            for (int i = 0; i < size; i++) {
            System.out.println("Please enter Mark #"+(i+1));
            arr[i] = in.nextDouble();
            while (arr[i] > 100 || arr[i] < 0){
                System.out.println("Marks must be between 0 and 100");
                System.out.println("plese enter Mark #"+(i+1));
                arr[i] = in.nextDouble();
            }
                System.out.println("Please enter number of Hours of this Course:");
                coursesHoursArr[i]=in.nextInt();
            while (coursesHoursArr[i] <= 0){
                System.out.println("Hours must be more than 0");
                System.out.println("Please enter number of Hours of this Course:");
                coursesHoursArr[i] = in.nextInt();
            }
                
            }
            
            //check if there is any failed mark
            for (int j = 0; j < size; j++) {
                if (arr[j] < 50)
                    Fail = true;
            }
                if (Fail == true){
                System.out.println("you fail");
                maxMark(arr , size);
                minMark(arr , size);
                }
                else {
                
        //previous Points calculating
            prevPoints = currentGPA * prevHours; 
            
        //semester Points calculating
            semesterPoints = 0;
                    for (int i = 0; i < size; i++) {
                        semesterPoints += arr[i] * coursesHoursArr[i];
                    }
        //sum of semester Hours
        semesterHours=0;
                    for (int i = 0; i < size; i++) {
                        semesterHours += coursesHoursArr[i];
                    }
                    
        //calculating semester GPA
        semesterGPA = semesterPoints / semesterHours;
        
        //calculating new GPA
        
            //Total Points
            totalPoints = prevPoints + semesterPoints;
            
            //Total completed Hours
            totalHours = prevHours + semesterHours;
            
            //calculating final GPA
            avg = totalPoints / totalHours;
                   
            //rounded GPA
            double roundedGPA = Math.round(semesterGPA * 10.0) / 10.0;
                    System.out.println("Your semester GPA = "+roundedGPA);
                    
            //rounded avg
            double roundedavg = Math.round(avg * 10.0) / 10.0;
                    
            // showing final reult
            finalResult(roundedavg , 84 , 76 , 68 , 60 , 50);
            
            maxMark(arr , size);
            minMark(arr , size);
            
        } 
        }
    }
}
}
