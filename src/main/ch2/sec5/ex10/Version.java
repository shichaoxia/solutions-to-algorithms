package ch2.sec5.ex10;

public class Version implements Comparable<Version> {
    private final int major;
    private final int minor;
    private final int patch;

    public Version(int major, int minor, int patch) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
    }

    public int compareTo(Version that) {
        if (this.major < that.major) return -1;
        if (this.major > that.major) return 1;
        if (this.minor < that.minor) return -1;
        if (this.minor > that.minor) return 1;
        return Integer.compare(this.patch, that.patch);
    }
}
