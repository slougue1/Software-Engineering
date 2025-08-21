/**
 * This generic class is used in the MorseCodeTree classes. 
 * The class consists of a reference to the data and a reference to the left and right child
 * It is the external Tree Node for Linked Trees
 * @author Sakina Lougue
 */

public class TreeNode<T> 
{
	
	protected T data = null;
	protected TreeNode<T> left;            //Hold the left child
	protected TreeNode<T> right;           //hold the right child
	
	/**
	 * This parametrised constructore create a new TreeNode with left and right child 
	 * and set to null and data set to the dataNode 
	 * @param dataNode - the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode) 
	{
		 left = null;            
		 right = null;
		 this.data = dataNode;
	}
	
	/**
	 * This parameterised constructor is used for making deep copies
	 * @param node - to make copy of
	 */
	public TreeNode(TreeNode<T> node) 
	{
		this.data = node.getData();
	}
	
	/**
	 * This small method set the left Node
	 * @param node - to make copy of
	 */
	public void setLeft(TreeNode<T> node) 
	{
		this.left = node;
	}
	
	/**
	 * This small method set the right Node
	 * @param node - to make copy of
	 */
	public void setRight(TreeNode<T> node) 
	{
		this.right = node;
	}
	
	/**
	 * This getter return the data within this TreeNode
	 * @return data - the data within the TreeNode
	 */
	public T getData() 
	{
		return this.data;
	}
	
	/**
	 * This getter return the left node
	 */
	public TreeNode<T> getLeft() 
	{
		return this.left;
	}
	
	/**
	 * This getter return the right node
	 */
	public TreeNode<T> getRight() 
	{
		return this.right;
	}
}