
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the student MorseCodeConverter JUnit test
 * @author Sakina Lougue
 */
public class MorseCodeConverter_STUDENT_Test 
{
	/**
	 * This is the generic LNR Test
	 */
	@Test
	public void testPrintTree()	
	{
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}
	
	/**
	 * convert from the Code to English words
	 */
	@Test
	public void testConvertToEnglishString() 
	{
		assertEquals("my name is sakina", MorseCodeConverter.convertToEnglish("-- -.-- / -. .- -- . / .. ... / ... .- -.- .. -. .-"));
		assertEquals("and", MorseCodeConverter.convertToEnglish(".- -. -.."));
		assertEquals("i would like to become an engineer", MorseCodeConverter.convertToEnglish(".. / .-- --- ..- .-.. -.. / .-.. .. -.- . / - --- / -... . -.-. --- -- . / .- -. / . -. --. .. -. . . .-."));
		
	}

	/**
	 * Convert the file to English words
	 * @throws FileNotFoundException
	 */
	@Test
	public void testConvertToEnglishFile() throws FileNotFoundException
	{
		assertEquals("give me your answer do", MorseCodeConverter.convertToEnglish(this.getFile("Daisy.txt")));
		assertEquals("im half crazy all for the love of you", MorseCodeConverter.convertToEnglish(this.getFile("DaisyDaisy.txt")));
		assertEquals("how do i love thee let me count the ways", MorseCodeConverter.convertToEnglish(this.getFile("HowDoILoveThee.txt")));
		assertEquals("love looks not with the eyes but with the mind", MorseCodeConverter.convertToEnglish(this.getFile("LoveLooksNo.txt")));
	}

	/**
	 * Fetch File
	 * @param  filename
	 * @return  file
	 */
	protected File getFile(String name) 
	{
		JFileChooser fchooser = new JFileChooser();
		String result = "";
		
		fchooser.setDialogTitle("Select Input File: " + name);
		
		if (fchooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
		{
			try 
			{
				return fchooser.getSelectedFile();
			} catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		return null;
	}
}
