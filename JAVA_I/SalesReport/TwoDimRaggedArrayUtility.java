/**This utility works with 2 dimensional ragged arrays with a maximum of 10 rows and 10 columns
  *This utility works with negative and positive numbers
  *This is a utility class - there are no private data members
  *@author Sakina Lougue 
 * */
import java.io.*;
import java.util.*;
import java.lang.*;
import java.io.*;

class TwoDimRaggedArrayUtility
{
	
      /**definition of the method readFile pass in a file and return a two dimensional ragged array of doubles
       * @param file  -the file to read from
       * @return raggedArr -a two dimensional ragged (depending on data) array of doubles 
                           -if the file is not empty, returns a null if file is empty
       * @throws java.io.FileNotFoundException -if file is not valid
       */
     public static double[][] readFile(File file) throws java.io.FileNotFoundException
     {
          double[][] raggedArr = new double[6][];
          String line;
          int index = 0;
          try
          {
              // open the file
              BufferedReader br = new BufferedReader(new FileReader(file));
              // read from the file
              while ((line = br.readLine()) != null)
              {
                   String[] temp = line.split(" ");
                   int size = temp.length;
                   raggedArr[index] = new double[size];
                   // convert in doubles
                   for (int index1 = 0; index1 < size; index1++)
                   {
                        raggedArr[index][index1] = Double.parseDouble(temp[index1]);
                   }
                   index++;
              }
              br.close();
          }
          catch (Exception epxcep)
          {
        	  epxcep.printStackTrace();
          }
          return raggedArr;
     }

      /**definition of the method writeToFile that passes in a two dimensional ragged array of doubles and a file,
         and writes the ragged array into the file. Each row is on a
         separate line and each double is separated by a space.
         @param data -two dimensional ragged array of doubles
         @param outputFile -the file to write to
         @throws java.io.FileNotFoundException -if outputFile is not valid
      */

     public static void writeToFile(double[][] data, java.io.File outputFile) throws java.io.FileNotFoundException
     {
          try
          {
              // open the file
              BufferedWriter br = new BufferedWriter(new FileWriter(outputFile));
              // read the array and print into file with spaces
              for (int row = 0; row < data.length; row++)
              {
                   for (int col = 0; col < data[row].length; col++)
                   {
                        br.write(data[row][col] + " ");
                   }
                   br.newLine();
              }
              br.close();
          }

          catch (Exception ep)
          {
              ep.printStackTrace();
          }
     }

      /**definition of the method getTotal
       pass in a two dimensional ragged array of doubles
       and returns the total of the elements in the array.
       @param data -the two dimensional array getting total of
       @return total -the sum of all the elements in the two dimensional array
      */

     public static double getTotal(double[][] data)
     {
          double total = 0;
          // find the sum of the values of the 2D array
          for (int i = 0; i < data.length; i++)
          {
              for (int j = 0; j < data[i].length; j++)
              {
                   total += data[i][j];
              }
          }
          return total;
     }

     /**definition of the method getAverage
       pass in a two dimensional ragged array of doubles
       and returns the average of the elements in the array
       @param data -the two dimensional array getting total of
       @return Double(total / numOfElements)
      */

     public static double getAverage(double[][] data)
     {
          double total = 0;
          int numOfElements = 0;
          // find the sum of the values of the 2D array
          for (int i = 0; i < data.length; i++)
          {
              for (int j = 0; j < data[i].length; j++)
              {
                   total += data[i][j];
                   numOfElements += 1;
              }
          }
          // find and return the average
          return  (total / numOfElements);
     }

     /**definition of the method getRowTotal
        pass in a two dimensional ragged array of doubles and a row index
        and returns the total of that row. Row index 0 is the first row in the
        array.
        @param data -the two dimensional array getting total of
        @param row index to take the total of (0 refers to the first row)ndex
      */

     public static double getRowTotal(double[][] data, int row)

     {
          double total = 0;
          for (int j = 0; j <data[row].length; j++)
          {
              total += data[row][j];
          }

          return total;
     }

      /**definition of the method getColumnTotal
         pass in a two dimensional ragged array of doubles
         and a column index and returns the total of that column.
         @param data - the two dimensional array
         @param col - the column index to take the total of (0 refers to the first column)
         @return total of the column
      */

     public static double getColumnTotal(double[][] data, int col)
     {
          double total = 0;
          for (int i = 0; i < data.length; i++)
          {
              if (col <= data[i].length - 1)
                   total += data[i][col];
          }
          return total;
     }

     /**definition of the method getHighestInRow
        pass in a two dimensional ragged array of doubles and a
        row index and returns the largest element in that row.
        @param data -the two dimensional array
        @param row -the row index to find the largest element of (0 refers to the first row)
        @return highest -the largest element of the row
      */

     public static double getHighestInRow(double[][] data, int row)
     {
          double highest = data[row][0];
          for (int j = 0; j < data[row].length; j++)
          {
              if (data[row][j] > highest)
                   highest = data[row][j];
          }
          return highest;
     }

     /**8 definition of the method getHighestInRowIndex
        takes a two dimensional ragged array of doubles and a
        row index and returns the index of the largest element in that row
        @param data -the two dimensional array
        @param row -the row index to find the largest element of (0 refers to the first row)
        @return index -the largest element of the row
      */

     public static int getHighestInRowIndex(double[][] data, int row)

     {

          int index = 0;
          for (int i = 0; i < data[row].length; ++i)
          {
              if (data[row][i] > data[row][index])
              {
                   index = i;
              }
          }
          return index;
     }

      /**definition of the method getLowestInRow
         takes a two dimensional ragged array of doubles and a
         row index and returns the smallest element in that row.
         @param data -the two dimensional array
         @param row -the row index to find the largest element of (0 refers to the first row)
         @return lowest -the smallest element of the row
      */

     public static double getLowestInRow(double[][] data, int row)
     {
          double lowest = 0;
         // if(row>=0)
          for (int j = 0; j < data[row].length; j++)
          {
              if (data[row][j] < lowest || lowest == 0)
                   lowest = data[row][j];
          }
          return lowest;
     }

      /**10 definition of the method getLowestInRowIndex
        takes a two dimensional ragged array of doubles and a
        row index and returns the index of the smallest element in that row.
        @param data -the two dimensional array
        @param row -the row index to find the largest element of (0 refers to the first row)
        @return index -the index of the smallest element of the row
      */

     public static int getLowestInRowIndex(double[][] data, int row)
     {
          int index = 0;
          for (int i = 0; i < data[row].length; ++i)
          {
              if (data[row][i] < data[row][index])
              {
                   index = i;
              }
          }
          return index;
     }

      /**definition of the method getHighestInColumn
         pass in a two dimensional ragged array of doubles
         and a column index and returns the largest element in that column
        @param data -the two dimensional array
        @param col - the column index to find the largest element of (0 refers to the first column)
        @return highest the largest element of the column
        */

     public static double getHighestInColumn(double[][] data, int col)
     {
          double highest = 0;
          for (int i = 0; i < data.length; i++)
          {
        	  if(col<data[i].length && data[i][col]>highest )
        		  highest = data[i][col];
          }
         
          return highest;
     }

     /** 12 definition of the method getHighestInColumnIndex
      takes a two dimensional ragged array of doubles and a
      row index and returns the index of the largest element in that column.
      @param data -the two dimensional array
      @param col - the column index to find the largest element of (0 refers to the first column)
      @return highest -the index of the largest element of the column
      */

     public static int getHighestInColumnIndex(double[][] data, int col)

     {
    	 double highest = getHighestInColumn(data,col);
    	 int index=0;
         for (int i = 0; i < data.length; i++)
         {
             if (col < data[i].length && data[i][col] ==highest )
             {
            	 index=i;
             }
         }
         return index;
     }

      /**definition of the method getLowestInColumn
         pass in a two dimensional ragged array of doubles and a column
         index and returns the smallest element in that column
          @param data -the two dimensional array
        @param col - the column index to find the largest element of (0 refers to the first column)
        @return lowest -the smallest element of the column
      */

     public static double getLowestInColumn(double[][] data, int colIndex)

     {
          double lowest = 0;
          for (int i = 0; i < data.length; i++)
          {
              if (colIndex <= data[i].length - 1)
                   if (data[i][colIndex] < lowest || lowest==0)
                        lowest = data[i][colIndex];
          }
          return lowest;
     }

      /**14 definition of the method getLowestInColumnIndex
         takes a two dimensional ragged array of doubles and a
         row index and returns the index of the lowest element in that column.
         @param data -the two dimensional array
         @param col - the column index to find the largest element of (0 refers to the first column)
         @return index of the smallest element of the column
      */

     public static int getLowestInColumnIndex(double[][] data, int colIndex)
     {
    	 double lowest = data[0][colIndex];
    	 int index=0;
         for (int i = 0; i < data.length; i++)
         {
             if (colIndex <= data[i].length - 1)
                  if (data[i][colIndex] < lowest) {
                       lowest = data[i][colIndex];
                       index=i;
                  }
         }
         return index;
    	 
     }

      /**definition of the method getHighestInArray
         pass in a two dimensional ragged array of doubles
         and returns the largest element in the array.
         @param data - the two dimensional array
         @return highest -the largest element in the two dimensional array
      */

     public static double getHighestInArray(double[][] data)
     {
          double highest = data[0][0];
          for (int i = 0; i < data.length; i++)
          {
              for (int j = 0; j < data[i].length; j++)
              {
                   if (data[i][j] > highest)
                        highest = data[i][j];
              }
          }
          return highest;
     }

      /**definition of the method getLowestInArray
         pass in a two dimensional ragged array of doubles
         and returns the smallest element in the array.
         @param data - the two dimensional array
         @return lowest -the smallest element in the two dimensional array
      */
     public static double getLowestInArray(double[][] data)
     {
          double lowest = data[0][0];
          for (int i = 0; i < data.length; i++)
          {
              for (int j = 0; j < data[i].length; j++)
              {
                   if (data[i][j] < lowest)
                        lowest = data[i][j];
              }
          }
          return lowest;
     }
}