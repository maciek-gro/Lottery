/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lottery;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {

   
    public static void main(String[] args) { 
        //lottery tickets in euro jackpot look like this - 1,2,3,4,5 (range 1-50)  1,2 (range 1-10)
        
        int[] result = {07,16,22,30,48}; //winning lotto numbers - 5
        int[] result_2 = {2,8};          //winning lotto numbers - 2
        
        
        
        int[] comparison ={};          //this array variable will contain the number of matching numbers on ticket vs result
        List<int[]> comps_composite = new ArrayList<int[]>(); //this variable will contain all of the winning combinations in a game
        int iterations = 100;          //number of tickets we want to submit in one game
        double payout = 0;             //amount of money we will win
        
         
         
        for(int x=0;x<iterations;x++){  //start the game
            
            Los ticket = new Los();              //generate ticket with random numbers
            comparison = compare(result,ticket.Five_nums,result_2,ticket.Two_nums);//compare ticket vs the winning numbers
            
            System.out.print(Arrays.toString(ticket.Five_nums)); //print 5 digits from ticket
                System.out.print(" || ");
            System.out.print(Arrays.toString(ticket.Two_nums)); //print 2 digits from ticket
                System.out.print(" ||   ");
            System.out.print(Arrays.toString(comparison));      //print how many digits are identical as with the winning lotto numbers
            
            if((comparison[0]>1&&comparison[1]>0)||(comparison[0]==1&&comparison[1]==2)||(comparison[0]==3&&comparison[1]==0)){//these are the cases of winning tickets
                System.out.print(" -------------------------- winner"); //if winner make it stand out in output
                comps_composite.add(comparison);                        //add to array that holds winner comparisons
                payout = payout + get_moni(comparison);                 //add won amount to payout variable
              
            }
            
            System.out.println();
        }
        
        System.out.println();
        
        //printing of results
         for(int[] list_member : comps_composite){
             System.out.println(Arrays.toString(list_member));
         }
         
         System.out.println("won something = " + comps_composite.size());
         System.out.println("amount spent on tickets: " + String.format("%.2f",iterations*12.5));
         System.out.println("won amount = " + String.format("%.2f",payout));
         System.out.println("balance: " + ((payout) - (iterations*12.5)));
         
    }
    
    
      public static int[] compare (int[] result,int[] los, int[] result_2, int[] los_2){
        int counter[] = {0,0};
         
       
        for(int x=0;x<5;x++){
          for(int y=0;y<5;y++){
           if(los[x]==result[y]){counter[0]++;}
        }
        }
        
        for(int x=0;x<2;x++){
          for(int y=0;y<2;y++){
           if(los_2[x]==result_2[y]){counter[1]++;}
        }
        }
        
         return counter;
    }
     
      
     public static double get_moni (int[] to_compare){//this is a function that uses a dictionary to determine the money won in a ticket
         
         double payout=0;
         int[][] results = {{2,1},{1,2},{3,0},{3,1},{2,2},{3,2},{4,0},{4,1},{4,2},{5,0},{5,1},{5,2}};            //cases
         double[] money = {35.70,36.10,67.30,78.90,78.90,217.40,517.60,1071.80,12861.80,192927,241143,2893724};  //corresponding amount
 
         for(int i=0; i<results.length;i++){
             if(Arrays.equals(to_compare, results[i])==true){
                 payout = money[i];
             }
             
         }
         
         return payout;
     }
}




         