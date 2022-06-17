/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.pkg2;

//imports
import java.util.*;
import java.io.*;

/**
 *
 * @author Kristen
 */
public class Task2 {
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
            getRegion(sharkArray, output);
        }//close for try
        catch (Exception ex) {
            System.out.print("File not found.");
        }//close for catch
        
    }//close for main method
    
    public static void getRegion(Shark[] array, PrintWriter x) {
        //TreeSet<String> -> removes duplicates and gets it in alphabetical order.
        //TreeMap<String, ArrayList<Shark>>
        
        //get an array of all the regions
        //string for array
        String allRegionsString = "  ";
        
        //get all the regions into a string
        for(int k = 0; k < array.length; k++) {
            for(int a = 0; a < array[k].getOceanicRegions().length; a++) {
                String s1 = "  " + array[k].getOceanicRegions()[a];
                //no duplicates
                if(allRegionsString.contains(s1)) {
                    continue;
                }//close for if
                else {
                    String passTo = " " + array[k].getOceanicRegions()[a] + ": ";
                    allRegionsString += passTo;
                }//close for else
            }//close for inner for-loop
        }//close for for-loop
        
        //stringToArray
        String[] allRegions = allRegionsString.split(": ");
        
        //get rid of all extra spaces
        for (int f = 0; f < allRegions.length; f++) {
            allRegions[f] = allRegions[f].trim();
        }
        
        //sort the regions
        Arrays.sort(allRegions);
        
        //for each region, find the sharks
        for (int c = 0; c < allRegions.length; c++) {
            String eachRegionString = "";
            for (int d = 0; d < array.length; d++) {
                for (int e = 0; e < array[d].getOceanicRegions().length; e++) {
                    String current = allRegions[c].replaceAll(" ", "");
                    if (current.equals(array[d].getOceanicRegions()[e].replaceAll(" ", ""))) {
                        String passTo = array[d].getCommonName() + ":";
                        eachRegionString += passTo;
                    }
                }//close for e for-loop
            }//close for d for-loop
            
            //string to array
            String[] eachRegion = eachRegionString.split(":");
            //sort into alphabetical order
            Arrays.sort(eachRegion);
            
            //ouput to console
            System.out.println("Region: " + allRegions[c] + " ->  " + Arrays.toString(eachRegion));
            
            //output to file
            x.println("Region: " + allRegions[c] + " ->  " + Arrays.toString(eachRegion));
        }//close for c for-loop
    }//close for getRegion
}//close for class
