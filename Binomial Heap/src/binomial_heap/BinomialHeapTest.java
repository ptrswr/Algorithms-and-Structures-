package binomial_heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class BinomialHeapTest {

    BinomialHeap b;
    @BeforeEach
    void setUp() {
        b= new BinomialHeap();
        b.insert(12);
        b.insert(5);
        b.insert(3);
        b.insert(19);
        b.insert(6);
        b.insert(0);


    }

    @Test
    void minimum() {
       // b.print();
        assertEquals(0,b.minimum());
    }
    @Test
    void buildtest() {

        assertEquals(19,b.head.sibling.child.sibling.key);
    }

    @Test
    void extractMin() {
        int result = b.extractMin().key;
       // b.print();
        assertEquals(0,result);
    }

    @Test
    void decreaseKey() {
        b.decreaseKey( b.head.sibling.child,-7);
        assertEquals(-7,b.minimum());
    }

    @Test
    void decreaseKeyInvalid() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class,()->b.decreaseKey(b.head.sibling,100));
    }
    @Test
    void delete() {
        b.delete(b.head.sibling);
        //b.print();
        assertEquals(5, b.head.sibling.child.key);
    }
}