import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> invalidPasswordsArray;
	ArrayList<String> validPasswordsArray;
	String shortPass = "9ds!A";
	String noUpperPass = "sahfsa95#2";
	String noLowerPass = "109%HGSDGHSGHDGHS";
	String weakPass = "2Aj#Dfg";
	String invalidSequencePass = "gLLL3@@@30592m";
	String noDigitPass = "a#LTDos%$#d";
	
	@Before
	public void setUp() throws Exception {
		String[] containsInvalidPwd = {"Bbbbll#2pfadfd2", "dP1#s", "a,bApgT", "T7$THG."};
		invalidPasswordsArray = new ArrayList<String>();
		invalidPasswordsArray.addAll(Arrays.asList(containsInvalidPwd));		
		
		String[] allValidPasswords = {"aaBBCCabc11%", "Gello@123", "Aeebb@234", "myPassword2%" ,"5sakiHa%"};
		validPasswordsArray = new ArrayList<String>();
		validPasswordsArray.addAll(Arrays.asList(allValidPasswords));		
	}

	@After
	public void tearDown() throws Exception {
		invalidPasswordsArray = null;
		validPasswordsArray= null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		Throwable exception = assertThrows(LengthException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.isValidLength(shortPass);
			}			
		});
		assertEquals("The password must be at least 6 characters long", exception.getMessage());
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		Throwable exception = assertThrows(NoUpperAlphaException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasUpperAlpha(noUpperPass);
			}			
		});
		assertEquals("The password must contain at least one uppercase alphabetic character", exception.getMessage());		
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		Throwable exception = assertThrows(NoLowerAlphaException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasLowerAlpha(noLowerPass);
			}			
		});
		assertEquals("The password must contain at least one lower case alphabetic character", exception.getMessage());
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		Throwable exception = assertThrows(WeakPasswordException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.isWeakPassword(weakPass);
			}			
		});
		assertEquals("The password is OK but weak - it contains fewer than 10 characters", exception.getMessage());
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		Throwable exception = assertThrows(InvalidSequenceException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasSameCharInSequence(invalidSequencePass);
			}			
		});
		assertEquals("The password cannot contain more than two of the same character in sequence", exception.getMessage());
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		Throwable exception = assertThrows(NoDigitException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasDigit(noDigitPass);
			}			
		});
		assertEquals("The password must contain at least one digit", exception.getMessage());	
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(validPasswordsArray);
		assertTrue(results.isEmpty());
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(invalidPasswordsArray); 
		assertEquals(results.size(), 4);
		assertEquals(results.get(0), "Bbbbll#2pfadfd2 -> The password cannot contain more than two of the same character in sequence");
		assertEquals(results.get(1), "dP1#s -> The password must be at least 6 characters long");
		assertEquals(results.get(2), "a,bApgT -> The password must contain at least one digit");
		assertEquals(results.get(3), "T7$THG. -> The password must contain at least one lower case alphabetic character");
	}

	
}

