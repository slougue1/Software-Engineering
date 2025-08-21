/**This is the data manager class that the FX driver class will use to run and compile successfully
 * This class contains 5 methods, one to check the boundaries, two to encrypt and to decrypt using the caesar cipher
 * and two to encrypt and to decrypt using the bellaso cipher
 *@author Sakina Lougue
*/
public class CryptoManager {

	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) 
	{
		boolean rtnValue =true;  //Set the return value to true
		
		//This loop will check each character of the plain text to see if one character is out of the bound or not
		for(int index=0; index<plainText.length();index++)
		{
			//This if statement will return true if a character is within the bound
			if ((plainText.charAt(index) >=(LOWER_BOUND)) && (plainText.charAt(index)<=(UPPER_BOUND) )) 
				rtnValue = true;
            
			//This else statement will return false and will not go back to check another character since one is out of the bound
			else
			{
				return false;
			}
		}
		return rtnValue;

	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) 
	{
		String encrypt = "";   //Set the final string result of the encrypted text to the empty space
		
		/*This loop will add and distribute the key to each character of the plain text
		 *The number of iteration will be the same as the number of character in the plain text
		 */
			for(int index=0; index < plainText.length();index++)
			{
				char ch = plainText.charAt(index);//This hold a character of the plain text
				char ch1 = (char)(ch+key);        //This add the corresponding character of the plain text to the key 
				                                  //It starts the encryption

			  /* After Adding the character to the key, if the the sum is greater than the upper bound(95)
			   *This while loop will be executed by subtracting the range(64) to the sum to bring the sum down(less than 95)
			   *It will loop over and over until the sum is less than 95
			  */
				while (ch1 > UPPER_BOUND)
				{
					ch1 -= RANGE;
				}
				
				//This statement will be executed only if the sum is less than the upper bound
				//This statement add to the empty space the sum of the character of the plain text and the key
				encrypt +=(char)ch1;
			}
			
		//This will return the final result of all the character in the plain text encrypted by the key
		return encrypt;
	
	}
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) 
	{
		String encrypt = "", key="";  //Set the final string result of the encrypted text and the key to the empty space
		                              //Since we are using the the Bellaso cipher, the key as to be a string instead of an integer 

		/*This for loop will be executed if and only if the length of the key is different than the length of the plain text
		 * It will distribute and add the first character of the key to the first character of the plain text and so forth
		 * If the the key's characters are shorter than the plaintext's, the distribution will restart by 
		    adding the first character of the key to whatever character the previous distribution stopped at
		 */
		for (int index=0;key.length()!=plainText.length();)
		{
			key+=bellasoStr.charAt(index); //Add to the key a character of the bellaso string to form a real key         
			index++;                       //Increment the index so that it will be an infinite loop

			/*This will be executed whenever all characters of the string key were added to the corresponding
			   characters of the plain text and there are still some left characters of the plain text
			   that were not added to key because the key is too short.
			*/
			if(index==bellasoStr.length())  
				index=0;  //The index is reset to 0, so that the first, second,... character of the key will be added to
			              //the rest of the plain text's characters that didn't receive an addition
		}
 
		/*As the key is a string, this for loop check to see if after adding the string key to the string plain text
		   the result is not out of the bound
		 *If the result is out of the bound, then the program will keep on subtracting or adding the range to the result
		   until the result is within the bound
	     */
		for(int index=0, result;index<plainText.length();index++)
		{
			result=plainText.charAt(index)+key.charAt(index);

			if(result <LOWER_BOUND || result>UPPER_BOUND)
			{   
				//this will add the range(64) to the result until the result is greater than the lower bound(32)
				while(result<LOWER_BOUND)
					result+=RANGE; 
				//this will subtract the range(64) to the result until the result is less than the upper bound(32)
				while(result>UPPER_BOUND)
					result-=RANGE;  
			} 
			//This statement will be executed only if the result is within the boun
			//This statement add to the empty space the sum of the character of the plain text and the character of the key
			encrypt+=(char)result;
		}

		//This will return the final result of all the character in the plain text encrypted by the key
		return encrypt;
	}

	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) 
	{
		String decrypt = "";//Set the final string result of the decrypted text to the empty space
		
		/*This loop will subtract distribute and the key to each character of the encrypted text
		*The number of iteration will be the same as the number of character in the encrypted text
		*/
		for(int index=0; index < encryptedText.length();index++)
		{
			char ch = encryptedText.charAt(index);//This hold a character of the encrypted text
			int ch1 = ch-key;                     //This add the corresponding character of the encrypted text to the key 
                                                  //It starts the encryption
			
			 /* After subtracting the character to the key, if the the difference is lower than the lower bound(32)
			     this while loop will be executed by adding the range(64) to the difference to bring the difference up(greater than 32)
			   *It will loop over and over until the difference is greater than 32
			  */
			while (ch1 <LOWER_BOUND)
			{
				ch1 += RANGE;
			}
			
			//This statement will be executed only if the difference is greater than the lower bound
			//This statement add to the empty space the difference of the character of the encrypted text and the key
			decrypt +=(char)ch1;

		}
		
		//This will return the final result of all the character in the encrypted text encrypted by the key
		return decrypt;

	}


	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String decrypt = "", key="";
 
		/*This is the same as the encrypt bellaso, the only difference is that we are subtracting the string key from
		   the the encrypted text 
		  */
		for (int index=0;key.length()!=encryptedText.length();)
		{
			key+=bellasoStr.charAt(index);          
			index++;

			if(index==bellasoStr.length())
				index=0;
		}

		for(int index=0, result;index<encryptedText.length();index++)
		{
			result=encryptedText.charAt(index)-key.charAt(index); //Subtract from the encrypted text

			if(result<LOWER_BOUND || result >UPPER_BOUND)
			{                
				while(result<LOWER_BOUND)
					result+=RANGE;  
				while(result>UPPER_BOUND)
					result-=RANGE; 
			}        
			decrypt+=(char)result;
		}

		return decrypt;
	}
}