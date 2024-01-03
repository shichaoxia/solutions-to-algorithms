package chapter2.section4.exercise10;


public class Move {
    // tag::snippet[]
    
    public int parent(int k) {
        return (k - 1) / 2;
    }

    
    public int leftChild(int k) {
        return 2 * k + 1;
    }

    
    public int rightChild(int k) {
        return 2 * k + 2;
    }
    // end::snippet[]
}
