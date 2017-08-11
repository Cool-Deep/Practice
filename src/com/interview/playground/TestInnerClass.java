package com.interview.playground;

import java.util.Random;

/**
 * Created by tushar_v_roy on 5/18/16.
 */
class TestInnerClass {

    // --Commented out by Inspection (8/10/17, 5:13 PM):int t = 20;
    private Random random;
    private Okay test() {
        final int r = 10;
        return
                 random::nextInt;

    }

    private void test1() {
        random = new Random();
        Okay o1 = test();
        System.out.print(o1.next());
        Okay o2 = test();
        random = null;
        System.out.print(o2.next());
    }

    public static void main(String args[]) {
        TestInnerClass testInnerClass = new TestInnerClass();
        testInnerClass.test1();
    }
}

interface Okay {
    int next();
}
