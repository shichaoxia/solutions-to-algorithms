package ch1.sec5.ex25;

public interface UF {

    
    int count();

    boolean connected(int p, int q);

    
    int find(int p);

    void union(int p, int q);
}
