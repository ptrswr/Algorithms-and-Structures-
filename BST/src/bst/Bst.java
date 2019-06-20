package bst;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

public class Bst {
	
	public Node root;
	public Visitor v ;
	public Bst() {
		
		root = null;
		v =  new VisitorBST();
	}
	
	private  Node addRec(Node curr, int value)
	{
		if (curr == null) { 
            curr = new Node(value); 
            return curr; 
        } 
  
        if (value < curr.value) 
            curr.left = addRec(curr.left, value); 
        else if (value > curr.value) 
            curr.right = addRec(curr.right, value); 
  
        return curr; 
 
		
	}
	
		
	public boolean contains(int value){
	    return containsHelper(value, root);
	}
	
	private boolean containsHelper(int value, Node root){
	    if(root == null) return false;

	    if(root.value == value) return true;
	    else if (root.value < value) {
	        return containsHelper(value, root.right);
	    }else {
	        return containsHelper(value, root.left);
	    }
	}
	
	private Node deleteRec(Node curr, int value) {
	    if (curr == null) {
	        return curr;
	    }
	 
	    if (value == curr.value) {
	    	 if (curr.left == null) 
	                return curr.right; 
	          else if (curr.right == null) 
	                return curr.left; 
	    	 
	    	  curr.value = minValue(curr.right).value;
	    	  
	            curr.right = deleteRec(curr.right, curr.value); 

	    	
	    } 
	    else if (value < curr.value) {
	        curr.left = deleteRec(curr.left, value);
	    }else {
	    	curr.right = deleteRec(curr.right, value);
	    	
	    }
	    
	    return curr;
	    
	   
	}
	public Node minValue(Node temp) {

		
		if (temp.left == null)
			return temp;

         else
        	 return minValue(temp.left);

   }
	
	public Node maxValue(Node temp) {

		
		if (temp.right == null)
			return temp;
		
		else
			return maxValue(temp.right);
		
	}
	//sukcesor
	private Node findSuccessor(Node curr, Node succ, int value)
	{
		if (curr == null) {
			return null;
		}

		if (curr.value == value)
		{
			if (curr.right != null) {
				return minValue(curr.right);
			}
		}

		else if (value < curr.value)
		{
			succ = curr;
			return findSuccessor(curr.left, succ, value);
		}

		else {
			return findSuccessor(curr.right, succ, value);
		}

		return succ;
	}
	// predecesor
	private  Node findPredecessor(Node curr, Node prec, int value)
	{
		if (curr== null) {
			return prec;
		}

		if (curr.value == value) {
			if (curr.left != null) {
				return maxValue(curr.left);
			}
		}

		else if (value < curr.value) {
			return findPredecessor(curr.left, prec, value);
		}

		else {
			prec = curr;
			return findPredecessor(curr.right, prec, value);
		}
		return prec;
	}

	public void insert(int value) {
		
		if( !contains(value) )	  
	    root = addRec(root, value);
		else
		throw new RuntimeException("element jest w liście");

	}
	public void delete(int value) {
		if( contains(value) )	  
		root = deleteRec(root, value);
		else
		throw new NoSuchElementException();

	}
	public int lower(int value) {
		if( contains(value) ) {	
			Node result = findPredecessor(root, null, value);
			if(result!=null)
			return result.value;
			else 
				throw new NoSuchElementException("Dany element jest najmniejszy w drzewie");
		}
		else
		throw new NoSuchElementException();
	}
	public int upper(int value) {
		if( contains(value) ) {	
			Node result = findSuccessor(root, null, value);
			if(result!=null)
			return result.value;
			else 
				throw new NoSuchElementException("Dany element jest największy w drzewie");
		}
		else
		throw new NoSuchElementException();

	}
	//METODY WYŚWIETLANIA--------------------
	
	//metoda in order
	public void inOrder() {
        this.inOrder(v,root);
    }

    private void inOrder( Visitor v, Node curr) {

        if(curr == null) {
            return;
        }

        inOrder(v,curr.left);
        curr.accept(v);
        inOrder(v,curr.right);

    }
    
    //Metoda pre order
    
    public void preOrder() {
        this.preOrder(v,root);
    }

    private void preOrder(Visitor v,Node curr) {
        if (curr == null) {
            return;
        }
       
        curr.accept(v);

        this.preOrder(v,curr.left);
        this.preOrder(v,curr.right);
    }
        
    // Metoda post order
        

    public void postOrder() {
        this.postOrder(v,root);
    }

    private void postOrder(Visitor v,Node curr) {
        if (curr == null) {
            return;
        }

        this.postOrder(v,curr.left);
        this.postOrder(v,curr.right);
        curr.accept(v);
    }
    
    public void printTree (int i)
    {
    	switch(i) {
    		case 1: 
    			preOrder();
    			break;
    		case 2:
    			postOrder();
    			break;
    		case 3:
    			inOrder();
    			break;
    		default:
    			throw new InvalidParameterException();
    	}
    }
    public void clear()
    {
    	this.root=null;
    }
  

	
}
