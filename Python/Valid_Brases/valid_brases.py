#Check first if the first braces is open or not 
#If the first brace is a close braces, then return false 
# 
#@param - str braces set to be evaluated 
#@return - True is the all thebraces matches
#        - Flase if at least brace does'nt match

def valid_braces(str) -> bool:
  openL = ["[","{","("] 
  close =["]","}",")"] 
  myList = list() 
  answer = False
  
  for char in str:
    if char in openL: 
      myList.append(char) 
    elif char in close:
      position = close.index(char) 
      if ((len(myList) > 0) and (openL[position] == myList[len(myList)-1])): 
        myList.pop() 
      else:
        return answer
  if not len(myList): 
    answer = True 
  else: 
    answer = False
    
  return answer 
