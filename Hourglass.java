import java.util.Arrays;

/**
 *
 * @author Kristen
 */
public class Hourglass {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Hourglass question
        Base time: ~3h
        
        Answer:
        */
        int[][] grid1 = {{-9, -9, -9, 1, 1, 1}, {0, -9, 0, 4, 3, 2}, {-9, -9, -9, 1, 2, 3}, {0, 0, 8, 6, 6, 0}, {0, 0, 0, -2, 0, 0}, {0, 0, 1, 2, 4, 0}};
        Hourglass(grid1);
        
    }
    //function for ease of use
    public static void Hourglass(int[][] grid) {
        //work the function on the grid
        printHourGlass(grid,findMax(calculateSums(grid), startPoint(grid)));
    }
    
    //prints out the highest value of the hourglass, as well as the hourglass
    public static void printHourGlass(int[][] grid, int[] arr) {
        //arr structure = {maxSum position, row position, column position}
        int sumL = arr[0];
        int rowL = arr[1];
        int colL = arr[2];
        
        System.out.println("The highest hourglass value is " + sumL + " from the hourglass:");
        
        //print for each row
        for(int i=rowL; i<rowL+1; i++) {
            for(int j=colL; j<colL+3; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
        System.out.println();
        for(int i=rowL+1; i<rowL+2; i++) {
            for(int j=colL+1; j<colL+2; j++) {
                System.out.print("  " + grid[i][j] + "  ");
            }
        }
        System.out.println();
        for(int i=rowL+2; i<rowL+3; i++) {
            for(int j=colL; j<colL+3; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
        System.out.println();
    }
    
    //finds the largest sum and starting point of the hourglass (to print)
    public static int[] findMax(int[] sums, int[][] points) {
        //create array to put {maxSum pos, row pos, col pos}
        int[] maxArr = new int[3];
        int largest = 0;
        
        //find largest position
        for(int i=1; i<sums.length; i++) {
            if(sums[i]>sums[largest]) {
                largest = i;
            }
        }
        
        //populate return array
        maxArr[0] = sums[largest];
        maxArr[1] = points[largest][0];
        maxArr[2] = points[largest][1];        
        return maxArr;
    }
    
    //calculates the sums for each hourglass
    public static int[] calculateSums (int[][] grid) {
        //create array to store sums
        int[] HGSums = new int[16];
        //initialize variables 
        int a = 0; //start row
        int z = 3; //end row
        int b = 0; //start col
        int y = 2; //end col
        int n = 0; //empty array position
        
        //calculate totals for each
        for(int d=0; d<4; d++) {
            for(int i=a; i<=z; i++) {
                int total = 0;
                for(int j=b; j<=y; j++) {
                    total += grid[i][j];
                }
            
                for(int k=b+1; k<b+2; k++) {
                    total += grid[i+1][k];
                }
            
                for(int j=b; j<=y; j++) {
                    total += grid[i+2][j];
                }
                HGSums[n] = total;
                total=0; n++;
            }
            b++; y++;
        }
        return HGSums;
    }
    
    //stores the starting point of each hourglass
    public static int[][] startPoint(int[][] grid) {
        //create array to store start points of each hourglass
        int[][] startPoint = new int[16][2];
        int n =0; //empty array position
        
        //for each hourglass, store points
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                int[] temp = new int[2];
                temp[0] = j; //store row
                temp[1] = i; //store col
                startPoint[n] = temp; //put it in return array
                n++;
            }
        }
        return startPoint;
    }
    
    //prints array
    public static void printArray (int[][] arr){
        for(int a=0; a<arr.length; a++) {
            System.out.println(Arrays.toString(arr[a]));
        }
    }
}
