/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package average.calculator;
/*
 * Java GPA Calculator
 * Author: Amro Al-Hamdan
 * Description: Console-based program to calculate student GPA,
 * determine pass/fail status, and assign letter grades (A–E).
 * Academic Level: First-year Software Engineering student
 */
import java.util.Scanner;
public class AverageCalculator {

    
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        double sum = 0;
        boolean invalid = false;
        boolean Failed = false;
        //taking number of courses from the user
        System.out.println("please enter the number of courses");
            int s = in.nextInt();
        double [] arr = new double [s];
        for (int i = 0; i < s; i++) {
            System.out.println("please enter mark #"+(i+1) + "  (mark must be less or equal 100)");
                 arr[i] = in.nextDouble();
                 sum += arr[i];
             }
        //check if there is any invalid number
        for (int q = 0; q < s; q++) {
            if (arr[q] > 100){
                 invalid = true;}
        }
        //check if there is any failed grade    
        for (int j = 0; j < s; j++) {
            if (arr[j] < 50) {
                Failed = true;}
        }
            if (invalid == true){
                System.out.println("marks must be less or equal to 100");}
                else
            if (Failed == true){
                System.out.println("you Fail");}
            else{
            
        //calculate average
        double avg = sum/s;
        if (avg >= 50){
            System.out.print("you Pass\nyour average = "+avg);
        //check letter grade (A-E)
        if (avg >= 90){
            System.out.println(" A");
            System.out.println("Outstanding performance\nwith consistent academic excellence.");}
            else
        if (avg >= 80){
            System.out.println(" B");
            System.out.println("High level of achievement and\nstrong understanding of the subjects.");}    
            else
        if (avg >= 70){
            System.out.println(" C");
            System.out.println("Satisfactory performance meeting\nall the necessary requirements.");}    
            else  
        if (avg >= 60){
            System.out.println(" D");
            System.out.println("Marginal performance with\na need for further development.");}    
            else    
        if (avg >= 50){
            System.out.println(" E");
            System.out.println("Insufficient performance. \nAdditional support and study are required.");}    
        }
        else {
            System.out.println("you Fail");}
            }
                           
    }
    
}
