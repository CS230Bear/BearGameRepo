
package com.redthirddivision.firestorm.utils;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Test2 implements Runnable {

    @Override
    public void run() {
        System.err.println("Test 2 started");
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.err.println("Test 2 ended");
    }

}
