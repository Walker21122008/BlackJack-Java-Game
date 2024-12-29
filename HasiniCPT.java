import arc.*;
import java.util.Scanner;
import java.awt.Color;
import arc.Console;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class HasiniCPT {
	private static int cardIndex = 0;
	private static double intMoney;
    private static List<BufferedImage> playerCards = new ArrayList<>();
    private static List<BufferedImage> dealerCards = new ArrayList<>();
    private static List<String> playerCardValues = new ArrayList<>();
    private static List<String> dealerCardValues = new ArrayList<>();
    private static final int CARD_WIDTH = 100;
    private static final int CARD_SPACING = 20;
    private static BufferedImage board;
    private static BufferedImage cardBack;
    private static int playerTotal = 0;
    private static int dealerTotal = 0;
    private static boolean playerTurn = true;
    private static boolean gameEnded = false;
    private static BufferedImage imgWinNico;
    private static BufferedImage imgWinVal;
    private static BufferedImage imgLose;
    private static BufferedImage imgWin;
    private static BufferedImage imgTie;
    private static BufferedImage imgTie1;
    private static BufferedImage val16;
    private static BufferedImage imgValPlayAgain;
    private static boolean canDoubleDown = false;
    private static boolean playAgain = false;   
    private static BufferedImage imgMoneyBoard; 
    private static double intValue;
    private static BufferedImage imgScoreBoard;
    private static String strUser;
    private static TextOutputFile scoreBoardList;
    private static TextInputFile scoreBoardListInput;
    private static ArrayList<String> names;
    private static ArrayList<Double> scores;
    private static BufferedImage imgBackButton;
    private static BufferedImage imgFinalBoard;
    private static BufferedImage imgMoneyWithBet;
    private static BufferedImage imgHelpButton;
    private static BufferedImage imgHelp1;
    private static BufferedImage imgHelp2;
    private static BufferedImage imgHelp3;
    private static BufferedImage imgHelp4;
    private static BufferedImage imgHelp5;
    private static BufferedImage imgHelp6;
    private static BufferedImage imgHelp7;
    private static BufferedImage imgHelp8;
    private static BufferedImage imgHelp9;
    private static BufferedImage imgHelp10;
    private static BufferedImage imgHelp11;
    private static BufferedImage imgHelp12;
    private static BufferedImage imgHelp13;
    private static BufferedImage imgHelp14;
    private static BufferedImage imgHelp15;
    
    public static void main(String[] args) {
        Console con = new Console("Valentina Moretti", 1280, 720);
        Color darkGray = Color.decode("#262927");
        BufferedImage main1 = con.loadImage("main1.png");
        imgHelpButton = con.loadImage("helpButton.png");
        BufferedImage main2 = con.loadImage("main2.png");
        BufferedImage play = con.loadImage("play.png");
        BufferedImage quit = con.loadImage("quit.png");
        imgTie = con.loadImage("imgTie.png");
        imgTie1 = con.loadImage("imgTie1.png");
        imgHelp1 = con.loadImage("helpFromCreator/help1.png");
        imgHelp2 = con.loadImage("helpFromCreator/help2.png");
        imgHelp3 = con.loadImage("helpFromCreator/help3.png");
        imgHelp4 = con.loadImage("helpFromCreator/help4.png");
        imgHelp5 = con.loadImage("helpFromCreator/help5.png");
        imgHelp6 = con.loadImage("helpFromCreator/help6.png");
        imgHelp7 = con.loadImage("helpFromCreator/help7.png");
        imgHelp8 = con.loadImage("helpFromCreator/help8.png");
        imgHelp9 = con.loadImage("helpFromCreator/help9.png");
        imgHelp10 = con.loadImage("helpFromCreator/help10.png");
        imgHelp11 = con.loadImage("helpFromCreator/help11.png");
        imgHelp12 = con.loadImage("helpFromCreator/help12.png");
        imgHelp13 = con.loadImage("helpFromCreator/help13.png");
        imgHelp14 = con.loadImage("helpFromCreator/help14.png");
        imgHelp15 = con.loadImage("helpFromCreator/help15.png");
        BufferedImage high = con.loadImage("high.png");
        BufferedImage moneyBonus = con.loadImage("bonusmoney.png");
        imgMoneyBoard = con.loadImage("moneyCount.png");
        imgScoreBoard = con.loadImage("scoreBoard.png");
        imgBackButton = con.loadImage("back_button.png");
        imgFinalBoard = con.loadImage("finalBoard.png");
        imgMoneyWithBet = con.loadImage("moneyWithBet.png");
        int intCountMainPage = 0;
        scoreBoardList = new TextOutputFile("scoreBoardList.txt", true);

        // Main animation loop
        while (intCountMainPage < 7) {
            con.drawImage(main1, 0, 0);
            con.repaint();
            con.sleep(500);
            con.drawImage(main2, 0, 0);
            con.repaint();
            con.sleep(500);
            intCountMainPage++;
        }

        // Button animations
        animateButton(con, main2, play, 200);
        animateButton(con, main2, play, high, 370);
        animateButton(con, main2, play, high, quit, 540);

        // Main game loop
        boolean running = true;
        while (running) {
            con.drawImage(main2, 0, 0);
            con.drawImage(play, 500, 200);
            con.drawImage(high, 500, 370);
            con.drawImage(quit, 500, 540);
            con.drawImage(imgHelpButton, 1170, 610);
            con.repaint();

            // If Play button is clicked
            if (isButtonClicked(con, 500, 200, 400, 150)) {
				BufferedImage miniStoryBoard = con.loadImage("miniStoryBoard.png");
				BufferedImage val_pix = con.loadImage("pix_val.png");
				BufferedImage nico_pix = con.loadImage("pix_nico.png");
				BufferedImage nico_pix_1 = con.loadImage("pix_nico_1.png");
				BufferedImage val0 = con.loadImage("page0.png");
				BufferedImage val1 = con.loadImage("page1.png");
				BufferedImage val2 = con.loadImage("page2.png");
				BufferedImage val3 = con.loadImage("page3.png");
				BufferedImage val4 = con.loadImage("page4.png");
				BufferedImage val5 = con.loadImage("page5.png");
				BufferedImage val6 = con.loadImage("page6.png");
				BufferedImage nico7 = con.loadImage("page7.png");
				BufferedImage nico8 = con.loadImage("page8.png");
				BufferedImage nico9 = con.loadImage("page9.png");
				BufferedImage nico10 = con.loadImage("page10.png");
				BufferedImage nico11 = con.loadImage("page11.png");
				BufferedImage val12 = con.loadImage("page12.png");
				BufferedImage nico13 = con.loadImage("page13.png");
				BufferedImage nico14 = con.loadImage("page14.png");
				BufferedImage nico15 = con.loadImage("page15.png");
				val16 = con.loadImage("page16.png");
				BufferedImage instructionboard = con.loadImage("instructionsboard.png");
				//add this for the input
				BufferedImage statitan = con.loadImage("statitan.png");
				BufferedImage normalUser = con.loadImage("normal_user.png"); 
				
				con.clear(); // Clear the console before each iteration
				con.drawImage(normalUser, 0, 0); // Redraw the image
				con.repaint();
				con.setTextColor(darkGray);
				strUser = con.readLine();
				
				//Cheatcode - statitan gets $2000.  Other users gets only $1000
				if(strUser.equalsIgnoreCase("statitan")) {
							con.drawImage(statitan, 0, 0);
							con.repaint();
							intMoney = 2000;
							con.sleep(2000);
							
				}else{
					con.drawImage(normalUser, 0, 0);
					intMoney = 1000;
					con.drawString(strUser, 600, 400);
					con.sleep(2000);
				}
				con.drawImage(instructionboard, 0, 0);
				
				int x = 200;
				int y = 250;
				int speed = 5;
				int topBoundary = 150;
				int bottomBoundary = 600 - val_pix.getHeight();
				int leftBoundary = 0;
				int rightBoundary = 600 - val_pix.getWidth();
				con.drawImage(nico_pix, 580, 250);
				con.drawImage(val_pix, x, y);
				con.repaint();
				con.sleep(5000);
				
				while (x != rightBoundary) {
					con.clear();
					con.drawImage(miniStoryBoard, 0, 0);
					con.drawImage(imgMoneyBoard, 0, 0);
					con.drawString("$" + String.valueOf(intMoney), 1080, 50);
					con.drawImage(nico_pix, 580, 250);
					con.drawImage(val_pix, x, y);
					con.repaint();

					int key = con.getKey();
					if (key == 38 && y > topBoundary) 
					{
						y -= speed;
					} else if (key == 40 && y < bottomBoundary) 
					{
						y += speed;
					}else if (key == 37 && x > leftBoundary) 
					{
						x -= speed;
					}else if (key == 39 && x < rightBoundary) 
					{
						x += speed;
					}

					con.sleep(16);
				}
        
				con.sleep(1000);
				con.drawImage(val0, 0, 0);
				con.drawImage(imgMoneyBoard, 0, 0);
				con.drawString("$" + String.valueOf(intMoney), 1080, 50);
				con.repaint();
				con.sleep(2000);
				con.drawImage(val1, 0, 0);
				con.drawImage(imgMoneyBoard, 0, 0);
				con.drawString("$" + String.valueOf(intMoney), 1080, 50);
				con.repaint();
				con.sleep(2000);
				con.drawImage(val2, 0, 0);
				con.drawImage(imgMoneyBoard, 0, 0);
				con.drawString("$" + String.valueOf(intMoney), 1080, 50);
				con.repaint();
				con.sleep(2000);
				con.drawImage(val3, 0, 0);
				con.drawImage(imgMoneyBoard, 0, 0);
				con.drawString("$" + String.valueOf(intMoney), 1080, 50);
				con.repaint();
				con.sleep(2000);
				con.drawImage(nico7, 0, 0);
				con.drawImage(imgMoneyBoard, 0, 0);
				con.drawString("$" + String.valueOf(intMoney), 1080, 50);
				con.repaint();
				con.sleep(2000);
				con.drawImage(nico8, 0, 0);
				con.drawImage(imgMoneyBoard, 0, 0);
				con.drawString("$" + String.valueOf(intMoney), 1080, 50);
				con.repaint();
				con.sleep(2000);
				con.drawImage(nico9, 0, 0);
				con.drawImage(imgMoneyBoard, 0, 0);
				con.drawString("$" + String.valueOf(intMoney), 1080, 50);
				con.repaint();
				con.sleep(2000);
				con.drawImage(nico10, 0, 0);
				con.drawImage(imgMoneyBoard, 0, 0);
				con.drawString("$" + String.valueOf(intMoney), 1080, 50);
				con.repaint();
				con.sleep(2000);
				con.drawImage(nico11, 0, 0);
				con.drawImage(imgMoneyBoard, 0, 0);
				con.drawString("$" + String.valueOf(intMoney), 1080, 50);
				con.repaint();
				con.sleep(2000);
				con.drawImage(val4, 0, 0);
				con.drawImage(imgMoneyBoard, 0, 0);
				con.drawString("$" + String.valueOf(intMoney), 1080, 50);
				con.repaint();
				con.sleep(2000);
				con.drawImage(val5, 0, 0);
				con.drawImage(imgMoneyBoard, 0, 0);
				con.drawString("$" + String.valueOf(intMoney), 1080, 50);
				con.repaint();
				con.sleep(2000);
				con.drawImage(val6, 0, 0);
				con.drawImage(imgMoneyBoard, 0, 0);
				con.drawString("$" + String.valueOf(intMoney), 1080, 50);
				con.repaint();
				con.sleep(2000);
        
			boolean buttonClicked = false;
			while (!buttonClicked) {
				con.setDrawColor(Color.RED);
				con.fillRect(490, 600, 200, 50);
				con.setDrawColor(Color.BLACK);
				con.drawRect(490, 600, 200, 50);
				con.drawString("Sure Lets play!", 510, 610);
				con.repaint();
				con.setDrawColor(Color.RED);
				con.fillRect(800, 600, 200, 50);
				con.setDrawColor(Color.BLACK);
				con.drawRect(800, 600, 200, 50);
				con.drawString("Maybe not", 810, 610);
				con.repaint();

				// Lets Play button clicked
				if (isButtonClicked(con, 490, 600, 200, 50)) {
						con.setDrawColor(Color.WHITE);
						buttonClicked = true;
						con.drawImage(miniStoryBoard, 0, 0);
						con.drawImage(imgMoneyBoard, 0, 0);
					    con.drawString("$" + String.valueOf(intMoney), 1080, 50);
						con.drawImage(val_pix, x, y);
						con.drawImage(nico_pix_1, 580, 250);
						con.repaint();
						int nico_x = 580;
						int nico_y = 250;
						while (nico_x < 800) {
							nico_x += speed; // Move the button to the middle animation
							con.drawImage(miniStoryBoard, 0, 0);
							con.drawImage(imgMoneyBoard, 0, 0);
					        con.drawString("$" + String.valueOf(intMoney), 1080, 50);
							con.drawImage(val_pix, x, 200);
							con.drawImage(nico_pix_1, nico_x, 250);
							con.repaint();
							con.sleep(16); // Approximately 60 FPS
						}
							
						while(nico_y > 0){
							nico_y -= speed;
							con.drawImage(miniStoryBoard, 0, 0);
							con.drawImage(imgMoneyBoard, 0, 0);
					        con.drawString("$" + String.valueOf(intMoney), 1080, 50);
							con.drawImage(val_pix, x, y);
							con.drawImage(nico_pix_1, nico_x, nico_y);
							con.repaint();
							con.sleep(16);
						}     
						con.drawImage(nico_pix, nico_x, nico_y);
						con.repaint(); 
						while (x < 900) {
							x += speed; // Move the button to the middle animation
							con.drawImage(miniStoryBoard, 0, 0);
							con.drawImage(imgMoneyBoard, 0, 0);
					        con.drawString("$" + String.valueOf(intMoney), 1080, 50);
							con.drawImage(val_pix, x, y);
							con.drawImage(nico_pix, nico_x, nico_y);
							con.repaint();
							con.sleep(16); // Approximately 60 FPS
						}
							
						while(y > 0){
							y -= speed;
							con.drawImage(miniStoryBoard, 0, 0);
							con.drawImage(imgMoneyBoard, 0, 0);
							con.drawString("$" + String.valueOf(intMoney), 1080, 50);
							con.drawImage(val_pix, x, y);
							con.drawImage(nico_pix, nico_x, nico_y);
							con.repaint();
							con.sleep(16);
						}     
						con.sleep(1000);
						if(intMoney == 1000){
							con.drawImage(val12, 0, 0);
							con.drawImage(imgMoneyBoard, 0, 0);
					        con.drawString("$" + String.valueOf(intMoney), 1080, 50);
							con.repaint();
							con.sleep(2000);
						}else{
							con.drawImage(moneyBonus, 0, 0);
							con.drawImage(imgMoneyBoard, 0, 0);
					        con.drawString("$" + String.valueOf(intMoney), 1080, 50);
							con.repaint();
							con.sleep(2000);
						}
						con.drawImage(nico13, 0, 0);
						con.drawImage(imgMoneyBoard, 0, 0);
					    con.drawString("$" + String.valueOf(intMoney), 1080, 50);
						con.repaint();
						con.sleep(2000);
						con.drawImage(nico14, 0, 0);
						con.drawImage(imgMoneyBoard, 0, 0);
					    con.drawString("$" + String.valueOf(intMoney), 1080, 50);
						con.repaint();
						con.sleep(2000);
						con.drawImage(nico15, 0, 0);
						con.drawImage(imgMoneyBoard, 0, 0);
					    con.drawString("$" + String.valueOf(intMoney), 1080, 50);
						con.repaint();
						con.sleep(2000);
						con.drawImage(val16, 0, 0);
						con.drawImage(imgMoneyBoard, 0, 0);
					    con.drawString("$" + String.valueOf(intMoney), 1080, 50);
						con.repaint();
						con.sleep(2000);
						
						
						//Game starts here
						
						con.clear(); // Clear the console before each iteration
						con.drawImage(val16, 0, 0); // Redraw the image
						con.drawImage(imgMoneyBoard, 0, 0);
						con.drawString("$" + String.valueOf(intMoney), 1080, 50);
						con.setTextColor(darkGray);
						
						do {
							con.setTextColor(darkGray);
							String input = con.readLine();
							try {
								intValue = Integer.parseInt(input);
							
								if (intValue > intMoney) {
									con.drawImage(val16, 0, 0); // Redraw the image
									con.drawImage(imgMoneyBoard, 0, 0);
									con.drawString("$" + String.valueOf(intMoney), 1080, 50);
									con.setTextColor(Color.WHITE);
									con.drawString("Value must be less than or equal to " + intMoney + ". Try again.", 550, 650);
									con.repaint();
									con.sleep(2000);
									con.drawImage(val16, 0, 0); // Redraw the image
									con.drawImage(imgMoneyBoard, 0, 0);
									con.drawString("$" + String.valueOf(intMoney), 1080, 50);
									con.repaint();
								}
							} catch (NumberFormatException e) {
								con.drawImage(val16, 0, 0); // Redraw the image
									con.drawImage(imgMoneyBoard, 0, 0);
									con.drawString("$" + String.valueOf(intMoney), 1080, 50);
								intValue = 9999;
								con.setTextColor(Color.WHITE);
								con.drawString("Invalid input. Please enter a number.", 550, 650);
								con.repaint();
								con.sleep(2000);
									con.drawImage(val16, 0, 0); // Redraw the image
									con.drawImage(imgMoneyBoard, 0, 0);
									con.drawString("$" + String.valueOf(intMoney), 1080, 50);
									con.repaint();
							}
						} while (intValue > intMoney);

						
						con.clear(); // Clear the console one last time
						con.drawImage(val16, 0, 0); // Redraw the image
						con.setTextColor(Color.WHITE);
						con.drawString("$" + intValue, 700, 650);
						con.repaint();
						con.sleep(1000);
						board = con.loadImage("../board.png");
						cardBack = con.loadImage("card_back.png");
						imgWinVal = con.loadImage("val_win.png");
						imgWinNico = con.loadImage("nico_win.png");
						imgLose = con.loadImage("lose.png");
						imgWin = con.loadImage("win.png");
						imgValPlayAgain = con.loadImage("page6.png");

						playAgain = true;
						resetGameState ();
						while (playAgain) {
							playAgain = playGame(con);
							if (playAgain) {
								resetGameState();
							}
						}
						con.closeConsole();
				} else if (isButtonClicked(con, 800, 600, 200, 50)) {
					con.println("Goodbye");
					//System.exit(0); // Exit the program if "Maybe not" is clicked
				}
			
			con.sleep(16); // Short sleep to prevent excessive CPU usage
		}  // while !button clicked
		
        } // end of if play button clicked
        
        // Code for High Score Button
        else if (isButtonClicked(con, 500, 370, 400, 150)) {
			boolean bringScoreBoard = true;
			while (bringScoreBoard) {
				con.drawImage(imgScoreBoard, 0, 0);
				con.repaint();
				scoreBoardListInput = new TextInputFile("scoreBoardList.txt");
				names = new ArrayList<>();
				scores = new ArrayList<>();
				readScoresFromFile();
				sortScores();
				displayScores(con);
				con.drawImage(imgBackButton, 1080, 520);
				con.repaint();

				if (isButtonClicked(con, 1080, 520, 200, 200)) {
					bringScoreBoard = false;
					break; // Exit the while loop
				}

				con.sleep(16); // Add a small delay to prevent excessive CPU usage
			}
			// The code will continue to the main game loop after exiting the while loop
		}else if(isButtonClicked(con, 1170, 610, 110, 110)){//help button code
			con.println("hello");
		}
        else if (isButtonClicked(con, 500, 540, 400, 150)) {
                    con.println("Quit button clicked");
                    running = false; // Exit the game loop
        }

        con.sleep(16); // Approximately 60 FPS
        }  // main while running = true
    }
	private static void readScoresFromFile() {
        while (!scoreBoardListInput.eof()) {
            names.add(scoreBoardListInput.readLine());
            scores.add(Double.parseDouble(scoreBoardListInput.readLine()));
        }
        scoreBoardListInput.close();
    }

    private static void sortScores() {
        for (int i = 0; i < scores.size() - 1; i++) {
            for (int j = 0; j < scores.size() - i - 1; j++) {
                if (scores.get(j) < scores.get(j + 1)) {
                    // Swap scores
                    double tempScore = scores.get(j);
                    scores.set(j, scores.get(j + 1));
                    scores.set(j + 1, tempScore);
                    // Swap names
                    String tempName = names.get(j);
                    names.set(j, names.get(j + 1));
                    names.set(j + 1, tempName);
                }
            }
        }
    }

    private static void displayScores(Console con) {
        for (int i = 0; i < Math.min(5, scores.size()); i++) {
			con.setDrawColor(Color.WHITE);
            con.drawString(names.get(i) + ": " + scores.get(i), 200, 180 + i * 90);
            con.repaint();
        }
        for (int i = 5; i < Math.min(10, scores.size()); i++) {
			con.setDrawColor(Color.WHITE);
            con.drawString(names.get(i) + ": " + scores.get(i), 750, 180 + (i - 5) * 90);
            con.repaint();
        }
    }
    private static void animateButton(Console con, BufferedImage background, BufferedImage button, int y) {
        int x = 1280;
        while (x > 500) {
            x -= 10;
            con.drawImage(background, 0, 0);
            con.drawImage(button, x, y);
            con.repaint();
            con.sleep(16);
        }
    }

    private static void animateButton(Console con, BufferedImage background, BufferedImage button1, BufferedImage button2, int y) {
        int x = 1280;
        while (x > 500) {
            x -= 10;
            con.drawImage(background, 0, 0);
            con.drawImage(button1, 500, 200);
            con.drawImage(button2, x, y);
            con.repaint();
            con.sleep(16);
        }
    }

    private static void animateButton(Console con, BufferedImage background, BufferedImage button1, BufferedImage button2, BufferedImage button3, int y) {
        int x = 1280;
        while (x > 500) {
            x -= 10;
            con.drawImage(background, 0, 0);
            con.drawImage(button1, 500, 200);
            con.drawImage(button2, 500, 370);
            con.drawImage(button3, x, y);
            con.repaint();
            con.sleep(16);
        }
    }

    private static boolean isButtonClicked(Console con, int x, int y, int width, int height) {
        int mouseX = con.currentMouseX();
        int mouseY = con.currentMouseY();
        return con.currentMouseButton() == 1 && mouseX >= x && mouseX <= (x + width) && mouseY >= y && mouseY <= (y + height);
    }
    private static boolean playGame(Console con) {
        String[][] deck = new String[52][4];
        String[] suits = {"D", "C", "H", "S"};
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        initializeDeck(deck, suits, values);
        shuffleDeck(deck);
        dealInitialCards(con, deck);
        drawScene(con);

        if (playerTotal == 21) {
            determineWinner(con);
        }

        while (!gameEnded) {
            if (playerTurn) {
                if (isHitButtonClicked(con) && playerTotal < 21) {
                    hitCard(con, deck);
                    if (playerTotal >= 21) {
                        playerTurn = false;
                        determineWinner(con);
                    }
                } else if (isStandButtonClicked(con)) {
                    playerTurn = false;
                    dealerTurn(con, deck);
                } else if (canDoubleDown && isDoubleDownButtonClicked(con)) {
                    doubleDown(con, deck);
                    playerTurn = false;
                    dealerTurn(con, deck);
                }
            }
            drawScene(con);
            con.sleep(10);
        }

        return askPlayAgain(con);
    }

    private static void initializeDeck(String[][] deck, String[] suits, String[] values) {
        int index = 0;
        for (String suit : suits) {
            for (String value : values) {
                deck[index][0] = value;
                deck[index][1] = suit;
                deck[index][2] = String.valueOf(getCardValue(value));
                deck[index][3] = value + "-" + suit + ".png";
                index++;
            }
        }
    }


    private static int getCardValue(String value) {
        switch (value) {
            case "A":
                return 11;
            case "K":
            case "Q":
            case "J":
                return 10;
            default:
                return Integer.parseInt(value);
        }
    }

    private static void shuffleDeck(String[][] deck) {
        for (int i = deck.length - 1; i > 0; i--) {
            int j = (int)(Math.random() * (i + 1));
            String[] temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    private static void dealInitialCards(Console con, String[][] deck) {
        for (int i = 0; i < 2; i++) {
            playerCards.add(loadCardImage(con, deck[cardIndex][3]));
            playerCardValues.add(deck[cardIndex][0]);
            playerTotal = reCalculateTotal(playerCardValues); 
            cardIndex++;

            dealerCards.add(loadCardImage(con, deck[cardIndex][3]));
            dealerCardValues.add(deck[cardIndex][0]);
            dealerTotal = reCalculateTotal(dealerCardValues); 
            cardIndex++;
        }
        canDoubleDown = (playerTotal == 9 || playerTotal == 10 || playerTotal == 11);
    }

    private static void hitCard(Console con, String[][] deck) {
        BufferedImage newCard = loadCardImage(con, deck[cardIndex][3]);
        playerCards.add(newCard);
        playerCardValues.add(deck[cardIndex][0]);
        playerTotal = reCalculateTotal(playerCardValues);
        cardIndex++;
        animateCardShuffle(con);
    }

    private static int reCalculateTotal(List<String> cardValues) {
        int total = 0;
        int aceCount = 0;
        for (String cardValue : cardValues) {
            int value = getCardValue(cardValue);
            if (value == 11) {
                aceCount++;
            } else {
                total += value;
            }
        }
        for (int i = 0; i < aceCount; i++) {
            if (total < 10) {
                total += 11;
            } else if (total == 10 && aceCount == 1) {
				total += 11;
			} else {
                total += 1;
            }
        }
        return total;
    }

    private static void dealerTurn(Console con, String[][] deck) {
        drawScene(con);
        while (dealerTotal < 17 || dealerTotal < playerTotal) {
            BufferedImage newCard = loadCardImage(con, deck[cardIndex][3]);
            dealerCards.add(newCard);
            dealerCardValues.add(deck[cardIndex][0]);
            dealerTotal = reCalculateTotal(dealerCardValues);
            cardIndex++;
            drawScene(con);
            con.sleep(1000);
        }
        determineWinner(con);
    }

    private static void determineWinner(Console con) {
        if (playerTotal == dealerTotal && playerTotal <= 21) {
            intMoney = intMoney;
            con.sleep(2000);
            con.drawImage(imgTie, 0, 0);
            con.repaint();
            con.sleep(2000);
            con.drawImage(imgTie1, 0, 0);
        } else if (playerTotal > 21 || (dealerTotal <= 21 && playerTotal < dealerTotal)) {
            con.sleep(2000);
            intMoney = intMoney - intValue;
            con.drawImage(imgWinNico, 0, 0);
            con.repaint();
            con.sleep(2000);
            con.drawImage(imgLose, 0, 0);
        } else if (playerTotal == 21 || dealerTotal > 21 || playerTotal > dealerTotal) {
            con.sleep(2000);
            intMoney = intMoney + intValue;
            con.drawImage(imgWinVal, 0, 0);
            con.repaint();
            con.sleep(2000);
            con.drawImage(imgWin, 0, 0);
        }
        con.repaint();
        con.sleep(2000);
        gameEnded = true;
        drawScene(con);
    }

    private static void animateCardShuffle(Console con) {
        int totalWidth = (playerCards.size() - 1) * (CARD_WIDTH + CARD_SPACING);
        int startX = 640 - totalWidth / 2;
        for (int step = 0; step < CARD_SPACING; step++) {
            drawScene(con);
            for (int i = 0; i < playerCards.size() - 1; i++) {
                con.drawImage(playerCards.get(i), startX + i * (CARD_WIDTH + CARD_SPACING) - step, 450);
            }
            con.drawImage(playerCards.get(playerCards.size() - 1), 1180, 450);
            con.repaint();
            con.sleep(16);
        }
        drawScene(con);
    }

    private static void drawScene(Console con) {
        con.drawImage(board, 0, 0);
        con.drawImage(imgMoneyWithBet, 0, 0);
		con.drawString("$" + String.valueOf(intMoney), 1080, 50);
		con.drawString("$" + String.valueOf(intValue), 1100, 256);
        displayDealerCards(con);
        displayPlayerCards(con);
        if (playerTurn && playerTotal < 21) {
            drawHitButton(con);
            drawStandButton(con);
            if (canDoubleDown) {
                drawDoubleDownButton(con);
            }
        }
        displayTotals(con);
        con.repaint();
    }

    private static void displayPlayerCards(Console con) {
        int totalWidth = (playerCards.size() - 1) * (CARD_WIDTH + CARD_SPACING);
        int startX = 640 - totalWidth / 2;
        for (int i = 0; i < playerCards.size(); i++) {
            con.drawImage(playerCards.get(i), startX + i * (CARD_WIDTH + CARD_SPACING), 450);
        }
    }

    private static void displayDealerCards(Console con) {
        con.drawImage(dealerCards.get(0), 500, 0);
        if (playerTurn) {
            con.drawImage(cardBack, 600, 0);
        } else {
            for (int i = 1; i < dealerCards.size(); i++) {
                con.drawImage(dealerCards.get(i), 500 + i * (CARD_WIDTH + CARD_SPACING), 0);
            }
        }
    }

    private static BufferedImage loadCardImage(Console con, String imagePath) {
        return con.loadImage(imagePath);
    }

    private static void drawHitButton(Console con) {
        con.setDrawColor(Color.RED);
        con.fillRect(900, 600, 100, 50);
        con.setDrawColor(Color.BLACK);
        con.drawRect(900, 600, 100, 50);
        con.drawString("HIT", 935, 610);
    }

    private static void drawStandButton(Console con) {
        con.setDrawColor(Color.GREEN);
        con.fillRect(1020, 600, 100, 50);
        con.setDrawColor(Color.BLACK);
        con.drawRect(1020, 600, 100, 50);
        con.drawString("STAND", 1045, 610);
    }

    private static void drawDoubleDownButton(Console con) {
        con.setDrawColor(Color.BLUE);
        con.fillRect(1140, 600, 100, 50);
        con.setDrawColor(Color.BLACK);
        con.drawRect(1140, 600, 100, 50);
        con.drawString("DOUBLE", 1160, 610);
    }

    private static boolean isHitButtonClicked(Console con) {
        return con.currentMouseButton() == 1 && con.currentMouseX() >= 900 && con.currentMouseX() <= 1000 && con.currentMouseY() >= 600 && con.currentMouseY() <= 650;
    }

    private static boolean isStandButtonClicked(Console con) {
        return con.currentMouseButton() == 1 && con.currentMouseX() >= 1020 && con.currentMouseX() <= 1120 && con.currentMouseY() >= 600 && con.currentMouseY() <= 650;
    }

    private static boolean isDoubleDownButtonClicked(Console con) {
        return con.currentMouseButton() == 1 && con.currentMouseX() >= 1140 && con.currentMouseX() <= 1240 && con.currentMouseY() >= 600 && con.currentMouseY() <= 650;
    }

    private static void doubleDown(Console con, String[][] deck) {
        hitCard(con, deck);
        if (playerTotal > 21) {
            determineWinner(con);
        }
    }

    private static void displayTotals(Console con) {
        con.setDrawColor(Color.WHITE);
        con.drawString("Player Total: " + playerTotal, 10, 700);
        if (!playerTurn || gameEnded) {
            con.drawString("Dealer Total: " + dealerTotal, 10, 680);
        }
    }

    private static boolean askPlayAgain(Console con) {
        con.clear();
        con.drawImage(imgValPlayAgain, 0, 0); //not showing up
		con.repaint();
        
			
        con.setDrawColor(Color.RED);
        con.fillRect(490, 600, 200, 50);
        con.setDrawColor(Color.BLACK);
        con.drawRect(490, 600, 200, 50);
        con.drawString("Sure Let's play!", 500, 610);

        con.setDrawColor(Color.RED);
        con.fillRect(800, 600, 200, 50);
        con.setDrawColor(Color.BLACK);
        con.drawRect(800, 600, 200, 50);
        con.drawString("Maybe not", 810, 610);

        con.repaint();
        while (true) {
            if (isButtonClicked(con, 490, 600, 200, 50)) {
                resetGameState();
                con.drawImage(val16, 0, 0); // Redraw the image
									con.drawImage(imgMoneyBoard, 0, 0);
									con.drawString("$" + String.valueOf(intMoney), 1080, 50);
									con.setTextColor(Color.WHITE);
									con.repaint();
									Color darkGray = Color.decode("#262927");
									
                do {
							con.setTextColor(darkGray);
							String input = con.readLine();
							try {
								intValue = Integer.parseInt(input);
							
								if (intValue > intMoney) {
									con.drawImage(val16, 0, 0); // Redraw the image
									con.drawImage(imgMoneyBoard, 0, 0);
									con.drawString("$" + String.valueOf(intMoney), 1080, 50);
									con.setTextColor(Color.WHITE);
									con.drawString("Value must be less than or equal to " + intMoney + ". Try again.", 550, 650);
									con.repaint();
									con.sleep(2000);
									con.drawImage(val16, 0, 0); // Redraw the image
									con.drawImage(imgMoneyBoard, 0, 0);
									con.drawString("$" + String.valueOf(intMoney), 1080, 50);
									con.repaint();
								}
							} catch (NumberFormatException e) {
								con.drawImage(val16, 0, 0); // Redraw the image
									con.drawImage(imgMoneyBoard, 0, 0);
									con.drawString("$" + String.valueOf(intMoney), 1080, 50);
								intValue = 9999;
								con.setTextColor(Color.WHITE);
								con.drawString("Invalid input. Please enter a number.", 550, 650);
								con.repaint();
								con.sleep(2000);
									con.drawImage(val16, 0, 0); // Redraw the image
									con.drawImage(imgMoneyBoard, 0, 0);
									con.drawString("$" + String.valueOf(intMoney), 1080, 50);
									con.repaint();
							}
						} while (intValue > intMoney);
                return true;
            } else if (isButtonClicked(con, 800, 600, 200, 50)) {
				scoreBoardList.println(strUser);
				scoreBoardList.println(intMoney);
                System.out.println("Hasi Goodbye"); //debug statement
                boolean bringScoreBoard = true;
				while (bringScoreBoard) {
					con.drawImage(imgFinalBoard, 0, 0);
					con.repaint();
					scoreBoardListInput = new TextInputFile("scoreBoardList.txt");
					names = new ArrayList<>();
					scores = new ArrayList<>();
					readScoresFromFile();
					sortScores();
					displayScoresFinal(con);
					searchUserAndPrintRank(con);
					con.repaint();

					con.sleep(16); // Add a small delay to prevent excessive CPU usage
				}
                
            }
        }
    }
    
    private static void displayScoresFinal(Console con) {
        for (int i = 0; i < Math.min(5, scores.size()); i++) {
			con.setDrawColor(Color.WHITE);
            con.drawString(names.get(i) + ": " + scores.get(i), 300, 180 + i * 80);
            con.repaint();
        }
        for (int i = 5; i < Math.min(10, scores.size()); i++) {
			con.setDrawColor(Color.WHITE);
            con.drawString(names.get(i) + ": " + scores.get(i), 790, 180 + (i - 5) * 80);
            con.repaint();
        }
    }
	
	private static void searchUserAndPrintRank(Console con) {
		// First pass: count the number of users
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

		// Second pass: populate the array and find user's money
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

		// Bubble sort the money array in descending order
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
	private static void helpButton(Console con){
		con.drawImage(imgHelp1, 0, 0);
		con.repaint();
	}
	// Bubble sort method for descending order
	private static void bubbleSortDescending(double[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					// Swap elements
					double temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}


    private static void resetGameState() {
        cardIndex = 0;
        playerCards.clear();
        dealerCards.clear();
        playerCardValues.clear();
        dealerCardValues.clear();
        playerTotal = 0;
        dealerTotal = 0;
        playerTurn = true;
        gameEnded = false;
        canDoubleDown = false;
    }
}
