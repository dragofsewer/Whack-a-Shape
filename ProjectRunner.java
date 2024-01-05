package game;

import cs2.Shape;
import cs2.Window;
import cs2.Button;
import java.awt.*;
import bag.SimpleBagInterface;
import student.TestableRandom;
import cs2.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Stephen Ye (stepheny)

/**
 * The class that runs the game
 * 
 * 
 * @author Stephen Ye (stepheny)
 * @version 2022.10.04
 */
public class ProjectRunner {

    /**
     * Makes the WhackAShape object which creates the game
     * 
     * @param args
     *            the strings that will control the rules of the game
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            WhackAShape shape = new WhackAShape(args);
        }
        else {
            WhackAShape shape = new WhackAShape();

        }

    }

}
