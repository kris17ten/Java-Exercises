
import java.util.Arrays;
/**
 *
 * @author Kristen
 */
public class ArrayLeftRotate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Memory, Time
          Swap is better*/
        
        /*
        A left rotation operation on an array of size shifts each of the array's
        elements unit to the left. 
        For example, if 2 left rotations are performed on
        array [1,2,3,4,5], then the array would become [3,4,5,1,2].
        
        Given an array of n integers and a number d, write a Java method that performs d left rotations
        on the array. Then print the updated array as a single line of space-separated integers. 
        Example input: [1,2,3,4,5],2
        Example output: [3,4,5,1,2]
        
        To consider:
        -size of array (C)
        -negative numbers (C)
        -rotations > size of array (C)
        
        Further implementation
          Example input: [1,2,3,4,5],-2
          Example output: [4,5,1,2,3]
        
        Base time: 12m36s
        Answer:
        */
        
        int[] myArr = {1, 2, 3, 4, 5};
        
        int pnumber = 2;
        int nnumber = -2;
        Rotate(myArr, pnumber);
        System.out.println("------------------------------------------");
        Rotate(myArr, nnumber);
    }
    
    public static void Rotate(int[] arr, int n) {
        //find out an n value to work with
        n = figureOutN(arr, n);
        
        //create new array to populate
        int[] newArray = new int[arr.length];
        //str for debugging purposes only    
        String str = Arrays.toString(newArray); //debugging purposes
        //save n
        int n2 = n;
        
        //for i in array length - n2, populate newArray with the switched values
        for(int i=0; i<arr.length-n2; i++) {
            newArray[i] = arr[n];
            str = Arrays.toString(newArray);   //debugging
            n++; //increment n to allow for different vals
        }
        
        n = arr.length-n2; //reset n for rest of the vals
        //populate newArray with remaining vals
        for(int h=0; h<n2; h++) {
            newArray[n] = arr[h];
            str = Arrays.toString(newArray);   //debugging
            n++;
        }
        //print out the result
        System.out.println(Arrays.toString(newArray));
    } 
    
    public static int figureOutN (int[] arr, int n) {
        //if negation, go backwards
        if(n<0){
            //if no. of rotations exceeds array size for -ve
            if(-n>arr.length) {
                n = n % arr.length;
                n = n + arr.length;
            }
            else {
                n = arr.length + n;  //adding n because it is a -ve number
            }
        }
        //if no. of rotations exceeds array size for +ve
        else if(n>arr.length) {
            n = n % arr.length;
        }
        return n;
    }
}
