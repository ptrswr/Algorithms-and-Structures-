package binomial_heap;

public class Node implements Comparable<Node>
{

    public int key;
    public int degree;
    public Node parent;
    public Node child;
    public Node sibling;



    public Node(int key) {
        this.key = key;
    }

    public int compareTo(Node other) {
        return Integer.compare(this.key, other.key);
    }

    public void print(int level) {
        Node curr = this;
        while (curr != null) {
            for (int i = 0; i < level; i++) {
                System.out.print(" ");
            }
            System.out.print(curr.key +"\n");
            if (curr.child != null) {
                curr.child.print(level + 1);
            }
            curr = curr.sibling;
        }
    }
}
