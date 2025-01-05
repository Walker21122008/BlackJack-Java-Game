import java.awt.Color;
import arc.*;
import java.awt.image.BufferedImage;

public class testingthisagain {
    private static boolean showGreenScreen = false;
    private static BufferedImage imgYellow;
    private static BufferedImage imgRed;
    private static BufferedImage imgYellowSlap;
    private static BufferedImage imgDeadRed;
    private static BufferedImage imgJokePage1;
    private static BufferedImage imgJokePage2;
    private static BufferedImage imgJokePage3;
    private static BufferedImage imgJokePage4;
    private static BufferedImage imgSpace;
    private static int intYellowX = 0; // Starting X position for yellow.png

    public static void main(String[] args) {
        Console con = new Console("Valentina Moretti", 1280, 720);
        imgYellow = con.loadImage("yellow.png");
        imgRed = con.loadImage("red.png");
        imgYellowSlap = con.loadImage("yellowSlap.png");
        imgDeadRed = con.loadImage("deadRed.png");
        imgJokePage1 = con.loadImage("jokePage1.png");
        imgJokePage2 = con.loadImage("jokePage2.png");
        imgJokePage3 = con.loadImage("jokePage3.png");
        imgJokePage4 = con.loadImage("jokePage4.png");
        imgSpace = con.loadImage("space.png");
        
        while (true) {
            con.clear();
            
            if (!showGreenScreen) {
                drawStartScreen(con);
            } else {
                runAnimation(con);
            }
            
            con.repaint();
            con.sleep(16); // Approximately 60 FPS
        }
    }
    
    private static void drawStartScreen(Console con) {
        con.setDrawColor(Color.RED);
        con.fillRect(1240, 0, 40, 40);
        
        if (isButtonClicked(con, 1240, 0, 40, 40)) {
            showGreenScreen = true;
            intYellowX = 0; // Reset yellow position when animation starts
        }
    }
    
    private static void runAnimation(Console con) {
        con.drawImage(imgSpace, 0, 0);
        con.drawImage(imgYellow, intYellowX, 250);
        con.drawImage(imgRed, 700, 250);
        
        // Move yellow.png to the right
        intYellowX += 5; 
        
        // Check if yellow has reached red
        if (intYellowX >= 550) {
            playEndSequence(con);
            showGreenScreen = false;
            intYellowX = 0; // Reset for next time
            con.clear(); // Clear the screen before returning to start
        }
    }
    
    private static void playEndSequence(Console con) {
        con.sleep(1000);
        con.drawImage(imgJokePage1, 0, 0);
        con.repaint();
        con.sleep(2000);
        con.drawImage(imgJokePage2, 0, 0);
        con.repaint();
        con.sleep(2000);
        con.drawImage(imgJokePage3, 0, 0);
        con.repaint();
        con.sleep(2000);
        con.drawImage(imgJokePage4, 0, 0);
        con.repaint();
        con.sleep(2000);
        con.drawImage(imgSpace, 0, 0);
        con.drawImage(imgYellowSlap, intYellowX, 250);
        con.drawImage(imgRed, 700, 250);
        con.repaint();
        con.sleep(2000);
        con.drawImage(imgSpace, 0, 0);
        con.drawImage(imgYellow, intYellowX, 250);
        con.drawImage(imgDeadRed, 700, 250);
        con.repaint();
        con.sleep(2000);
    }
    
    private static boolean isButtonClicked(Console con, int x, int y, int width, int height) {
        int mouseX = con.currentMouseX();
        int mouseY = con.currentMouseY();
        return con.currentMouseButton() == 1 && mouseX >= x && mouseX <= (x + width) && mouseY >= y && mouseY <= (y + height);
    }
}
