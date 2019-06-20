package binomial_heap;

import java.security.InvalidParameterException;

public class BinomialHeap {
    public Node head;

    public BinomialHeap(Node node){
        head=node;
    }
    public BinomialHeap(){
        head=null;
    }


    public boolean isEmpty(){return head==null;}

    public void insert(int key) {
        Node node = new Node (key);
        BinomialHeap tempHeap = new BinomialHeap(node);
        head = union(tempHeap);
    }
    public int minimum() {
        if (head == null) {
            return (Integer)null;
        } else {
            Node min = head;
            Node next = min.sibling;

            while (next != null) {
                if (next.compareTo(min) < 0) {
                    min = next;
                }
                next = next.sibling;
            }

            return min.key;
        }
    }
    public Node extractMin() {
        if (head == null) {
            return null;
        }

        Node min = head;
        Node minPrev = null;
        Node  next = min.sibling;
        Node  nextPrev = min;

        while (next != null) {
            if (next.compareTo(min) < 0) {
                min = next;
                minPrev = nextPrev;
            }
            nextPrev = next;
            next = next.sibling;
        }

        removeTreeRoot(min, minPrev);
        return min;
    }
    public void decreaseKey(Node node, int newKey) {
        if(newKey >=node.key) throw new IllegalArgumentException();

        node.key = newKey;
        moveUp(node, false);
    }

    public void delete(Node node) {
        node = moveUp(node, true);
        if (head == node) {
            removeTreeRoot(node, null);
        } else {
            Node prev = head;
            while (prev.sibling.compareTo(node) != 0) {
                prev = prev.sibling;
            }
            removeTreeRoot(node, prev);
        }
    }
    //moving node up
    private Node moveUp(Node node, boolean delete) {
        Node parent = node.parent;
        while (parent != null && (delete || node.compareTo(parent) < 0)) {
            int temp = node.key;
            node.key = parent.key;
            parent.key = temp;
            node = parent;
            parent = parent.parent;
        }
        return node;
    }
    private void removeTreeRoot(Node root, Node prev) {
        //remove root
        if (root == head) {
            head = root.sibling;
        } else {
            prev.sibling = root.sibling;
        }

        // children reverse
        Node  newHead = null;
        Node  child = root.child;
        while (child != null) {
            Node next = child.sibling;
            child.sibling = newHead;
            child.parent = null;
            newHead = child;
            child = next;
        }
        BinomialHeap newHeap = new BinomialHeap (newHead);

        // Union
        head = union(newHeap);
    }

    // Linking trees with same order
    private void linkTree(Node minNodeTree, Node  linked) {
        linked.parent = minNodeTree;
        linked.sibling = minNodeTree.child;
        minNodeTree.child = linked;
        minNodeTree.degree++;
    }

    // Union two binomial heaps into one and return the head
    private Node  union(BinomialHeap heap) {
        Node newHead = merge(this, heap);

        head = null;
        heap.head = null;

        if (newHead == null) {
            return null;
        }

        Node prev = null;
        Node curr = newHead;
        Node next = newHead.sibling;

        while (next != null) {
            //case 1 not same order, case 2 next next is also same order
            if (curr.degree != next.degree || (next.sibling != null &&
                    next.sibling.degree == curr.degree)) {
                prev = curr;
                curr = next;
            } else {
                // case 3 link next under curr
                if (curr.compareTo(next) < 0) {
                    curr.sibling = next.sibling;
                    linkTree(curr, next);
                } else {
                    //case 4 link curr under next
                    if (prev == null) {
                        newHead = next;
                    } else {
                        prev.sibling = next;
                    }

                    linkTree(next, curr);
                    curr = next;
                }
            }

            next = curr.sibling;
        }

        return newHead;
    }

    private static Node merge(BinomialHeap heap1, BinomialHeap heap2) {
        if (heap1.head == null) {
            return heap2.head;
        } else if (heap2.head == null) {
            return heap1.head;
        } else {
            Node head;
            Node  heap1Next = heap1.head;
            Node heap2Next = heap2.head;
            // choose the head
            if (heap1.head.degree <= heap2.head.degree) {
                head = heap1.head;
                heap1Next = heap1Next.sibling;
            } else {
                head = heap2.head;
                heap2Next = heap2Next.sibling;
            }

            Node tail = head;
            // merging
            while (heap1Next != null && heap2Next != null) {
                if (heap1Next.degree <= heap2Next.degree) {
                    tail.sibling = heap1Next;
                    heap1Next = heap1Next.sibling;
                } else {
                    tail.sibling = heap2Next;
                    heap2Next = heap2Next.sibling;
                }

                tail = tail.sibling;
            }
            //add the rest
            if (heap1Next != null) {
                tail.sibling = heap1Next;
            } else {
                tail.sibling = heap2Next;
            }

            return head;
        }
    }
    public void print() {
        System.out.println("Binomial heap:");
        if (head != null) {
            head.print(0);
        }
    }

}
