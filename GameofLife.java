import java.io.*;
import java.util.*;

/**
 * @author ${Sunil Kumar Vadlamani}
 *
 * Conway's Game of Life
 * 
 * 
 * Program Execution Steps
 * javac GameofLife.java (Class files are generated)
 * java GameofLife input.txt (Give the input file with data as an argument)
 */

class GameofLife {
	
   // This method returns true if a particular cell i,j is in bound of the n x n matrix
   public static boolean isThere(int m,int n,int v) {
       boolean flag = false;
       if (m >= 0 && m < v && n >= 0 && n < v) {
         flag = true;
       }//End of if
       //Returning the flag value (True or False)
       return flag;
   }//End of isThere 

   // This method counts number of live cells .i,e the cells whose value is 1
   public static int countNearCells(int [][]grid,int m,int n) {
       int count=0;
       int row=grid.length;
       if(isThere(m-1,n-1,row) && grid[m-1][n-1]==1)
           count++;
       if(isThere(m-1,n,row) && grid[m-1][n]==1)
           count++;
       if(isThere(m-1,n+1,row) && grid[m-1][n+1]==1)
           count++;
       if(isThere(m,n-1,row) && grid[m][n-1]==1)
           count++;
       if(isThere(m,n+1,row) && grid[m][n+1]==1)
           count++;
       if(isThere(m+1,n-1,row) && grid[m+1][n-1]==1)
           count++;
       if(isThere(m+1,n,row) && grid[m+1][n]==1)
           count++;
       if(isThere(m+1,n+1,row) && grid[m+1][n+1]==1)
           count++;
       return count;
   }//End of countNeighbour()
   
//Main method reads the data from file as initial population and prints it (To verify the input).
//A method call to to countNeighbour() is made to count the number of live neighbour cells.
//The cells are changed accordingly.
//Then print output population

   public static void main(String args[]) throws IOException {
	   
	   // Timer to know the execution time.
	   long timeStart = System.currentTimeMillis();

       int grid[][]; //Finite two-dimensional grid 
       
       File file=new File(args[0]); //File path as argument
       //Using Scanner class
       Scanner input=new Scanner(file);
       
       //Integer variable for row
       int row=0;
       while(input.hasNext()) {
               row++;
               input.nextLine();
       }
       input.close();
       input=new Scanner(file);
       grid=new int[row][row];
       // Read data
       for(int m=0;m<row;m++) {
               for(int n=0;n<row;n++) {
            	       grid[m][n]=input.nextInt();
               }
       }
       //Print population
       System.out.println("************Input************");
       for(int m=0;m<row;m++) {
                for(int n=0;n<row;n++) {
                       System.out.print(" "+grid[m][n]);
                }
                System.out.println();
       }

       int count;
       int ngrid[][] = new int[row][row];
   
       //Count live cells and decide the cell to become live or dead
       for(int m=0;m<row;m++) {
               for(int n=0;n<row;n++) {
            	   
            	   //Method call to countNeighbour()
                   count=countNearCells(grid, m, n);
                   if(grid[m][n]==1 && count<2)
                       ngrid[m][n]=0;
                   else if(grid[m][n]==1 && (count==2 || count==3))
                       ngrid[m][n]=1;
                   else if(grid[m][n]==1 && count>3)
                       ngrid[m][n]=0;
                   else if(grid[m][n]==0 && count==3)
                       ngrid[m][n]=1;
               }
       }
       //Print output population
       System.out.println("************Output************");
       for(int i=0;i<row;i++) {
               for(int j=0;j<row;j++) {
                   System.out.print(" "+ngrid[i][j]);
               }
                   System.out.println();
       } 
       long timeStop = System.currentTimeMillis();
       long totalTime = timeStop - timeStart;
       System.out.println("Execution time : " +totalTime);
   } //End of main
}//End of GameofLife Class 
