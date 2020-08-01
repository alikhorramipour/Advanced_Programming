/*** In The Name of Allah ***/
package game.bufferstrategy;

import game.Loot.*;
import game.MapComponents.*;
import game.Object;
import game.Tank.BFTank;
import game.Tank.MiniTank;
import game.Tank.Tank;
import game.Tank.Weapon.Bullet.Cannon;
import game.Tank.Weapon.Bullet.TurretBullet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

import static game.Tank.PlayerTank.PLAYER_TANK;
import static game.Tank.Weapon.PlayerTankTurret.PLAYER_TANK_TURRET;


/**
 * The window on which the rendering is performed.
 * This structure uses the modern BufferStrategy approach for
 * double-buffering; actually, it performs triple-buffering!
 * For more information on BufferStrategy check out:
 * http://docs.oracle.com/javase/tutorial/extra/fullscreen/bufferstrategy.html
 * http://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferStrategy.html
 *
 * @author Seyed Mohammad Ghaffarian
 */
public class GameFrame extends JFrame{

    public static final int GAME_HEIGHT = 700;                  // 720p game resolution
    public static final int GAME_WIDTH = 1200;  // wide aspect ratio


    private ArrayList<Dirt> dirts = new ArrayList<>();
    private ArrayList<Plant> plants = new ArrayList<>();
    public static ArrayList<Wall> walls = new ArrayList<>();
    public static ArrayList<Stone> stones = new ArrayList<>();
    private ArrayList<Pipe> pipes = new ArrayList<>();
    private ArrayList<Loot> loots = new ArrayList<>();
    private ArrayList<MiniTank> miniTanks = new ArrayList<>();
    private ArrayList<BFTank> bfTanks = new ArrayList<>();
    private static ArrayList<Object> objects = new ArrayList<>();

    private ArrayList<String> map = new ArrayList();

    private BufferStrategy bufferStrategy;

    private long lastRender;
    private ArrayList<Float> fpsHistory;

    private BufferedImage playerTankImg, playerTankTurretImg, playerTankCannonImg, dirtImg, plantImg,
            wallImg, stoneImg, pipeImg, gameStart, gameOver;

    private boolean isInitialized = false;
    private boolean startScreenShown = false;

    public GameFrame(String title) {
        super(title);
        setResizable(false);
        setSize(GAME_WIDTH, GAME_HEIGHT);
        //
        // Initialize the JFrame ...
        //
        lastRender = -1;
        fpsHistory = new ArrayList<>(100);

        try {
            dirtImg = ImageIO.read(new File("src/Resources/Images/Soil.png"));
            plantImg = ImageIO.read(new File("src/Resources/Images/plant.png"));
            wallImg = ImageIO.read(new File("src/Resources/Images/softWall.png"));
            stoneImg = ImageIO.read(new File("src/Resources/Images/stone.png"));
            pipeImg = ImageIO.read(new File("src/Resources/Images/teazel.png"));
            gameStart = ImageIO.read(new File("src/Resources/Images/Startup2.png"));
            gameOver = ImageIO.read(new File("src/Resources/Images/gameOver.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This must be called once after the JFrame is shown:
     * frame.setVisible(true);
     * and before any rendering is started.
     */
    public void initBufferStrategy() {
        // Triple-buffering
        createBufferStrategy(3);
        bufferStrategy = getBufferStrategy();
    }


    /**
     * Game rendering with triple-buffering using BufferStrategy.
     */
    public void render(GameState state) {
        // Render single frame
        do {
            // The following loop ensures that the contents of the drawing buffer
            // are consistent in case the underlying surface was recreated
            do {
                // Get a new graphics context every time through the loop
                // to make sure the strategy is validated
                Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
                try {
                    doRendering(graphics, state);
                } finally {
                    // Dispose the graphics
                    graphics.dispose();
                }
                // Repeat the rendering if the drawing buffer contents were restored
            } while (bufferStrategy.contentsRestored());

            // Display the buffer
            bufferStrategy.show();
            // Tell the system to do the drawing NOW;
            // otherwise it can take a few extra ms and will feel jerky!
            Toolkit.getDefaultToolkit().sync();

            // Repeat the rendering if the drawing buffer was lost
        } while (bufferStrategy.contentsLost());
    }

    /**
     * Rendering all game elements based on the game state.
     */
    private void doRendering(Graphics2D g2d, GameState state) {
        // Initialize Map
        if (!isInitialized) {
            this.initializeMap();
            isInitialized = true;
        }
        /*if(!startScreenShown){
            g2d.drawImage(gameStart, 0, 0, null);
            startScreenShown = true;
        }*/
        this.drawMap(g2d, state);
//        if (state.locY >= 600) {
//            g2d.drawImage(playerTankImg, state.locX, 100, null);
//            if (PLAYER_TANK.isWhichGun())
//                g2d.drawImage(playerTankTurretImg, state.locX + 19, 100 + 17, null);
//            else
//                g2d.drawImage(playerTankCannonImg, state.locX + 19, 100 + 17, null);
//        } else {
//            g2d.drawImage(playerTankImg, state.locX, 100, null);
//            if (PLAYER_TANK.isWhichGun())
//                g2d.drawImage(playerTankTurretImg, state.locX + 19, 100 + 17, null);
//            else
//                g2d.drawImage(playerTankCannonImg, state.locX + 19, 100 + 17, null);
//        }
        drawLoot(g2d, state);
        PLAYER_TANK.printTank(g2d, state, getMousePosition().x, getMousePosition().y);
        drawPipes(g2d, state);
        drawBFTanks(g2d, state);
        drawMiniTanks(g2d, state);
        PLAYER_TANK.drawFeatures(g2d, state);
        /*if(state.shoot){
            if(PLAYER_TANK.shootWeapon())
            {
                if(PLAYER_TANK.isTurret()){
                    TurretBullet turretBullet = new TurretBullet(PLAYER_TANK.getLocationX(), 115);
                    turretBullet.fireBullet(PLAYER_TANK, objects, g2d, state);
                }
                else{
                    Cannon cannon = new Cannon(PLAYER_TANK.getLocationX(), 115);
                    cannon.fireBullet(PLAYER_TANK, objects, g2d, state);
                }
            }
        }*/

        /*if (state.locY == 300)
            state.locY = 0;*/
        /*// Print FPS info
        long currentRender = System.currentTimeMillis();
        if (lastRender > 0) {
            fpsHistory.add(1000.0f / (currentRender - lastRender));
            if (fpsHistory.size() > 100) {
                fpsHistory.remove(0); // remove oldest
            }
            float avg = 0.0f;
            for (float fps : fpsHistory) {
                avg += fps;
            }
            avg /= fpsHistory.size();
            String str = String.format("Average FPS = %.1f , Last Interval = %d ms",
                    avg, (currentRender - lastRender));
            g2d.setColor(Color.RED);
            g2d.setFont(g2d.getFont().deriveFont(18.0f));
            int strWidth = g2d.getFontMetrics().stringWidth(str);
            int strHeight = g2d.getFontMetrics().getHeight();
            g2d.drawString(str, (GAME_WIDTH - strWidth) / 2, strHeight + 50);
        }
        lastRender = currentRender;
        // Print user guide
        String userGuide
                = "Use the MOUSE or ARROW KEYS to move the BALL. "
                + "Press ESCAPE to end the game.";
        g2d.setFont(g2d.getFont().deriveFont(18.0f));
        g2d.drawString(userGuide, 10, GAME_HEIGHT - 10);

        */

        // Draw GAME OVER
        if (state.gameOver) {
            /*String str = "GAME OVER";
            g2d.setColor(Color.WHITE);
            g2d.setFont(g2d.getFont().deriveFont(Font.BOLD).deriveFont(64.0f));
            int strWidth = g2d.getFontMetrics().stringWidth(str);
            g2d.drawString(str, (GAME_WIDTH - strWidth) / 2, GAME_HEIGHT / 2);*/
            //g2d.setBackground(Color.BLACK);
            g2d.drawImage(gameOver, 0, 0, null);
        }
    }

    public void initializeMap() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/Resources/map.txt"));
            String line;
            int j = 0;
            Random random = new Random();
            while ((line = bufferedReader.readLine()) != null) {
                map.add(line);
                for (int i = 0; i < 12; i++) {
                    switch (line.charAt(i)) {
                        case 'd': { // Dirt
                            dirts.add(new Dirt(i * 100, j * 100));
                            objects.add(new Dirt(i * 100, j * 100));
                            break;
                        }

                        case 'p': { // Plant
                            plants.add(new Plant(i * 100, j * 100));
                            objects.add(new Plant(i * 100, j * 100));
                            break;
                        }

                        case 'w': { // Wall
                            walls.add(new Wall(i * 100, j * 100));
                            objects.add(new Wall(i * 100, j * 100));
                            break;
                        }

                        case 's': { // Stone
                            stones.add(new Stone(i * 100, j * 100));
                            objects.add(new Stone(i * 100, j * 100));
                            break;
                        }

                        case '@': { // Pipe
                            pipes.add(new Pipe(i * 100, j * 100));
                            objects.add(new Pipe(i * 100, j * 100));
                            break;
                        }

                        case 'z': { // Loot -> HealthPack
                            loots.add(new HealthPack(i * 100, j * 100));
                            objects.add(new HealthPack(i * 100, j * 100));
                            break;
                        }

                        case 'x': { // Loot -> CannonAmmo
                            loots.add(new CannonAmmo(i * 100, j * 100));
                            objects.add(new CannonAmmo(i * 100, j * 100));
                            break;
                        }

                        case 'c': { // Loot -> TurretAmmo
                            loots.add(new TurretAmmo(i * 100, j * 100));
                            objects.add(new TurretAmmo(i * 100, j * 100));
                            break;
                        }

                        case 'v': { // Loot -> UpgradeWeapon
                            loots.add(new UpgradeWeapon(i * 100, j * 100));
                            objects.add(new UpgradeWeapon(i * 100, j * 100));
                            break;
                        }

                        case '1': { // MiniTank, Animated
                            miniTanks.add(new MiniTank(i * 100, j * 100, "easy", true));
                            objects.add(new MiniTank(i * 100, j * 100, "easy", true));
                            miniTanks.get(miniTanks.size() - 1).setLootable(random.nextBoolean());
                            break;
                        }

                        case '2': { // BFTank, Animated
                            bfTanks.add(new BFTank(i * 100, j * 100, "easy", true));
                            objects.add(new BFTank(i * 100, j * 100, "easy", true));
                            bfTanks.get(miniTanks.size() - 1).setLootable(random.nextBoolean());
                            break;
                        }

                        case '3': { // MiniTank, Stationary
                            miniTanks.add(new MiniTank(i * 100, j * 100, "easy", false));
                            objects.add(new MiniTank(i * 100, j * 100, "easy", false));
                            miniTanks.get(miniTanks.size() - 1).setLootable(random.nextBoolean());
                            break;
                        }

                        case '4': { // // BFTank, Stationary
                            bfTanks.add(new BFTank(i * 100, j * 100, "easy", false));
                            objects.add(new BFTank(i * 100, j * 100, "easy", false));
                            bfTanks.get(miniTanks.size() - 1).setLootable(random.nextBoolean());
                            break;
                        }
                    }
                }
                j++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawMap(Graphics2D g2d, GameState state) {

        for (Stone s1 : stones) {
            if ((s1.getLocationY() > state.locY - 350) || (s1.getLocationY() < state.locY + 350))
                g2d.drawImage(stoneImg, s1.getLocationX(), s1.getLocationY() - (state.locY - 100), null);
        }

        for (Dirt d1 : dirts) {
            if ((d1.getLocationY() > state.locY - 350) || (d1.getLocationY() < state.locY + 350))
                g2d.drawImage(dirtImg, d1.getLocationX(), d1.getLocationY() - (state.locY - 100), null);
        }

        // drawing the soil underneath the teasels
        for (Pipe pi1 : pipes) {
            if ((pi1.getLocationY() > state.locY - 350) || (pi1.getLocationY() < state.locY + 350)) {
                g2d.drawImage(dirtImg, pi1.getLocationX(), pi1.getLocationY() - (state.locY - 100), null);
            }
        }

        for(MiniTank mt1 : miniTanks){
            if((mt1.getLocationY() > state.locY - 350) || (mt1.getLocationY() < state.locY + 350)){
                g2d.drawImage(dirtImg, mt1.getLocationX(), mt1.getLocationY()  - (state.locY - 100), null);
            }
        }

        for(BFTank bf1 : bfTanks){
            if((bf1.getLocationY() > state.locY - 350) || (bf1.getLocationY() < state.locY + 350)){
                g2d.drawImage(dirtImg, bf1.getLocationX(), bf1.getLocationY()  - (state.locY - 100), null);
            }
        }

        // drawing the soil underneath the loots
        for (Object l1 : loots) {
            if ((l1.getLocationY() > state.locY - 350) || (l1.getLocationY() < state.locY + 350)) {
                g2d.drawImage(dirtImg, l1.getLocationX(), l1.getLocationY() - (state.locY - 100), null);
            }
        }

        for (Wall w1 : walls) {
            if ((w1.getLocationY() > state.locY - 350) || (w1.getLocationY() < state.locY + 350))
                g2d.drawImage(wallImg, w1.getLocationX(), w1.getLocationY() - (state.locY - 100), null);
        }

        for (Plant p1 : plants) {
            if ((p1.getLocationY() > state.locY - 350) || (p1.getLocationY() < state.locY + 350))
                g2d.drawImage(plantImg, p1.getLocationX(), p1.getLocationY() - (state.locY - 100), null);
        }


    }

    public void drawPipes(Graphics2D g2d, GameState state) {
        for (Pipe pi1 : pipes) {
            if ((pi1.getLocationY() > state.locY - 350) || (pi1.getLocationY() < state.locY + 350)) {
                g2d.drawImage(pipeImg, pi1.getLocationX(), pi1.getLocationY() - (state.locY - 100), null);
            }
        }
    }

    public void drawLoot(Graphics2D g2d, GameState state) {
        for (Loot l1 : loots) {
            if (((l1.getLocationY() > state.locY - 350) || (l1.getLocationY() < state.locY + 350)) && !(l1.isUsed())) {
                if(!l1.isUsed())
                    g2d.drawImage(l1.getPicture(), l1.getLocationX(), l1.getLocationY() - (state.locY - 100), null);
                else
                    g2d.drawImage(dirtImg, l1.getLocationX(), l1.getLocationY() - (state.locY - 100), null);
            }
        }
    }

    public void drawBFTanks(Graphics2D g2d, GameState state) {
        for (BFTank bf1 : bfTanks) {
            if ((bf1.getLocationY() > state.locY - 350) || (bf1.getLocationY() < state.locY + 350)) {
                g2d.drawImage(bf1.getPicture(), bf1.getLocationX(), bf1.getLocationY() - (state.locY - 100), null);
                g2d.drawImage(bf1.bftankWeapon.getPicture(), bf1.getLocationX() + 10, bf1.getLocationY() - (state.locY - 100) + 10, null);
            }
        }
    }

    public void drawMiniTanks(Graphics2D g2d, GameState state) {
        for (MiniTank mt1 : miniTanks) {
            if ((mt1.getLocationY() > state.locY - 350) || (mt1.getLocationY() < state.locY + 350)) {
                g2d.drawImage(mt1.getPicture(), mt1.getLocationX(), mt1.getLocationY() - (state.locY - 100), null);
                g2d.drawImage(mt1.miniTankWeapon.getPicture(), mt1.getLocationX() + 15, mt1.getLocationY() - (state.locY - 100) + 25, null);
            }
        }
    }

    public static ArrayList<Object> getObjects() {
        return objects;
    }

    public static ArrayList<Stone> getStones() {
        return stones;
    }

    public static ArrayList<Wall> getWalls() {
        return walls;
    }

}
