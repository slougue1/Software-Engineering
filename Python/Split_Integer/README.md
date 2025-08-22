This script divide an integer into a number of even parts, which will be returned in a result array. Summing the integers in this result array will produce the original number. 
For example, 
given number = 10 and parts = 2 , splitinteger{10, 2) should return an array of integers with length equal to parts : [5, 5] . 
Not all numbers offer a clean division. In this case, I split the number as closely as possible to even, with the smaller numbers in the front of the array. 
For example, splitinteger(11, 3) -> [3,4,4]
