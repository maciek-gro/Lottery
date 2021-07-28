/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lottery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Yeet
 */
public class Los{
    int[] Five_nums;
    int[] Two_nums;
    
             Los(){
               Five_nums = GenerateRandom_first();
               Two_nums = GenerateRandom_second();
                }  
             
    static int[] GenerateRandom_first(){
        //dziala, teraz system porownujacy do dwojki dziesiatki itp z eurolotka
            List<Integer> lista = new ArrayList<>();
            int[] first_5 = {0,0,0,0,0};
            int temp=0;
            int min = 0;
            int max =50;
            
            
            for(int i=0;i<max;i++){
                lista.add(i+1);
            }
            
             for(int i = 0;i<5;i++){
                temp=getRandomNumberInRange(0,lista.size()-1);
                first_5[i]=lista.get(temp);
                lista.removeAll(Arrays.asList(first_5[i]));
            }
             
        Arrays.sort(first_5);
        
        return first_5;
    }
    
    static int[] GenerateRandom_second(){
        
           
            int[] second_2 = {-1,-1};
            int temp = 0;
            int min =1;
            int max =11;
            for(int i=0;i<2;i++){
                temp=(int)((Math.random() * (max - min)) + min);
                second_2[i]=temp;
                     while (temp==second_2[0]&&temp==second_2[1]){
                       temp=(int)((Math.random() * (max - min)) + min);
                        second_2[i]=temp;
           }
        }
        
        Arrays.sort(second_2);
        return second_2;
    }
    
     private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
     
                
    }
   