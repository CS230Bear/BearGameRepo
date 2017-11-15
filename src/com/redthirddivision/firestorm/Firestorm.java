
package com.redthirddivision.firestorm;

import javax.swing.JFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.redthirddivision.firestorm.audio.MusicPlayer;
import com.redthirddivision.firestorm.rendering.ui.SplashScreenDriver;
import com.redthirddivision.firestorm.utils.ThreadPool;
import com.redthirddivision.firestorm.utils.Util;


public class Firestorm {
    
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(2);
        System.out.println("Running on OS: " + Util.getOSName());
        new SplashScreenDriver();
        final Game game = new Game();
        JFrame frame = new JFrame(Game.TITLE);
        frame.add(game);
        frame.setSize(Game.WIDTH, Game.HEIGHT);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.err.println("Exiting Game");
                game.stop();
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        MusicPlayer player = new MusicPlayer("Eden-0209");
        pool.runTask(player);
        pool.runTask(game);
        pool.join();
    }

}
