import java.util.ArrayList;
import java.util.function.BooleanSupplier;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**PasswordCheckerUtility Class
 * This program creates an application that will check for valid passwords.  
 * To create a valid password a certain rules must be followed:
 * at least 6, 1 numeric, 1 lowercase, 1 special, uppercase character, 
 * 10 or more characters is a strong password, between 6 and 9 characters is a weak (but acceptable) password.
 * For example, "Hello@123", "Aaabb@123 " will be OK but "AAAbb@123 " will not.
 * 
 * @author Sakina Lougue
 *
 */
public final class PasswordCheckerUtility 
{

	/**
	 * This method checks the password length since the password must be at least 6 characters long
	 * @param passwors string will be used to check length
	 * @return true if length > 6 characters, otherwise throws Length exception, and false if an invalid password
	 * @throws LengthException thrown if does not meet min length requirement
	 */
	static boolean isValidLength (java.lang.String password ) throws LengthException
	{
		if (password.length()<6) 
			throw new LengthException();
		else
			return true;
	}

	/**
	 * This method Checks the password alpha character since the Password must contain an uppercase alpha character
	 * @param password string string to be checked for alpha character requirement
	 * @return true if meet alpha character requirement
	 * @throws NoUpperAlphaException thrown if does not meet alpha character requirement

	 */
	static boolean hasUpperAlpha(java.lang.String password) throws NoUpperAlphaException 
	{
		if(password.equals(password.toLowerCase())) 
			throw new NoUpperAlphaException();
		else
			return true;
			
	}
	
	/**
	 * This method checks the password lowercase requirement since the Password must contain a lowercase alpha character
	 * @param password string to be checked for lowercase requirement
	 * @return true if meet lowercase requirement
	 * @throws NoLowerAlphaException thrown if does not meet lowercase requirement
	 */
	static boolean hasLowerAlpha(java.lang.String password) throws NoLowerAlphaException {

		if(password.equals(password.toUpperCase())) 
			throw new NoLowerAlphaException();
		else
			return true;

	}
	
	/**
	 * Method to check if string has at least one digit
	 * @param pass string for which to check if it has at least one digit
	 * @return true if there's a digit, throws NoDigitException otherwise 
	 * @throws NoDigitException
	 */
	static boolean hasDigit(java.lang.String password) throws NoDigitException 
	{
		char[] password1=password.toCharArray();
		int count=0;
		
		for(int index=0;index<password1.length;index++) {
			if(Character.isDigit(password1[index])) {
				count++;
			}
		}
		if(count==0) {
			throw new NoDigitException();
		}
		else {
			return true;
		}

	}
	
	/**
	 * This method Checks the password SpecialCharacter requirement since the Password must contain a Special Character
	 * @param password - - password string to be checked for SpecialCharacter requirement
	 * @return true if meet SpecialCharacter requirement
	 * @throws NoSpecialCharacterException thrown if does not meet SpecialCharacter requirement
	 */
	static boolean hasSpecialChar(java.lang.String password) throws NoSpecialCharacterException 
	{
		String reg="[a-zA-Z0-9]*";
		Pattern pat=Pattern.compile(reg);
		Matcher mat=pat.matcher(password);
		
		if(mat.matches()) {
			throw new NoSpecialCharacterException();
		}
		else {
			return true;
		}
		

	}
	
	/**
	 * This method Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
	 * @param password string to be checked for Sequence requirement repeats 3 or more time 
	 * @return sequence false if does NOT meet Sequence requirement
	 * @throws InvalidSequenceException thrown if does not meet Sequence requirement
	 */
	static boolean hasSameCharInSequence(java.lang.String password) throws InvalidSequenceException {		
		
		/*Pattern pat=Pattern.compile("^.*(.)\\1\\1.*$");
		Matcher mat=pat.matcher(pass);
		if(mat.find()) {
			throw new InvalidSequenceException();
		}
		else {
			return true;
		}
		*/
		
		boolean sequence=true;
		
		for (int i=0;i<=password.length()-2;i++) 
		{ 
			if(password.charAt(i)==password.charAt(i+1))
			{
				if (password.charAt(i)==password.charAt(i+2)) 
				{
					sequence=false;
					
					throw new InvalidSequenceException();
				}
				
			}
		}
		return sequence;
		
	}
	
	/**
	 * This method checks if the password fulfills requirements to be consider a valid password
	 * @param password - - string to be checked for validity
	 * @return true if valid password, false if an invalid password
	 * @throws LengthException  thrown if length is less than 6 characters
	 * @throws NoDigitException thrown if no digit
	 * @throws NoUpperAlphaException thrown if no uppercase alphabetic
	 * @throws NoLowerAlphaException thrown if no lowercase alphabetic
	 * @throws NoSpecialCharacterException thrown if does not meet SpecialCharacter requirement
	 * @throws InvalidSequenceException thrown if more than 2 of same character.
	 */
	public static boolean isValidPassword(java.lang.String password) throws LengthException, NoDigitException,
    NoUpperAlphaException,
    NoLowerAlphaException,
    NoSpecialCharacterException,
    InvalidSequenceException 
	{
		boolean lengnth=false, uperCase=false,lowerCase=false, digit=false, special=false, sequence=false, index=true;	
		try {
			lengnth=isValidLength(password);
			uperCase=hasUpperAlpha(password);
			lowerCase=hasLowerAlpha(password);
			digit=hasDigit(password);
			special=hasSpecialChar(password);
			sequence=hasSameCharInSequence(password);
			
		}
		finally {
			if (lengnth==true&&uperCase==true&&lowerCase==true&&digit==true&&special==true&&sequence==true) {
				index=true;
			}
			else {
				index=false;
			}
		}
		return index;
	}
	
	/**
	 * This method Checks if password is valid but between 6 -9 characters
	 * @param password - - string to be checked if weak password
	 * @return true if length of password is between 6 and 9 (inclusive).
	 * @throws WeakPasswordException thrown if the password is weak
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException
	{
		boolean weak=false;
		if(password.length()<10) {
			throw new WeakPasswordException();
		}
		else 
			return weak;
		/*boolean weak=false;
		if(password.length()>=6 && password.length()<=9) {
			throw new WeakPasswordException();
		}
		
		return weak;*/
	}
	
	/**
	 * This method reads a file of passwords and the passwords that failed the check will be added to an invalidPasswords with the reason
	 * @param passwords list of passwords read from a file
	 * @return password1 - ArrayList of invalid passwords in the correct format
	 */
	public static java.util.ArrayList<java.lang.String> getInvalidPasswords(java.util.ArrayList<java.lang.String> passwords)
	{
		ArrayList<String>password1=new ArrayList<String>();
		String invalidPasswords=null;
		for (int index=0;index<passwords.size();index++) 
		{	
			try {
				invalidPasswords=passwords.get(index);
				if(!isValidPassword(invalidPasswords)) 
				{
					invalidPasswords = invalidPasswords+"";
				}
			}
			catch(Exception found) {
				password1.add(invalidPasswords+ " -> "+found.getMessage());
			}
		}
		
		return password1;		
	}

	/**
	 * This method Compare equality of two passwords
	 * @param password  string to be checked for
              passwordConfirm  string to be checked against password for
	 * @return bool true if both are the same
	 */	

	public static boolean comparePasswordsWithReturn (java.lang.String password, java.lang.String passwordConfirm) 
	{
		boolean bool = false;
		if (passwordConfirm.equals(password))
		{
			bool = true;
		}
			return bool;
		
	}

	/**
	 * This method Compare equality of two passwords
	 * @param password  string to be checked for
              passwordConfirm  string to be checked against password for
	 * @throws UnmatchedExceptionthrown if not same
	 */	
	public static void comparePasswords(java.lang.String password, java.lang.String passwordConfirm) throws UnmatchedException
	{
       if (!passwordConfirm.equals(password))
    		   throw new UnmatchedException();
	}

	public static boolean hasBetweenSixAndNineChars(String between6And9Chars) {
		if(between6And9Chars.length()>=6  && between6And9Chars.length()<=9 ) 
			return true;
		
		return false;
	}
}
