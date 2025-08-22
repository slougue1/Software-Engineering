import java.io.*; 

/*this set the tabe from wikipedie in a string or an array with each element in it
  *	Then it make str a string with multiple of 3 caracters
  *	Then the rest of str will have a number (multple of 3) of characters
  *	Loop trough the new str by block of 3 to shift and ad in the bits
  *	num24 have 24 bits, then break into 4 number of 6 bits: num1,2,3and 4
  *@param - str string to be decoded
  *@return - the decoded string
*/

class Challenge {
  static String table = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
  public static String toBase64(String str) {
    char[] mystr = new char[1000]; 
    char[] myTable = table.toCharArray();; int len = str.length() % 3; 
    int num24, num1, num2, num3, num4; 
    String decode = ""; 
    String pad = "";
    
    if (len > 0) {
      for (len = 0; len < 3; len++) {
        pad += "="; 
        str += "\0";
      }
    }
    myStr = str.toCharArray(); 
    for (len = 0; len < str.length(); len += 3) {
      num24 = (mystr[len] << 16) + (mystr[len + 1] << 8)+ (mystr[len + 2]); 
      num1 = (num24 >> 18) & 63; 
      num2 = (num24 >> 12) & 63; 
      num3 = (num24 >> 6) & 63; 
      num4 = num24 & 63; 
      decode += "" + myTable[num1] + myTable[num2]+ myTable[num3] + myTable[num4];
    }
    return decode.substring(0, decode.length() - pad.length()) + pad;
  }
}
