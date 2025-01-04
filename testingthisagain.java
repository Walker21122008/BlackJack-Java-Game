import java.awt.Color;
import java.awt.image.BufferedImage;
import arc.*;
import java.awt.Font;


public class testingthisagain {
    private static TextOutputFile scoreBoardList;
    private static BufferedImage imgBackButton;
    private static BufferedImage imgScoreBoard;
    private static TextInputFile scoreBoardListInput;
    private static String strUser; // Added missing variable

    public static void main(String[] args) {
        Console con = new Console("Valentina Moretti", 1280, 720);
        imgBackButton = con.loadImage("images/back_button.png");
        imgScoreBoard = con.loadImage("images/scoreBoard.png");
        Font fntFamous =con.loadFont("font.ttf",50);
        con.setTextFont(fntFamous);	
        showScoreBoard(con);
    }
    
    private static void showScoreBoard(Console con) {
        boolean bringScoreBoard = true;
        while (bringScoreBoard) {
            con.drawImage(imgScoreBoard, 0, 0); // Changed imgFinalBoard to imgScoreBoard
            con.repaint();
            scoreBoardListInput = new TextInputFile("scoreBoardList.txt");
            readScoresFromFileFinal(con);
            sortScores(con);
            displayScoresFinal(con);
            searchUserAndPrintRank(con);
            con.repaint();
            con.sleep(16);
        }
    }

    private static final int MAX_SCORES = 100;
    private static String[] names = new String[MAX_SCORES];
    private static double[] scores = new double[MAX_SCORES];
    private static int scoreCount = 0;

    private static void readScoresFromFileFinal(Console con) {
        scoreCount = 0;
        while (!scoreBoardListInput.eof() && scoreCount < MAX_SCORES) {
            names[scoreCount] = scoreBoardListInput.readLine();
            scores[scoreCount] = Double.parseDouble(scoreBoardListInput.readLine());
            scoreCount++;
        }
        scoreBoardListInput.close();
    }

    private static void sortScores(Console con) {
        for (int i = 0; i < scoreCount - 1; i++) {
            for (int j = 0; j < scoreCount - i - 1; j++) {
                if (scores[j] < scores[j + 1]) {
                    // Swap scores
                    double tempScore = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = tempScore;
                    // Swap names
                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;
                }
            }
        }
    }

    private static void displayScoresFinal(Console con) {
        for (int i = 0; i < Math.min(5, scoreCount); i++) {
            con.setDrawColor(Color.WHITE);
            con.drawString(names[i] + ": " + scores[i], 300, 180 + i * 80);
            con.repaint();
        }
        for (int i = 5; i < Math.min(10, scoreCount); i++) {
            con.setDrawColor(Color.WHITE);
            con.drawString(names[i] + ": " + scores[i], 790, 180 + (i - 5) * 80);
            con.repaint();
        }
    }

    private static void searchUserAndPrintRank(Console con) {
        // count the number of users
        int userCount = 0;
        scoreBoardListInput = new TextInputFile("scoreBoardList.txt");
        while (!scoreBoardListInput.eof()) {
            scoreBoardListInput.readLine(); // name
            scoreBoardListInput.readLine(); // money
            userCount++;
        }
        scoreBoardListInput.close();

        // Create array with exact size
        double[] allMoney = new double[userCount];

        // populate the array and find user's money
        double userMoney = -1;
        int index = 0;
        scoreBoardListInput = new TextInputFile("scoreBoardList.txt");
        while (!scoreBoardListInput.eof()) {
            String strName = scoreBoardListInput.readLine();
            String strMoney = scoreBoardListInput.readLine();
            allMoney[index] = Double.parseDouble(strMoney);
            if (strName.equalsIgnoreCase(strUser)) {
                userMoney = allMoney[index];
            }
            index++;
        }
        scoreBoardListInput.close();

        // Sort the money array in descending order
        bubbleSortDescending(allMoney);

        // Find the user's rank
        int rank = 1;
        for (int i = 0; i < allMoney.length; i++) {
            if (allMoney[i] == userMoney) {
                break;
            }
            rank++;
        }

        // Print the rank
        con.drawString(String.valueOf(rank), 500, 650);
    }

    private static void bubbleSortDescending(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    // Swap elements
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void showHighScores(Console con) {
        con.drawImage(imgScoreBoard, 0, 0);
        con.repaint();
        scoreBoardListInput = new TextInputFile("scoreBoardList.txt");
        readTopScoresFromFile();
        displayScores(con);
        con.drawImage(imgBackButton, 1080, 520);
        con.repaint();
    }

    private static final int TOP_SCORES_COUNT = 10;
    private static String[] topNames = new String[TOP_SCORES_COUNT];
    private static double[] topScores = new double[TOP_SCORES_COUNT];

    private static void readTopScoresFromFile() {
        for (int i = 0; i < TOP_SCORES_COUNT; i++) {
            topScores[i] = Double.MIN_VALUE;
        }
        
        while (!scoreBoardListInput.eof()) {
            String name = scoreBoardListInput.readLine();
            double score = Double.parseDouble(scoreBoardListInput.readLine());
            updateTopScores(name, score);
        }
        scoreBoardListInput.close();
    }

    private static void updateTopScores(String name, double score) {
        int insertIndex = -1;
        for (int i = 0; i < TOP_SCORES_COUNT; i++) {
            if (score > topScores[i]) {
                insertIndex = i;
                break;
            }
        }
        
        if (insertIndex != -1) {
            for (int i = TOP_SCORES_COUNT - 1; i > insertIndex; i--) {
                topScores[i] = topScores[i - 1];
                topNames[i] = topNames[i - 1];
            }
            topScores[insertIndex] = score;
            topNames[insertIndex] = name;
        }
    }

    private static void displayScores(Console con) {
        for (int i = 0; i < TOP_SCORES_COUNT; i++) {
            if (topScores[i] != Double.MIN_VALUE) {
                con.setDrawColor(Color.WHITE);
                if (i < 5) {
                    con.drawString(topNames[i] + ": " + topScores[i], 200, 180 + i * 90);
                } else {
                    con.drawString(topNames[i] + ": " + topScores[i], 760, 180 + (i - 5) * 90);
                }
                con.repaint();
            }
        }
    }
}
