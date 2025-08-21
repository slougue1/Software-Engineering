/**
 * This is a MorseCodeTree which is specifically used for the conversion of morse code to english. 
 * It relies on a root (reference to root of the tree). 
 * The root is set to null when the tree is empty. 
 * The class uses an external generic TreeNode class which consists of a reference to the data and a reference to the left and right child. 
 * The TreeNode is parameterized as a String, TreeNode This class uses a private member root (reference to a TreeNode) 
 * The constructor will call the buildTree method
 * 
 * @author Sakina Lougue
 */

public class MorseCodeTree implements LinkedConverterTreeInterface<String> 
{
	
	protected TreeNode<String> root = null;
	protected String lastLetter;
	
	/**
	 * This Generic constructor calls the buildTree method
	 */
	public MorseCodeTree() 
	{
		buildTree();
	}
	
	/**
	 * This method adds element to the correct position in the tree based on the code
	 * It will call the recursive method addNode
	 * 
	 * @param code - the code for the new node to be added, example ".-."
	 * @param letter - the letter for the corresponding code, example "r"
	 * @return the MorseCodeTree with the new node added
	 */
	@Override
	public LinkedConverterTreeInterface<String> insert (java.lang.String code, java.lang.String letter) 
	
	{
		this.addNode(this.root, code, letter.toLowerCase());
		
		return this;
	}

	/**
	 * This is a recursive method that adds element to the correct position in the tree based on the code. 
	 * A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. 
	 * The code ".-" would be stored as the right child of the left child of the root Algorithm for the recursive method:
	 * 
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @param letter - the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<java.lang.String> root,
                                  java.lang.String code,
                                  java.lang.String letter) 
	{
		TreeNode<String> newNode = new TreeNode<String>(letter);

		/* This If blocks checks if there is only one character. If yes, then, 
           - if the character is '.' (dot), then store it to the left of the current root
           - else the character is "-" (dash), then store it store to the right of the current root
           - return
		 */

		if (code.length() == 1) 
		{
			if (code.equals(".")) 
			{
				root.setLeft(newNode);
			} 
			else 
			{
				root.setRight(newNode);
			}
		} 
		
		/* This If else block checks if there is more than one character. If yes, then,
            - if the first character is "." (dot), then the new root becomes the left child
            - if the first character is "-" (dash), then the new root becomes the right child
            - new code becomes all the remaining charcters in the code (beyond the first character)
            - call addNode(new root, new code, letter)
		 */
		else if (code.substring(0, 1).equals(".")) 
		{
			this.addNode(root.getLeft(), code.substring(1), letter);
		} 
		
		else 
		{
			this.addNode(root.getRight(), code.substring(1), letter);
		}
	}
	
	/**
	 * This getter get the root Node by returning a reference to the root
	 *  
	 * @return root - reference to root
	 */
	@Override
	public TreeNode<java.lang.String> getRoot() 
	{
		return this.root;
	}	

	/**
	 * This setter sets the root of the MorseCodeTree
	 * 
	 * @param newNode - a copy of newNode will be the new root
	 */
	@Override
	public void setRoot(TreeNode<java.lang.String> newNode) 
	{
		this.root = newNode;		
	}
	
	/**
	 *  This method will call the recursive method fetchNode
	 * 
	 * @param code - the code that describes the traversals to retrieve the string (letter)
	 * @return the string (letter) that corresponds to the code
	 */
	@Override
	public java.lang.String fetch(java.lang.String code)
	{
		return this.fetchNode(this.root, code);
	}

	/**
	 * Iterate Through Nodes To Find Value
	 * 
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @return the string (letter) corresponding to the code
	 */
	@Override
	public java.lang.String fetchNode(TreeNode<java.lang.String> root,
                                                java.lang.String code) 
	{
		
		if (code.length() == 1) 
		{
			this.lastLetter = code.equals(".") ? root.getLeft().getData() : root.getRight().getData();
		}
		else 
		{
			if (code.substring(0, 1).equals(".")) 
			{
				this.fetchNode(root.getLeft(), code.substring(1));
			}
			else 
			{
				this.fetchNode(root.getRight(), code.substring(1));
			}
		}
		
		return this.lastLetter;
	}

	/**
	 * This method returns an ArrayList of the items in the linked Tree in LNR (Inorder) 
	 * traversal order Used for testing to make sure tree is built correctly
	 * 
	 * @return list - an ArrayList of the items in the linked Tree
	 * @throws None
	 */
	@Override
	public java.util.ArrayList<java.lang.String> toArrayList()
	{
		java.util.ArrayList<String> list = new java.util.ArrayList<String>();
		
		this.LNRoutputTraversal(this.root, list);
		
		return list;
	}

	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code. 
	 * The root will have a value of "" (empty string) level one: insert(".", "e"); insert("-", "t"); level two: insert("..", "i"); insert(".-", "a"); insert("-.", "n"); insert("--", "m"); etc. 
	 */
	@Override
	public void buildTree() 
	{
		this.root = new TreeNode<String>("");   //set to an empty space like said in the discription
		

		this.insert(".", "e");
		this.insert("-", "t");
		this.insert("..", "i");
		this.insert(".-", "a");
		this.insert("-.", "n");
		this.insert("--", "m");
		this.insert("...", "s");
		this.insert("..-", "u");
		this.insert(".-.", "r");
		this.insert(".--", "w");
		this.insert("-..", "d");
		this.insert("-.-", "k");
		this.insert("--.", "g");
		this.insert("---", "o");
		this.insert("....", "h");
		this.insert("...-", "v");
		this.insert("..-.", "f");
		this.insert(".-..", "l");
		this.insert(".--.", "p");
		this.insert(".---", "j");
		this.insert("-...", "b");
		this.insert("-..-", "x");
		this.insert("-.-.", "c");
		this.insert("-.--", "y");
		this.insert("--..", "z");
		this.insert("--.-", "q");
	}
	
	/**
	 * Recursively Sort Tree (LNR, In order)
	 * 
	 * @param root - the root of the tree for this particular recursive instance
	 * @param list - the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<java.lang.String> root,
                        java.util.ArrayList<java.lang.String> list) 
	{
		if (root == null) 
		{
			return; 
		}

		this.LNRoutputTraversal(root.getLeft(), list);
		list.add(root.getData());
		this.LNRoutputTraversal(root.getRight(), list);
	}
	
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException 
	{
		throw new UnsupportedOperationException("Unsupported method");
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException 
	{
		throw new UnsupportedOperationException("Unsupported method");
	}
}
