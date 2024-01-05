package game;

import cs2.Shape;
import cs2.Window;
import cs2.Button;
import java.awt.*;
import bag.SimpleBagInterface;
import student.TestableRandom;
import cs2.*;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who do.
//-- Stephen Ye (stepheny)

/**
* Created and sets rules for the window that the WhackAShape game will take place
* 
* 
* @author Stephen Ye (stepheny)
* @version 2022.10.04
*/
public class WhackAShape {

    private SimpleBagInterface<Shape> bag;
    private Window window;
    private Button quitButton;
    private Shape currentShape;
    private TestableRandom randomGenerator = new TestableRandom();

    /**
     * makes the WhackAShape object when there are no paramaters
     */
    public WhackAShape() {
        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        quitButton = new Button("Quit");
        quitButton.onClick(this, "quit");
        window.setTitle("First Window");
        window.addButton(quitButton, WindowSide.EAST);
        window.setSize(500, 700);

        String[] shapeCombos = { "red circle", "blue square ", 
             "red square", "blue circle"};
        int size = randomGenerator.nextInt(9) + 6;
        for (int i = 0; i < size; i++) {
            bag.add(this.buildShape(shapeCombos[randomGenerator.nextInt(4)]));
        }
        window.addShape(bag.pick());


    }

    /**
     * makes the WhackAShape object when there is a paramater
     * @param args a specified array of strings
     */
    public WhackAShape(String[] args) {
        this.randomGenerator = new TestableRandom();
        bag = new SimpleLinkedBag<Shape>();
        window = new Window();
        window.setTitle("First Window");
        quitButton = new Button("Quit");
        quitButton.onClick(this, "quit");
        window.addButton(quitButton, WindowSide.EAST);

        for (int i = 0; i < 18; i++) {
            currentShape = null;
            try {
                currentShape = this.buildShape(args[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
            bag.add(currentShape);
        }
        window.addShape(bag.pick());
        
    }

    /**
     * finds the bag and returns it
     * @return SimpleBagInterface<Shape> the bag of shapes
     */
    public SimpleBagInterface<Shape> getBag() {
        return bag;
    }

    /**
     * finds the window and returns it
     * @return Window the window that the game will take place
     */
    public Window getWindow() {
        return window;
    }

    /**
     * Created the button that will close the window
     * @param button the button that will make the window close
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }

    /**
     * Created the button of the shape what will be clicked during the game
     * @param shape the shape that will be clicked in the window
     */
    public void clickedShape(Shape shape)
    {
        window.removeShape(shape);
        bag.remove(shape);
        Shape nextShape = bag.pick();
        if (nextShape != null)
        {
            TextShape text = new TextShape(window.getGraphPanelWidth()/2,
            window.getGraphPanelHeight()/2 , "You Win!");

        }
        else
        {
            window.addShape(nextShape);
        }
        


    }
    
    /**
     * created the shape and determines the shape and color 
     * @param input the string that will determine that shape and
     *  color of the shape button
     * @return the shape that will be made into a button
     */
    private Shape buildShape(String input)
    {

        int extra = randomGenerator.nextInt(101);
        int size = 100 + extra;

        int locX = randomGenerator.nextInt(window.getGraphPanelWidth() +
         1 - size);
        int locY = randomGenerator.nextInt(window.getGraphPanelHeight() +
         1 - size);

        if (input.contains("red"))
        {
            if (input.contains("circle"))
        {
            CircleShape currentShape = new CircleShape(locX, locY, size, Color.RED);
            currentShape.onClick(this, "clickedShape");
            return currentShape;

        }
        else if (input.contains("square"))
        {
            SquareShape currentShape = new SquareShape(locX, locY, size, Color.RED);
            currentShape.onClick(this, "clickedShape");
            return currentShape;
        }
        else
        {
            throw new IllegalArgumentException("Invalid shape");
        }
        }
        else if (input.contains("blue"))
        {
            if (input.contains("circle"))
        {
            CircleShape currentShape = new CircleShape(locX, locY, size, Color.BLUE);
            currentShape.onClick(this, "clickedShape");
            return currentShape;
        }
        else if (input.contains("square"))
        {
            SquareShape currentShape = new SquareShape(locX, locY, size, Color.BLUE);
            currentShape.onClick(this, "clickedShape");
            return currentShape;
            
        }
        else
        {
            throw new IllegalArgumentException("Invalid shape");
        }
        }
        else
        {
            throw new IllegalArgumentException("Invalid color");

        }

        


    }


}
