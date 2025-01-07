import java.awt.Color;
import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class testingthisagain {

    public static void main(String[] args) {
        // Create a console window
        Console con = new Console("Font Demo", 1280, 720);
        Font fntFont=con.loadFont("font.ttf",50);
        
        // Define some fonts
        Font font1 = new Font("Arial", Font.PLAIN, 24);
        Font font2 = new Font("Times New Roman", Font.BOLD, 36);
        Font font3 = new Font("Courier New", Font.ITALIC, 48);
		
		
        // Draw text with different fonts
        con.setTextFont(fntFont);
        con.setTextColor(Color.WHITE);
        con.readLine();
        con.drawString("Hello, this is Arial!", 100, 100);



        // Display the console
        con.repaint();
    }

}

}
