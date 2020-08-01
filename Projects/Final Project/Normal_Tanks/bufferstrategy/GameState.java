/*** In The Name of Allah ***/
package game.bufferstrategy;

import game.Loot.Loot;
import game.Object;

import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import static game.Tank.PlayerTank.PLAYER_TANK;

/**
 * This class holds the state of the game and all of its elements.
 * This class also handles user inputs, which affect the game state.
 *
 * @author Seyed Mohammad Ghaffarian
 */
public class GameState implements Serializable {

    private KeyHandler keyHandler;
    private MouseHandler mouseHandler;

    public int locX = 100, locY = 100, diam, locXTmp, locYTmp;
    public boolean gameOver;

    public boolean keyUP, keyDOWN, keyRIGHT, keyLEFT;
    public boolean mousePress;
    public boolean shoot;
    public int mouseX, mouseY;

    public GameState() {
        //
        // Initialize the game state and all elements ...
        //
        keyHandler = new KeyHandler();
        mouseHandler = new MouseHandler();
        locX = 100;
        locY = 100;
        diam = 32;
        gameOver = false;
        //
        keyUP = false;
        keyDOWN = false;
        keyRIGHT = false;
        keyLEFT = false;
        //
        mousePress = false;
        mouseX = 0;
        mouseY = 0;
        //
    }

    /**
     * The method which updates the game state.
     */
    public void update() {
        //
        // Update the state of all game elements
        //  based on user input and elapsed time ...
        //

        locXTmp = locX;
        locYTmp = locY;

        //if (mousePress) {
            //locY = mouseY - diam / 2;
            //locX = mouseX - diam / 2;
        //}
        if (keyUP) {
            locY -= 8;
            PLAYER_TANK.setLocationY(PLAYER_TANK.getLocationY() - 8);
        }
        if (keyDOWN) {
            locY += 8;
            PLAYER_TANK.setLocationY(PLAYER_TANK.getLocationY() + 8);
        }
        if (keyLEFT) {
            locX -= 8;
            PLAYER_TANK.setLocationX(PLAYER_TANK.getLocationX() - 8);
        }
        if (keyRIGHT) {
            locX += 8;
            PLAYER_TANK.setLocationX(PLAYER_TANK.getLocationX() + 8);
        }

        reverseCollision(GameFrame.getObjects());

        //locX = Math.max(locX, 0);
        //locX = Math.min(locX, GameFrame.GAME_WIDTH - diam);
        //locY = Math.max(locY, 0);
        //locY = Math.min(locY, GameFrame.GAME_HEIGHT - diam);
        //if (locY >= 9300)
        //locY = 8999;
    }

    public void saveState() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("GameState.bin")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reverseCollision(ArrayList<Object> objects) {
        for (Object obj1 : objects) {
            if (obj1.checkCollision(PLAYER_TANK.getBounds())) {
                if (!obj1.isPassable()) {
                    PLAYER_TANK.setLocationX(locXTmp);
                    PLAYER_TANK.setLocationY(locYTmp);
                    locX = locXTmp;
                    locY = locYTmp;
                }
                else if(obj1 instanceof Loot){
                    ((Loot) obj1).setUsed();
                }
            }
        }
    }



    /*public void resumeState(){
        try (FileInputStream fileInputStream = new FileInputStream("GameState.bin")){
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            this = (game.template.bufferstrategy.GameState)objectInputStream.readObject();
            // = (GameState) objectInputStream.readObject();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }*/

    public KeyListener getKeyListener() {
        return keyHandler;
    }

    public MouseListener getMouseListener() {
        return mouseHandler;
    }

    public MouseMotionListener getMouseMotionListener() {
        return mouseHandler;
    }


    /**
     * The keyboard handler.
     */
    class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    keyUP = true;
                    break;
                case KeyEvent.VK_DOWN:
                    keyDOWN = true;
                    break;
                case KeyEvent.VK_LEFT:
                    keyLEFT = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    keyRIGHT = true;
                    break;
                case KeyEvent.VK_ESCAPE:
                    gameOver = true;
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    keyUP = false;
                    break;
                case KeyEvent.VK_DOWN:
                    keyDOWN = false;
                    break;
                case KeyEvent.VK_LEFT:
                    keyLEFT = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    keyRIGHT = false;
                    break;
            }
        }

    }

    /**
     * The mouse handler.
     */
    class MouseHandler extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1) {
                mouseX = e.getX();
                mouseY = e.getY();
                System.out.println("left click pressed");
                shoot = true;
                mousePress = true;
            }else{
                PLAYER_TANK.changeWeapon();
                System.out.println("right click pressed");
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mousePress = false;
            shoot = false;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();
        }
    }

}

