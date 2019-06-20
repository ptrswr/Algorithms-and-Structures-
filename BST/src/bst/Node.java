package bst;

public class Node {
	public Node left;
	public Node right;
	public int value;
	
	public Node(int value)
	{
		this.value= value;
	}
	public String toString()
	{
		return " " + value;
	}

	public void accept(Visitor v)
	{
		v.showValue(this);
	}
	
}
