package app.treenode;

public class Node
{
	public String element;
	public Node leftChild, rightChild;	
	
	public Node(String element)
	{
		this.element = element;
		leftChild = null;
		rightChild = null;
	}
}