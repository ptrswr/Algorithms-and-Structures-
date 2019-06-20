package bst;

public class VisitorBST implements Visitor{

	@Override
	public void showValue(Node curr) {
		// TODO Auto-generated method stub
		System.out.print(curr.toString());
		
	}

}
