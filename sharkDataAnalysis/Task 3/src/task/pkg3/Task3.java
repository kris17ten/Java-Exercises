/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.pkg3;

//imports
import java.util.*;
import java.io.*;
/**
 *
 * @author Kristen
 */
public class Task3 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        File file = new File("shark-data.txt");
        // Read data from a file
        int numberOfSharks = 0;
        //count the number of sharks(lines) in file
        try ( // Create a Scanner for the file
                Scanner count = new Scanner(file)) {
            //count the number of sharks in file
            while(count.hasNextLine()) {
                numberOfSharks++;
                count.nextLine();
            }
        }
        
        //create a shark array
        Shark[] sharkArray = new Shark[numberOfSharks];
        
        try ( // Create a Scanner for the file
            Scanner input = new Scanner(file)) {
            // Read data from a file
            //create a shark for each line
            for (int i=0; i<sharkArray.length; i++) {
                //System.out.println(Arrays.toString(input.nextLine().split (":")));
                String[] arrayS = input.nextLine().split(":");
                Shark shark = new Shark(arrayS[0], arrayS[1], Integer.parseInt(arrayS[2]), Integer.parseInt(arrayS[3]), arrayS[4],
                    Integer.parseInt(arrayS[5]), arrayS[6].split(","));
                sharkArray[i] = shark;
            }//close for for-loop
          
        }//close for try
        catch (Exception ex) {
            System.out.print("File not found...");
        }
        
        //run the method
        userSearch(sharkArray);
        
    }//close for main method
    
    public static void userSearch(Shark[] array) {
        //user input
        System.out.print("Enter search string for Latin names:  > ");
        Scanner search = new Scanner(System.in);
        String searchFor = search.next();
        
        System.out.println("You entered the string: \"" + searchFor + "\" \n");
        
        //string for search results
        String searchResultsString = "";
        
        //search for sharks that have the searchFor substring
        for(int a = 0; a < array.length; a++) {
            if(array[a].getLatinName().toLowerCase().contains(searchFor.toLowerCase())) {
                String passTo = a + ":";
                searchResultsString += passTo;
            }//close for if
        }//close for "a" for-loop
        
        //stringToArray
        String[] searchResults = searchResultsString.split(":");
        if(searchResultsString.length() == 0) {
            searchResults = new String[0];
        }//close for if
        
        //sort the search results
        // will tell when sort is done
        boolean fin = true;
        
        String temp;
        while (fin) {
            fin = false;
            for (int j = 0;  j < searchResults.length - 1;  j++ ) {
                if (array[Integer.parseInt(searchResults[j])].getCommonName().compareToIgnoreCase(array[Integer.parseInt(searchResults[j+1])].getCommonName()) > 0 ) {                                             // ascending sort
                    // swapping
                    temp = searchResults[j];
                    searchResults[j] = searchResults[ j+1];
                    searchResults[j+1] = temp; 
                    fin = true;
                }//close for if
            }//close for j for-loop
        }//close for while-loop

        //console output
        //if there are results
        if(searchResults.length > 0) {
            System.out.println("The following matches have been found:-");
            
            /* EASIER WAY
            for(int m = 0; m < searchResults.length; m++) {
                String s0 = array[Integer.parseInt(searchResults[m])].getCommonName();
                String s2 = array[Integer.parseInt(searchResults[m])].getLatinName().toLowerCase();
                String s3 = s2.replaceAll(searchFor, searchFor.toUpperCase());
                String s4 = s3.charAt(0) + "";
                String s5 = s4.toUpperCase() + s3.substring(1);
                System.out.println(s0 + " - Latin name: " + s5);
            }  */

            //for each of the results, print out...
            for(int b = 0; b < searchResults.length; b++) {
                String s1 = array[Integer.parseInt(searchResults[b])].getLatinName();
                String finale =  array[Integer.parseInt(searchResults[b])].getCommonName() + " - Latin name: "; 
                //the first part of the string
                //if the searchFor string is not the begnning of the latin name
                if(s1.toLowerCase().indexOf(searchFor.toLowerCase()) != 0) {
                    finale += s1.substring(0, s1.indexOf(searchFor.toLowerCase()));
                }
                //the middle part of the string
                //initiate string for array
                String allPositions = "";
                //while there are no other indexes of the searchFor string, concatenate the position of the searchFor to allPositions
                while (s1.toLowerCase().contains(searchFor.toLowerCase())) {
                    allPositions += s1.toLowerCase().indexOf(searchFor.toLowerCase()) + ":";
                    //set the substring to the rest
                    s1 = s1.substring(s1.toLowerCase().indexOf(searchFor.toLowerCase()) + searchFor.length());
                }
                //string to array        
                String[] allPos = allPositions.split(":");
                
                //initiate variables
                int y = 0;
                int prePos = 0;      //the previous positions in the array
                int finalPos = 0;    //the final position
                int totalPos = 0;    //the total of the positions
                //get the first of the array and assign it to a string 
                s1 = array[Integer.parseInt(searchResults[b])].getLatinName();
                //for each one
                for(int d = 0; d < allPos.length; d++) {
                    //get the current position
                    int currPos = Integer.parseInt(allPos[d]) + y + prePos;
                    //concatenate the searchFor in upper case
                    finale += s1.substring(currPos, currPos + searchFor.length()).toUpperCase();
                    //add the value
                    totalPos += Integer.parseInt(allPos[d]);
                    //if there are more
                    if(allPos.length > 1) {
                        //if d has not reached the final value, then
                        if (d != allPos.length - 1) {
                            y += searchFor.length();
                            //concatenate the other characters between the first index of searchFor and the next
                            finale += s1.substring(currPos + searchFor.length(), Integer.parseInt(allPos[d + 1]) + currPos + searchFor.length());
                        }
                        //add position to prePos
                        prePos += Integer.parseInt(allPos[d]);
                        //finalPos becomes the current position
                        finalPos = currPos;
                    }//close for if
                }//close for d for-loop
                
                //last part of the string
                //if there is some part of the string that still exists
                //a.k.a searchFor is not the end of the string
                if(finalPos < s1.length()) {
                    //concatenate the rest of the string
                    finale += s1.substring(totalPos + searchFor.length() + y);
                }//close for if
                
                //print out the string
                System.out.println(finale);
            }//close for b for-loop
            System.out.println();
            System.out.println();
        }//close for if
       
        //otherwise there are no matches... print out...
        else {
            System.out.println("Sorry. No matches have been found.\n\n");
        }//close for else
        
          ///////////////
         // EXTENSION //
        ///////////////
        /*
       
        //if the user wants to search again
        System.out.print("Type \"yes\" if you would like to search again. Enter any other character(s) to exit search.  > ");
        Scanner again = new Scanner(System.in);
        String replay = again.next().toLowerCase();
        //if yes
        if(replay.equals("yes")) {
            userSearch(array);
        }//close for if
        //if no
        else {
            return;
        }//close for else
        */
        
    }//close for userSearch
    
}//close for class
