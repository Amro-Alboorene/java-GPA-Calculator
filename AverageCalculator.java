/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package average.calculator;

import java.util.Scanner;

/*
 * Java GPA Calculator
 * Author: Amro Al-Hamdan
 * Description: Console-based program to calculate student GPA,
 * determine pass/fail status, and assign letter grades (A–E).
 * Academic Level: First-year Software Engineering student
 */

public class AverageCalculator {

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
    
    public static void main(String[] args) {
       
        double sum = 0;
        boolean Fail = false;
        Scanner in = new Scanner (System.in);
        //Taking courses number from the user
        System.out.println("please enter number of courses:");
        int size = in.nextInt();
        if (size<=0){
            System.out.println("invalid number.");}
        else{
           
        double arr[] = new double[size];
        
        // taking marks frome the user
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
        double avg = sum / size ;
        if (avg >= 90){ 
                System.out.println("Status: Pass\nAverage: "+avg + "\nGrade: (A)");
                    System.out.println("Outstanding performance\nwith consistent academic excellence.");}
        else if (avg >= 80) {
                System.out.println("Status: Pass\nAverage: "+avg + "\nGrade: (B)");
                    System.out.println("High level of achievement and\nstrong understanding of the subjects.");}
        else if (avg >= 70) {
                System.out.println("Status: Pass\nAverage: "+avg + "\nGrade: (C)");
                    System.out.println("Satisfactory performance meeting\nall the necessary requirements.");}
        else if (avg >= 60) {
                System.out.println("Status: Pass\nAverage: "+avg + "\nGrade: (D)");
                    System.out.println("Marginal performance with\na need for further development.");}
        else if (avg >= 50) {
                System.out.println("Status: Pass\nAverage: "+avg + "\nGrade: (E)");
                    System.out.println("Insufficient performance. \nAdditional support and study are required.");}
        
        maxMark(arr , size);
        minMark(arr , size);
    }
    }
    }
    
}
