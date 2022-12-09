package chapter1.section3.exercise3;

import chapter1.section3.Stack;

public class Exercise3 {
    // 4 3 2 1 0 9 8 7 6 5
    public static String a() {
        Stack<Integer> s = new Stack<>();
        String str = new String();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        str += s.pop();
        str += s.pop();
        str += s.pop();
        str += s.pop();
        str += s.pop();
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(9);
        str += s.pop();
        str += s.pop();
        str += s.pop();
        str += s.pop();
        str += s.pop();
        return str;
    }

    // 4 6 8 7 5 3 2 9 0 1
    public static String b() {
        Stack<Integer> s = new Stack<>();
        String str = new String();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        str += s.pop();
        s.push(5);
        s.push(6);
        str += s.pop();
        s.push(7);
        s.push(8);
        str += s.pop();
        str += s.pop();
        str += s.pop();
        str += s.pop();
        str += s.pop();
        s.push(9);
        str += s.pop();
        str += s.pop();
        str += s.pop();
        return str;
    }

    // 2 5 6 7 4 8 9 3 1 0
    public static String c() {
        Stack<Integer> s = new Stack<>();
        String str = new String();
        s.push(0);
        s.push(1);
        s.push(2);
        str += s.pop();
        s.push(3);
        s.push(4);
        s.push(5);
        str += s.pop();
        s.push(6);
        str += s.pop();
        s.push(7);
        str += s.pop();
        str += s.pop();
        s.push(8);
        str += s.pop();
        s.push(9);
        str += s.pop();
        str += s.pop();
        str += s.pop();
        return str;
    }

    // 4 3 2 1 0 5 6 7 8 9
    public static String d() {
        Stack<Integer> s = new Stack<>();
        String str = new String();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        str += s.pop();
        str += s.pop();
        str += s.pop();
        str += s.pop();
        str += s.pop();
        s.push(5);
        str += s.pop();
        s.push(6);
        str += s.pop();
        s.push(7);
        str += s.pop();
        s.push(8);
        str += s.pop();
        s.push(9);
        str += s.pop();
        return str;
    }

    // 1 2 3 4 5 6 9 8 7 0
    public static String e() {
        Stack<Integer> s = new Stack<>();
        String str = new String();
        s.push(0);
        s.push(1);
        str += s.pop();
        s.push(2);
        str += s.pop();
        s.push(3);
        str += s.pop();
        s.push(4);
        str += s.pop();
        s.push(5);
        str += s.pop();
        s.push(6);
        str += s.pop();
        s.push(7);
        s.push(8);
        s.push(9);
        str += s.pop();
        str += s.pop();
        str += s.pop();
        str += s.pop();
        return str;
    }

    // 0 4 6 5 3 8 1 7 2 9
    public static String f() {
        Stack<Integer> s = new Stack<>();
        String str = new String();
        s.push(0);
        str += s.pop();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        str += s.pop();
        s.push(5);
        s.push(6);
        str += s.pop();
        str += s.pop();
        str += s.pop();
        s.push(7);
        s.push(8);
        str += s.pop();
        str += s.pop();
        str += s.pop();
        str += s.pop();
        s.push(9);
        str += s.pop();
        return str;
    }

    // 1 4 7 9 8 6 5 3 0 2
    public static String g() {
        Stack<Integer> s = new Stack<>();
        String str = new String();
        s.push(0);
        s.push(1);
        str += s.pop();
        s.push(2);
        s.push(3);
        s.push(4);
        str += s.pop();
        s.push(5);
        s.push(6);
        s.push(7);
        str += s.pop();
        s.push(8);
        s.push(9);
        str += s.pop();
        str += s.pop();
        str += s.pop();
        str += s.pop();
        str += s.pop();
        str += s.pop();
        str += s.pop();
        return str;
    }

    // 2 1 4 3 6 5 8 7 9 0
    public static String h() {
        Stack<Integer> s = new Stack<>();
        String str = new String();
        s.push(0);
        s.push(1);
        s.push(2);
        str += s.pop();
        str += s.pop();
        s.push(3);
        s.push(4);
        str += s.pop();
        str += s.pop();
        s.push(5);
        s.push(6);
        str += s.pop();
        str += s.pop();
        s.push(7);
        s.push(8);
        str += s.pop();
        str += s.pop();
        s.push(9);
        str += s.pop();
        str += s.pop();
        return str;
    }
}
