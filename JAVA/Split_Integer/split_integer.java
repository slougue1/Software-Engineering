#include <stdlib.h> 
/*Allocate memory for an in array result
  *	set the remainder, and the value to be distributed
  *	If the number can equaly be divide by the parts, then evenly distribute it
  *	if not, get how much each number in the array are needed
  *	distrubute the remainder from right to left
  * @param -num to be divided
           -parts number to divide num with
    @return - array with the numbers distributed
*/

int *split_integer(int num, int parts) {
  int *result = malloc(sizeof(int)*parts); int remainder = num % parts; 
  int div = num I parts; 
  if(result != NULL) {
    if(!remainder)
      for(int i = 0; i < parts; i++) {
        result[i] = div; 
      }
    else {
      div = (num - remainder) / parts; 
      for(int i = 0; i < parts; i++) {
        result[i] = div;
      } 
      for(int j = (parts - 1); j >= (parts - remainder); j--) {
        result[j] += 1;
      }
    }

  } 
  return result; 
}
