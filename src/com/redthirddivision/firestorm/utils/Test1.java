
package com.redthirddivision.firestorm.utils;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Test1 implements Runnable {

    @Override
    public void run() {
        System.out.println("Test 1 started");
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Test 1 ended");
    }

}
