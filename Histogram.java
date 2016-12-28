/*
 * Given an array (numbers) of size n, where each element of the array
 * is an integer in the range 1 to 100 inclusive, create and display a 
 * histogram that allows you to inspect visually the frequency distribution 
 * of the collection of integers, producing a chart
 */
package histogram;

import java.util.Random;

/**
 * 19/11/2016
 * @author Bijan G.A (100125463)
 */
public class Histogram {

    public static void displayHistogram(int[] numbers){
        
        int[] frequency = new int[10];
        
        for(int i = 0; i < numbers.length; i++){            
            if(numbers[i] >= 1 && numbers[i] <= 10){
                frequency[0]++;
            } else if(numbers[i] >= 11 && numbers[i] <= 20){
                frequency[1]++;
            } else if(numbers[i] >= 21 && numbers[i] <= 30){
                frequency[2]++;
            } else if(numbers[i] >= 31 && numbers[i] <= 40){
                frequency[3]++;
            } else if(numbers[i] >= 41 && numbers[i] <= 50){
                frequency[4]++;
            } else if(numbers[i] >= 51 && numbers[i] <= 60){
                frequency[5]++;
            } else if(numbers[i] >= 61 && numbers[i] <= 70){
                frequency[6]++;
            } else if(numbers[i] >= 71 && numbers[i] <= 80){
                frequency[7]++;
            } else if(numbers[i] >= 81 && numbers[i] <= 90){
                frequency[8]++;
            } else if(numbers[i] >= 91 && numbers[i] <= 100){
                frequency[9]++;
            } 
        }
        
        int counter = 1;
        
        for(int i = 0; i < frequency.length; i++){
            switch(counter){
                case 1:
                    System.out.print("1-10   ");
                    break;
                case 2:
                    System.out.print("11-20  ");
                    break;
                case 3:
                    System.out.print("21-30  ");
                    break;
                case 4:
                    System.out.print("31-40  ");
                    break;
                case 5:
                    System.out.print("41-50  ");
                    break;
                case 6:
                    System.out.print("51-60  ");
                    break;
                case 7:
                    System.out.print("61-70  ");
                    break;
                case 8:
                    System.out.print("71-80  ");
                    break;
                case 9:
                    System.out.print("81-90  ");
                    break;
                case 10:
                    System.out.print("91-100 ");
                    break;
            }
            counter++;
            for(int j = 0; j < frequency[i]; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
    
    public static void main(String[] args) {
        
        int[] numbers = new int[200];
        Random random = new Random();
        
        for(int i = 0; i < numbers.length; i++){            
            numbers[i] = random.nextInt(100) + 1;            
        }
        
        displayHistogram(numbers);
    }
    
}
