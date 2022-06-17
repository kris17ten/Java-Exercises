/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.pkg1;
import java.util.*;
import java.io.*;
/**
 *
 * @author Kristen
 */
public class Task1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        // Create a File instance     
        File file = new File("shark-data.txt");
        // Read data from a file
        int numberOfSharks = 0;
        //count the number of sharks in file
        try ( // Create a Scanner for the file
                Scanner count = new Scanner(file)) {
            //count the number of sharks(lines) in file
            while(count.hasNextLine()) {
                numberOfSharks++;
                count.nextLine();
            }//close for while
        }//close for try
        
        //create a shark array
        Shark[] sharkArray = new Shark[numberOfSharks];
        
        try ( // Create a Scanner for the file
            Scanner input = new Scanner(file)) {
            // Read data from a file
            //create a shark for each line
            for (int i=0; i<sharkArray.length; i++) { 
                String[] arrayS = input.nextLine().split(":");
                Shark shark = new Shark(arrayS[0], arrayS[1], Integer.parseInt(arrayS[2]), Integer.parseInt(arrayS[3]), arrayS[4],
                    Integer.parseInt(arrayS[5]), arrayS[6].split(","));
                sharkArray[i] = shark;
            }//close for for-loop
        }//close for try
           
        //output file 
        File outputFile = new File("results.txt");
        /*if(outputFile.exists()) {
            System.out.println("File already exists");
            System.exit(1);
        }//close for if    */
        
        try (PrintWriter output = new PrintWriter(outputFile)) {
            threeLargestAndSmallestSharks(sharkArray, output);
            output.println("------------------------------------");
            System.out.println("------------------------------------");
            countLatinLetters(sharkArray, output);
            uniqueEvenAndOddWords(sharkArray, output);
        }//close for try
        catch (Exception ex) {
            System.out.print("File not found.");
        }//close for catch
        
    }//close for main method
    
    public static void threeLargestAndSmallestSharks(Shark[] array, PrintWriter x) {

        Arrays.sort(array, Comparator.comparing((Shark someShark) -> someShark.getMaxLengthOfGrowthInCm()));
        
        /*System.out.println(array[0].getMaxLengthOfGrowthInCm());
        System.out.println(array[1].getMaxLengthOfGrowthInCm());
        System.out.println(array[2].getMaxLengthOfGrowthInCm());   */
        
        //THREE LARGEST SHARKS
        //initiate variables
        int largest = 0;
        int secondLargest = 0;
        int thirdLargest = 0;
        
        //check for each shark
        for(int i=0; i<array.length; i++) {
            //if greater than third largest
            if(array[i].getMaxLengthOfGrowthInCm() > array[thirdLargest].getMaxLengthOfGrowthInCm()) {
                //if greater than second largest
                if(array[i].getMaxLengthOfGrowthInCm() > array[secondLargest].getMaxLengthOfGrowthInCm()) {
                    //if greater than largest
                    if(array[i].getMaxLengthOfGrowthInCm() > array[largest].getMaxLengthOfGrowthInCm()) {
                        thirdLargest = secondLargest;
                        secondLargest = largest;
                        largest = i;
                    }//close for third if
                    //not greater than largest
                    else {
                        thirdLargest = secondLargest;
                        secondLargest = i;
                    }//close for else
                }//close for second if
                //not greater than second largest
                else {
                    thirdLargest = i;
                }//close for else
            }//close for first if
            
        }//close for for-loop
        
        //output to console
        System.out.println("--- Three largest sharks ---" + "\n" +
                "Shark: " + array[largest].getCommonName() + ", length = " + array[largest].getMaxLengthOfGrowthInCm() + "cm \n" +
                "Shark: " + array[secondLargest].getCommonName() + ", length = " + array[secondLargest].getMaxLengthOfGrowthInCm() + "cm \n" +
                "Shark: " + array[thirdLargest].getCommonName() + ", length = " + array[thirdLargest].getMaxLengthOfGrowthInCm() + "cm \n");
        //output to file
            x.println("--- Three largest sharks ---");
            x.println("Shark: " + array[largest].getCommonName() + ", length = " + array[largest].getMaxLengthOfGrowthInCm() + "cm");
            x.println("Shark: " + array[secondLargest].getCommonName() + ", length = " + array[secondLargest].getMaxLengthOfGrowthInCm() + "cm");
            x.println("Shark: " + array[thirdLargest].getCommonName() + ", length = " + array[thirdLargest].getMaxLengthOfGrowthInCm() + "cm \n");
            x.println();
        
        //THREE SMALLEST SHARKS
        //initiate variables
        int smallest = largest;
        int secondSmallest = largest;
        int thirdSmallest = largest;
        
        //check for each shark
        for(int i=0; i<array.length; i++) {
            //if smaller than third smallest
            if(array[i].getMaxLengthOfGrowthInCm() < array[thirdSmallest].getMaxLengthOfGrowthInCm()) {
                //if smaller than second smallest
                if(array[i].getMaxLengthOfGrowthInCm() < array[secondSmallest].getMaxLengthOfGrowthInCm()) {
                    //if smaller than smallest
                    if(array[i].getMaxLengthOfGrowthInCm() < array[smallest].getMaxLengthOfGrowthInCm()) {
                        thirdSmallest = secondSmallest;
                        secondSmallest = smallest;
                        smallest = i;
                    }//close for third if
                    //not smaller than smallest
                    else {
                        thirdSmallest = secondSmallest;
                        secondSmallest = i;
                    }//close for else
                }//close for second if
                //not smaller than second smallest
                else {
                    thirdSmallest = i;
                }//close for else
            }//close for first if
            
        }//close for for-loop
        
        //output to console
        System.out.println("--- Three smallest sharks ---" + "\n" +
                "Shark: " + array[smallest].getCommonName() + ", length = " + array[smallest].getMaxLengthOfGrowthInCm() + "cm \n" +
                "Shark: " + array[secondSmallest].getCommonName() + ", length = " + array[secondSmallest].getMaxLengthOfGrowthInCm() + "cm \n" +
                "Shark: " + array[thirdSmallest].getCommonName() + ", length = " + array[thirdSmallest].getMaxLengthOfGrowthInCm() + "cm \n\n");
        
        //ouput to file
        x.println("--- Three smallest sharks ---");
        x.println("Shark: " + array[smallest].getCommonName() + ", length = " + array[smallest].getMaxLengthOfGrowthInCm() + "cm");
        x.println("Shark: " + array[secondSmallest].getCommonName() + ", length = " + array[secondSmallest].getMaxLengthOfGrowthInCm() + "cm");
        x.println("Shark: " + array[thirdSmallest].getCommonName() + ", length = " + array[thirdSmallest].getMaxLengthOfGrowthInCm() + "cm \n\n");
        x.println();
        x.println();
    }//close for threeLargestAndSmallestSharks
    
    public static void countLatinLetters(Shark[] array, PrintWriter x) {
        //initiate variables
        int total = 0;
        //for each name...
        for (int j = 0; j < array.length; j++) {
            //remove spaces
            String str = array[j].getLatinName().replaceAll(" ", "");
            //add length to the total
            total += str.length();
        }//close for for-loop
        
        //output to console
        System.out.println("Total number of letters in all the Latin names = " + total);
        
        //output to file
        x.println("Total number of letters in all the Latin names = " + total);
    }//close for countLatinLetters
    
    public static void uniqueEvenAndOddWords(Shark[] array, PrintWriter x) {
        //create string for results
        String combinedString = "";
        //HashSet<String> uniqueWords = new HashSet<String>();
        
        for(int b=0; b < array.length; b++) {
            /*for(String myString: array[b].getLatinName().split(" ")) {
                uniqueWords.add(myString); 
            } */
            combinedString += array[b].getLatinName() + " "; 
        }
        //String to array
        String[] combined = combinedString.split(" ");
        
        String allLatinNames = "";
        //remove duplicates
        for(int a = 0; a < combined.length; a++) {
            String s1 = combined[a];
            
            if(allLatinNames.contains(s1)) {
                continue;
            }
            else {
                String passTo = combined[a] + " ";
                allLatinNames += passTo;
            }
        }
        
        //stringToArray
        String[] latinString = allLatinNames.split(" ");
        //initiate variables
        int EvenWords = 0;
        int OddWords = 0;
        
        //for each name...
        for(int d = 0; d < latinString.length; d++) {
            //if even
            if(latinString[d].length() % 2 == 0) {   
            //add to even
            EvenWords += 1;
            }//close for if
            //add to odd
            else {
                OddWords += 1;
            }//close for else
        }//close for for-loop
        
        //output to console
        //System.out.println("Set size: " + uniqueWords.size());
        System.out.println("Total number of unique even words in Latin names = " + EvenWords + "\n" +
                "Total number of unique odd words in Latin names = " + OddWords + "\n");
        
        //output to file
        x.println("Total number of unique even words in Latin names = " + EvenWords);
        x.println("Total number of unique odd words in Latin names = " + OddWords + "\n");
    }//close for uniqueEvenAndOddWords
    
}//close for class
