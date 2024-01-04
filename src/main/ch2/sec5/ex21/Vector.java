package ch2.sec5.ex21;

public class Vector {
    final int first;
    final int second;
    final int third;

    public Vector(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public int compareTo(Vector that) {
        if (this.first < that.first) return -1;
        if (this.first > that.first) return 1;
        if (this.second < that.second) return -1;
        if (this.second > that.second) return 1;
        return Integer.compare(this.third, that.third);
    }
}
