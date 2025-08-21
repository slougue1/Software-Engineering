/**
 * The MorseCodeConverter contains a static MorseCodeTree object and constructs the MorseCodeTree.
 * It is also a converter utility
 * 
 * @author Sakina Lougue
 */

public class MorseCodeConverter 
{
	
	protected static MorseCodeTree tree = new MorseCodeTree();
	
	/**
	 * This method Converts Morse code into English.
	 * It converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
       For example Example, if code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -..". Then the string 
       returned should be "Hello World"
	 * @param code - a string the morse code 
	 * @return the English translation
	 */
	
	public static java.lang.String convertToEnglish(java.lang.String code) 
	{
		String result = "";                //Hold the final English translation and set to the empty string because we will acuumulate other words to it
		String[] word1 = code.split(" / ");//use a string method to insert / in the code 
		
		/* OUTER FOR-LOOP
		 * It loops through the string morse code to any space to convert it in letters and
		 * any / to be converted in letters combinations.
		 */
		
		for (String word : word1) 
		{
			String[] letters = word.split(" ");
			
			for (String letter : letters) 
			{
				result += MorseCodeConverter.tree.fetch(letter);   //add each every letter translated to it
			}
			
			result += " ";  //making sure that each words are separated from each other to make miningfull sentences
		}
		
		return result.trim();
	}

	/**
	 * This method converts a file of Morse code into English Each letter is delimited by a space (‘ ‘).
	 * Each word is delimited by a ‘/’. For example, a file that contains ".... . .-.. .-.. --- / .-- --- .-. .-.. -..".
	 * Then the string returned should be "Hello World"
	 * @param codeFile - name of the File that contains Morse Code
	 * @return the English translation of the file
	 * @throws java.io.FileNotFoundException
	 */
	
	public static java.lang.String convertToEnglish(java.io.File codeFile) throws java.io.FileNotFoundException 
	{
		/*
		 * this if block check if the codeFile is valid or not to be tranlated. If it is, (meaning, looking like the
		 * the example above), then the code will skip to translation part. However, if the code is null then an 
		 * error message will be sent
		 */
		
		if (codeFile == null) 
		{
			throw new java.io.FileNotFoundException("File provided was null"); 
		}
		
		java.util.ArrayList<String> lines = new java.util.ArrayList<String>();
		java.util.Scanner scanner = new java.util.Scanner( codeFile);  //read from one of the codeFiles provided      
		String result = "";     //Hold the final English translation and set to the empty string because we will acumulate other words to it
		
		/* WHILE-LOOP
		 * Loop through the file text provide to check if there is anymore line to be translated.
		 * If there is, It will be translated. If there is not, then the program ends
		 */
		
		while (scanner.hasNext()) 
		{
			lines.add(scanner.nextLine());
		}
		
		for (int index = 0; index < lines.size(); index++) 
		{
			result += MorseCodeConverter.convertToEnglish(lines.get(index));   //add each every letter translated to it
		}
		
		scanner.close();
		return result.trim();
	}

	/**
	 * This method print a Previously Generated MorseCodeTree. 
	 * It returns a string with all the data in the tree in LNR order with an space in between them. 
	 * It uses the toArrayList method in MorseCodeTree it should return the data in this order: "h s v i f u e l r a p w j b d x n c k y t z g q m o"
	 * @return  the data in the tree in LNR order separated by a space.
	 */
	
	public static java.lang.String printTree() 
	{
		/* 
		 * This small if block checks if the tree is null or not before translating it.
		 */
		
		if (tree == null) 
		{
			return ""; 
		}
		
		java.util.ArrayList<String> list = tree.toArrayList();
		String result = "";  //Hold the final English translation and set to the empty string because we will acumulate other words to it
		
		for (String letter : list) 
		{
			result += letter + " ";     //add each every letter and words translated to the accumulator an a apace in between each word to make the sentence readable
		}
			
		return result.trim();
	}
}
