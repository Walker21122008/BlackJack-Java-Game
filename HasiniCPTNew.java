/*
 * 
 * Name: BlackJack 
 * File Name: HasiniCPT.java
 * By: Hasini Vijay Inbasri
 * Date Created: Dec 21, 2024
 * Purpose: Fan-made game for the Webtoon comic - The Mafia Nanny focusing on Blackjack
 * 
 */
 
 //import libraries
import arc.*;
import java.util.Scanner;
import java.awt.Color;
import arc.Console;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class HasiniCPTNew {
	//Initializing global variables for the images, variables and lists
	private static BufferedImage imgLoad;
    private static final int BAR_WIDTH = 50;
    private static final int BAR_HEIGHT = 20;
    private static final int SCREEN_WIDTH = 1280;
    private static final int SCREEN_HEIGHT = 720;
    private static final int START_X = 525;
    private static final int END_X = 710;
	private static int cardIndex = 0;
	private static double intMoney;
    private static List<BufferedImage> playerCards = new ArrayList<>();
    private static List<BufferedImage> dealerCards = new ArrayList<>();
    private static List<String> playerCardValues = new ArrayList<>();
    private static List<String> dealerCardValues = new ArrayList<>();
    private static final int CARD_WIDTH = 100;
    private static final int CARD_SPACING = 20;
    private static final int SPEED = 5;

    private static int playerTotal = 0;
    private static int dealerTotal = 0;
    private static boolean playerTurn = true;
    private static boolean gameEnded = false;

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
    private static BufferedImage noMoney1;
    private static BufferedImage noMoney2;
    private static BufferedImage main1;
    private static BufferedImage main2;
    private static BufferedImage play;
    private static BufferedImage quit;
    private static BufferedImage high;
    private static BufferedImage moneyBonus;
    private static BufferedImage miniStoryBoard;
    private static BufferedImage val_pix;
    private static BufferedImage nico_pix;
    private static BufferedImage nico_pix_1;
    private static BufferedImage val0;
    private static BufferedImage val1;
    private static BufferedImage val2;
    private static BufferedImage val3;
    private static BufferedImage val4;
    private static BufferedImage val5;
    private static BufferedImage val6;
    private static BufferedImage nico7;
    private static BufferedImage nico8;
    private static BufferedImage nico9;
    private static BufferedImage nico10;
    private static BufferedImage nico11;
    private static BufferedImage val12;
    private static BufferedImage nico13;
    private static BufferedImage nico14;
    private static BufferedImage nico15;
    private static BufferedImage val16;
    private static BufferedImage instructionboard;
    private static BufferedImage imgWinNico;
    private static BufferedImage imgWinVal;
    private static BufferedImage imgLose;
    private static BufferedImage normalUser;
    private static BufferedImage imgWin;
    private static BufferedImage imgTie;
    private static BufferedImage imgTie1;
    private static BufferedImage imgValPlayAgain;
    private static BufferedImage board;
    private static BufferedImage imgMaybeNot;
    private static BufferedImage cardBack;
    
    private static int intLastXPosition;
    private static int intLastYPosition;
    
    //Main game start
    public static void main(String[] args) {
        Console con = new Console("Valentina Moretti", 1280, 720);
        Color darkGray = Color.decode("#262927");
        loadImages(con);

        int intCountMainPage = 0;
        scoreBoardList = new TextOutputFile("scoreBoardList.txt", true);

        // Main animation loop.  Create flickering effect by using 2 images - main1 and main2
        while (intCountMainPage < 5) {
            con.drawImage(main1, 0, 0);
            con.repaint();
            con.sleep(300);
            con.drawImage(main2, 0, 0);
            con.repaint();
            con.sleep(300);
            intCountMainPage++;
        }

        // Play, High Score, Quit Button animation effect in main page 
        // (slide button from right for animation effect)
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
			
            // If "Play" button is clicked
            if (isButtonClicked(con, 500, 200, 400, 150)) {
				
				int intCounter;
				con.clear(); // Clear the console before starting
				con.setDrawColor(new Color(0, 0, 0)); // Set custom RGB color (black)

				// First animation: black rectangle sliding from left to right
				for (intCounter = 0; intCounter < 1280; intCounter += 4) {
					con.drawImage(normalUser, 0, 0);
					con.fillRect(0, 0, intCounter, 720);
					con.repaint();
					con.sleep(1);
				}
				
				loading(con);
				con.sleep(1000);



            	//User enter's their username.  
            	captureUserName(con);
            	
            	con.setDrawColor(Color.WHITE);
            	//Backstory before actual game starts
            	//Takes through sequence of pages with Nico and Val Interactions
            	playBackStoryPart1(con);
  			
            	//At end of back story part 1, user has to choose "Sure, let's play" or "maybe not"
            	//Show options as buttons for player to select. Capture player choice
				boolean buttonClicked = false;
				while (!buttonClicked) {
					
					int mouseX = con.currentMouseX();
					int mouseY = con.currentMouseY();
					
					// Sure, let's play button
					if (mouseX >= 490 && mouseX <= 690 && mouseY >= 600 && mouseY <= 650) {
						con.setDrawColor(Color.GREEN);
					} else {
						con.setDrawColor(Color.RED);
					}
					con.fillRect(480, 600, 220, 50);
					con.setDrawColor(Color.BLACK);
					con.drawRect(480, 600, 220, 50);
					con.drawString("Sure, let's play!", 490, 610);
	
					// Maybe not button
					if (mouseX >= 800 && mouseX <= 1000 && mouseY >= 600 && mouseY <= 650) {
						con.setDrawColor(Color.GREEN);
					} else {
						con.setDrawColor(Color.RED);
					}
					con.fillRect(800, 600, 200, 50);
					con.setDrawColor(Color.BLACK);
					con.drawRect(800, 600, 200, 50);
					con.drawString("Maybe not", 810, 610);
	
					con.repaint();
	
					// "Sure, let's play!" button clicked
					//   -- show animation of Val and Nico moving to play blackjack
					if (isButtonClicked(con, 490, 600, 200, 50)) {
							buttonClicked = true;
							playBackStoryPart2(con);
							
							//Main BlackJack Game starts here
							con.clear(); 
							
							//Capture bet amount as input from the player
							captureAndDisplayBetAmount(con);				
					
							// initializes the game 
							// & play game in loop until user wants to continue
							playAgain = true;
							resetGameState ();
							while (playAgain) {
								playAgain = playGame(con);
								if (playAgain) {
									resetGameState();
								}
							}
							con.closeConsole();
							
					//when "maybe not" button is clicked
					//exits the program after a small animation
					} else if (isButtonClicked(con, 800, 600, 200, 50)) {
						con.println("Goodbye");
						con.drawImage(imgMaybeNot, 0, 0);
						con.repaint();
						con.sleep(2000);
						playEndingAnimation(con);
						con.sleep(2000);
						System.exit(0); 
					}
				
				    con.sleep(16); // Short sleep to prevent excessive CPU usage
			    }  // while !button clicked
		
            } // end of if play button clicked
        
        // If High Score Button is clicked
        else if (isButtonClicked(con, 500, 370, 400, 150)) {
			int intCounter;
				con.clear(); // Clear the console before starting
				con.setDrawColor(new Color(0, 0, 0)); // Set custom RGB color (black)

				// First animation: black rectangle sliding from left to right
				for (intCounter = 0; intCounter < 1280; intCounter += 4) {
					con.drawImage(normalUser, 0, 0);
					con.fillRect(0, 0, intCounter, 720);
					con.repaint();
					con.sleep(1);
				}
				
				loading(con);
				con.sleep(1000);
			
			boolean bringScoreBoard = true;
			while (bringScoreBoard) {
	        	//call function which sreads the scoreboard file, create list, 
				//sort by scores and display top 10 scores
	        	showHighScores(con);
	        	
				// Keep the same screen until player clicks back button
				if (isButtonClicked(con, 1080, 520, 200, 200)) {
					bringScoreBoard = false;
					break; // Exit the while loop
				}

				con.sleep(16); 
			}
			// The code will continue to the main game loop after exiting the while loop
		
		//help button when clicked goes to the help screens
		}else if(isButtonClicked(con, 1170, 610, 110, 110)){//help button code
			handleHelpButton(con);
			
		}
		
		//when quit button is clicked, it automatically exits the game
        else if (isButtonClicked(con, 500, 540, 400, 150)) {
                    con.println("Quit button clicked");
                    running = false; // Exit the game loop
        }

        con.sleep(16); 
        }  // main while running = true
    }
    
    
    // Method to load all images used in the game
    
    private static void loadImages(Console con)
    {
        main1 = con.loadImage("images/main1.png");
        main2 = con.loadImage("images/main2.png");
        imgHelpButton = con.loadImage("images/helpButton.png");
        play = con.loadImage("images/play.png");
        quit = con.loadImage("images/quit.png");
        imgTie = con.loadImage("images/imgTie.png");
        imgTie1 = con.loadImage("images/imgTie1.png");
        imgMaybeNot = con.loadImage("images/maybeNot.png");
        imgHelp1 = con.loadImage("helpFromCreator/help1.png");
        imgHelp2 = con.loadImage("helpFromCreator/help2.png");
        imgHelp3 = con.loadImage("helpFromCreator/help3.png");
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
        high = con.loadImage("images/high.png");
        moneyBonus = con.loadImage("images/bonusmoney.png");
        imgMoneyBoard = con.loadImage("images/moneyCount.png");
        imgScoreBoard = con.loadImage("images/scoreBoard.png");
        imgBackButton = con.loadImage("images/back_button.png");
        imgFinalBoard = con.loadImage("images/finalBoard.png");
        imgMoneyWithBet = con.loadImage("images/moneyWithBet.png");
        noMoney1 = con.loadImage("images/noMoney1.png");
        noMoney2 = con.loadImage("images/noMoney2.png");
		board = con.loadImage("images/board.png");
		cardBack = con.loadImage("images/cards/card_back.png");
		imgWinVal = con.loadImage("images/val_win.png");
		imgWinNico = con.loadImage("images/nico_win.png");
		imgLose = con.loadImage("images/lose.png");
		imgWin = con.loadImage("images/win.png");
		imgValPlayAgain = con.loadImage("images/page6.png");
		
		miniStoryBoard = con.loadImage("images/miniStoryBoard.png");
		val_pix = con.loadImage("images/pix_val.png");
		nico_pix = con.loadImage("images/pix_nico.png");
		nico_pix_1 = con.loadImage("images/pix_nico_1.png");
		val0 = con.loadImage("images/page0.png");
		val1 = con.loadImage("images/page1.png");
		val2 = con.loadImage("images/page2.png");
		val3 = con.loadImage("images/page3.png");
		val4 = con.loadImage("images/page4.png");
		val5 = con.loadImage("images/page5.png");
		val6 = con.loadImage("images/page6.png");
		nico7 = con.loadImage("images/page7.png");
		nico8 = con.loadImage("images/page8.png");
		nico9 = con.loadImage("images/page9.png");
		nico10 = con.loadImage("images/page10.png");
		nico11 = con.loadImage("images/page11.png");
		val12 = con.loadImage("images/page12.png");
		nico13 = con.loadImage("images/page13.png");
		nico14 = con.loadImage("images/page14.png");
		nico15 = con.loadImage("images/page15.png");
		val16 = con.loadImage("images/page16.png");
		instructionboard = con.loadImage("images/instructionsboard.png");
    }
    
	public static void captureUserName(Console con) {
		BufferedImage statitan = con.loadImage("images/statitan.png");
		normalUser = con.loadImage("images/normal_user.png"); 
						
		//User enter's their username.  
		//Keep text color as White.  Position the user entry in control using println of '\n' (new line) and ' ' (space)
		con.drawImage(normalUser, 0, 0); // Redraw the image
		con.repaint();
		con.setTextColor(Color.WHITE);
		con.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	    con.print("						");
		strUser = con.readLine();
		
		//Cheatcode - statitan gets $2000.  Other users gets only $1000
		if(strUser.equalsIgnoreCase("statitan")) {
			 con.clear();
			 con.drawImage(statitan, 0, 0);
			 con.repaint();
			 intMoney = 2000;
			 con.sleep(2000);
					
		}else{
			con.drawImage(normalUser, 0, 0);
			intMoney = 1000;
			con.sleep(2000);
		}
		
	}
	
	// Play back story Part 1
	//  -- Animation to introduce Nico and Val characters & story backdrop
	public static void playBackStoryPart1(Console con) {
	
		con.clear();
		
		//pixel gameboard for starting the story
		con.drawImage(instructionboard, 0, 0);
		
		//initialize variables for the positions of the pixel characters - Val and Nico
		int x = 200;
		int y = 250;
		
		//setting the boundaries for the characters to move
		int topBoundary = 150;
		int bottomBoundary = 600 - val_pix.getHeight();
		int leftBoundary = 0;
		int rightBoundary = 600 - val_pix.getWidth();
		
		//drawing the characters - Nico and Val
		con.drawImage(nico_pix, 580, 250);
		con.drawImage(val_pix, x, y);
		con.repaint();
		con.sleep(5000);
		
		//does this loop while the x value of the val pizel character is not equal to the right boundary variable
		while (x != rightBoundary) {
			con.clear();
			con.drawImage(miniStoryBoard, 0, 0);
			con.drawImage(imgMoneyBoard, 0, 0);
			con.drawString("$" + String.valueOf(intMoney), 1080, 50);
			con.drawImage(nico_pix, 580, 250);
			con.drawImage(val_pix, x, y);
			con.repaint();
			
			//key controls to move the character to meet nico
			int key = con.getKey();
			if (key == 38 && y > topBoundary) 
			{
				y -= SPEED;
			} else if (key == 40 && y < bottomBoundary) 
			{
				y += SPEED;
			}else if (key == 37 && x > leftBoundary) 
			{
				x -= SPEED;
			}else if (key == 39 && x < rightBoundary) 
			{
				x += SPEED;
			}

			con.sleep(16);
		}
		
		intLastXPosition = x;
		intLastYPosition = y;
 
		//Start of story board - interaction between Val and Nico
		con.sleep(1000);
		drawStoryBoardPage(con, val0);
		con.sleep(2000);
		drawStoryBoardPage(con, val1);
		con.sleep(2000);
		drawStoryBoardPage(con, val2);
		con.sleep(2000);
		drawStoryBoardPage(con, val3);
		con.sleep(2000);
		drawStoryBoardPage(con, nico7);
		con.sleep(2000);
		drawStoryBoardPage(con, nico8);
		con.sleep(2000);
		drawStoryBoardPage(con, nico9);
		con.sleep(2000);
		drawStoryBoardPage(con, nico10);
		con.sleep(2000);
		drawStoryBoardPage(con, nico11);
		con.sleep(2000);
		drawStoryBoardPage(con, val4);
		con.sleep(2000);
		drawStoryBoardPage(con, val5);
		con.sleep(2000);
		drawStoryBoardPage(con, val6);
		con.sleep(2000);

	}
	
	// Play back story Part 2
	//  -- After back story part1, when user choose lets play option
	//  -- Animation to move Nico and Val characters to blackjack table
	//  -- Continuation of story board
	
	private static void playBackStoryPart2(Console con) {
		
		int x = intLastXPosition;
		int y = intLastYPosition;
		con.setDrawColor(Color.WHITE);
		//goes to the pixel game board and does an animation to move nico
		drawStoryBoardPage(con, miniStoryBoard);
		con.drawImage(val_pix, x, y);
		con.drawImage(nico_pix_1, 580, 250);
		con.repaint();
		int nico_x = 580;
		int nico_y = 250;
		
		//x-coordinates changes to move nico to the desired location
		while (nico_x < 800) {
			nico_x += SPEED; 
			drawStoryBoardPage(con, miniStoryBoard);
			con.drawImage(val_pix, x, 200);
			con.drawImage(nico_pix_1, nico_x, 250);
			con.repaint();
			con.sleep(16); 
		}
		
		//y-coordinates changes to move nico to the desired location
		while(nico_y > 0){
			nico_y -= SPEED;
			drawStoryBoardPage(con, miniStoryBoard);
			con.drawImage(val_pix, x, y);
			con.drawImage(nico_pix_1, nico_x, nico_y);
			con.repaint();
			con.sleep(16);
		}     
		con.drawImage(nico_pix, nico_x, nico_y);
		con.repaint(); 
		
		//x-coordinates changes to move valentina to the desired location
		while (x < 900) {
			x += SPEED; // Move the button to the middle animation
			drawStoryBoardPage(con, miniStoryBoard);
			con.drawImage(val_pix, x, y);
			con.drawImage(nico_pix, nico_x, nico_y);
			con.repaint();
			con.sleep(16); // Approximately 60 FPS
		}
			
		//y-coordinates changes to move valentina to the desired location
		while(y > 0){
			y -= SPEED;
			drawStoryBoardPage(con, miniStoryBoard);
			con.drawImage(val_pix, x, y);
			con.drawImage(nico_pix, nico_x, nico_y);
			con.repaint();
			con.sleep(16);
		}     
		
		// if statement to change the storyboard backdrop image according 
		// to whether the user has $1000 or $2000
		con.sleep(1000);
		if(intMoney == 1000){
			drawStoryBoardPage(con, val12);
			con.sleep(2000);
		}else{
			drawStoryBoardPage(con, moneyBonus);
			con.sleep(2000);
		}
		
		//Continuition of story board
		drawStoryBoardPage(con, nico13);
		con.sleep(2000);
		drawStoryBoardPage(con, nico14);
		con.sleep(2000);
		drawStoryBoardPage(con, nico15);
		con.sleep(2000);
		drawStoryBoardPage(con, val16);
		con.sleep(2000);
	}
	
	//Function: Capture bet amount as input from the player
	public static void captureAndDisplayBetAmount(Console con) {
		
		//User types their bet and the statement prevents the user from 
		//typing a number over their allocated money amount or a character which is not a number
		do {
			drawStoryBoardPage(con, val16);
			con.setTextColor(Color.WHITE);
			con.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            con.print("						       ");
			String input = con.readLine();
			drawStoryBoardPage(con, val16);
			// Handle error conditions on the bet amount.
			// 1. Bet Amount <= Wallet Amount
			// 2. Bet Amount should be integer
			try {
				intValue = Integer.parseInt(input);
			
				if (intValue > intMoney) {
					// Print user message that value must be lesser for few seconds
					con.setTextColor(Color.WHITE);
					con.drawString("Value must be less than or equal to " + intMoney + ". Try again.", 550, 650);
					con.repaint();
					con.sleep(2000);
					con.clear();
				}
			} catch (NumberFormatException e) {
				// If entered amount is not valid, then print user mesage accordingy.
				intValue = 9999;
				con.setTextColor(Color.WHITE);
				con.drawString("Invalid input. Please enter a number.", 550, 650);
				con.repaint();
				con.sleep(2000);
				con.clear();
			}
		} while (intValue > intMoney);
		
		con.clear(); // Clear the console one last time
		con.drawImage(val16, 0, 0); // Redraw the image
		con.setTextColor(Color.WHITE);
		con.drawString("$" + intValue, 700, 650);  //Display bet amount
		con.repaint();
		con.sleep(1000);
	}

	//reads the scoreboard file, create list, sort by scores and display top 10 scores
	
	private static void showHighScores(Console con) {
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
	}

    
    //Draw story board page - Generic function reused from multiple places
    //  -- Draw story board image passed in input (as full backdrop)
    //  -- Draw the money board image and show the player's money
    //  -- Sleep before moving to next page
    private static void drawStoryBoardPage(Console con, BufferedImage imgImage) {
		con.drawImage(imgImage, 0, 0);
		con.drawImage(imgMoneyBoard, 0, 0);
		con.drawString("$" + String.valueOf(intMoney), 1080, 50);
		con.repaint();
    }
    
    //ending animation when maybe not is clicked
    private static void playEndingAnimation(Console con) {
		BufferedImage miniStoryBoard = con.loadImage("images/miniStoryBoard.png");
				BufferedImage val_pix = con.loadImage("images/pix_val.png");
				BufferedImage nico_pix = con.loadImage("images/pix_nico.png");
				BufferedImage nico_pix_1 = con.loadImage("images/pix_nico_1.png");
		int x = 900;
		int y = 0;
		int nico_x = 800;
		int nico_y = 0;

		while (y < 250) {
			y += SPEED;
			con.drawImage(miniStoryBoard, 0, 0);
			con.drawImage(imgMoneyBoard, 0, 0);
			con.drawString("$" + String.valueOf(intMoney), 1080, 50);
			con.drawImage(val_pix, x, y);
			con.drawImage(nico_pix, nico_x, nico_y);
			con.repaint();
			con.sleep(16);
		} 

		while (x > 0) {
			x -= SPEED; // Changed += to -= to move left
			con.drawImage(miniStoryBoard, 0, 0);
			con.drawImage(imgMoneyBoard, 0, 0);
			con.drawString("$" + String.valueOf(intMoney), 1080, 50);
			con.drawImage(val_pix, x, y);
			con.drawImage(nico_pix, nico_x, nico_y);
			con.repaint();
			con.sleep(16); // Approximately 60 FPS
		}
	}

    //reads scores from scoreBoardList.txt
	private static void readScoresFromFile() {
        while (!scoreBoardListInput.eof()) {
            names.add(scoreBoardListInput.readLine());
            scores.add(Double.parseDouble(scoreBoardListInput.readLine()));
        }
        scoreBoardListInput.close();
    }

    //sorts scores using the bubble sort algorithm
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

    //displays the scores on the high score banner page --> only ranks 1 - 10
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
    
    //animates the play button by changing x-coordinate values and repainting.
    private static void animateButton(Console con, BufferedImage background, BufferedImage button, int y) {
        int x = 1280;
        while (x > 500) {
            x -= 30;
            con.drawImage(background, 0, 0);
            con.drawImage(button, x, y);
            con.repaint();
            con.sleep(16);
        }
    }
    
     private static void loading(Console con){
			imgLoad = con.loadImage("images/loading.png");

			for (int i = START_X; i <= END_X; i += 2) {
				// Clear the screen
				con.clear();

				// Draw the background image
				con.drawImage(imgLoad, 0, 0);

				// Draw the loading bar
				con.setDrawColor(Color.WHITE);
				con.fillRect(i, 530, BAR_WIDTH, BAR_HEIGHT);

				// Draw the border of the loading bar
				con.setDrawColor(Color.BLACK);
				con.drawRect(START_X, 530, END_X - START_X + BAR_WIDTH, BAR_HEIGHT);

				// Update the display
				con.repaint();

				// Add a small delay to control the animation speed
				con.sleep(16); // Approximately 60 FPS
        }
	 }
    
    
    //animates the high score button.  play button is kept in fixed position
    private static void animateButton(Console con, BufferedImage background, BufferedImage button1, BufferedImage button2, int y) {
        int x = 1280;
        while (x > 500) {
            x -= 30;
            con.drawImage(background, 0, 0);
            con.drawImage(button1, 500, 200);
            con.drawImage(button2, x, y);
            con.repaint();
            con.sleep(16);
        }
    }
    
    //animates the quit button.  play button and high score button are kept in fixed position
    private static void animateButton(Console con, BufferedImage background, BufferedImage button1, BufferedImage button2, BufferedImage button3, int y) {
        int x = 1280;
        while (x > 500) {
            x -= 30;
            con.drawImage(background, 0, 0);
            con.drawImage(button1, 500, 200);
            con.drawImage(button2, 500, 370);
            con.drawImage(button3, x, y);
            con.repaint();
            con.sleep(16);
        }
    }

    //To determine whether the button in the input coordinates is clicked or not
    private static boolean isButtonClicked(Console con, int x, int y, int width, int height) {
        int mouseX = con.currentMouseX();
        int mouseY = con.currentMouseY();
        return con.currentMouseButton() == 1 && mouseX >= x && mouseX <= (x + width) && mouseY >= y && mouseY <= (y + height);
    }
    
    //Method for the main gameplay
    private static boolean playGame(Console con) {
		
		//initializes the array
        String[][] deck = new String[52][4];
        String[] suits = {"D", "C", "H", "S"};
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        initializeDeck(deck, suits, values);
        shuffleDeck(deck);
        dealInitialCards(con, deck);
        drawScene(con);
        
        //if the player total is already 21, it goes to the determine winner method
        if (playerTotal == 21) {
            determineWinner(con);
        }
        
        //while game is not ended, it runs the player turn method and determines the logic for when the hit button, stand button or double down button is clicked
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
	
	//Initializes the deck of cards
    private static void initializeDeck(String[][] deck, String[] suits, String[] values) {
        int index = 0;
        for (String suit : suits) {
            for (String value : values) {
                deck[index][0] = value;
                deck[index][1] = suit;
                deck[index][2] = String.valueOf(getCardValue(value));
                deck[index][3] = "images/cards/" + value + "-" + suit + ".png";
                index++;
            }
        }
    }

    //gets the card value for each card
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
    
    //algorithm to shuffle the deck of cards
    private static void shuffleDeck(String[][] deck) {
        for (int i = deck.length - 1; i > 0; i--) {
            int j = (int)(Math.random() * (i + 1));
            String[] temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }
	
	//deals the first 2 cards for the player and the dealer
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

	//when the user plays "hit"
    private static void hitCard(Console con, String[][] deck) {
        BufferedImage newCard = loadCardImage(con, deck[cardIndex][3]);
        playerCards.add(newCard);
        playerCardValues.add(deck[cardIndex][0]);
        playerTotal = reCalculateTotal(playerCardValues);
        cardIndex++;
        animateCardShuffle(con);
        canDoubleDown = false;
    }

	//recalculates the total for the special case which is the ace
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

	//method when it is time for the dealer's turn
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

    //if statement to determine the winner after the game is finished
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

	//animates the card when the player presses hit to move the cards to the side
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
	
	//draws the scene for the gameplay
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
		// Adjust this value to move cards more to the left
		int centerOffset = 100; // You can increase or decrease this value as needed
		int startX = (640 - totalWidth / 2) - centerOffset;
		for (int i = 0; i < playerCards.size(); i++) {
			con.drawImage(playerCards.get(i), startX + i * (CARD_WIDTH + CARD_SPACING), 450);
		}
	}


	//display's the dealer's cards
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

	//loads the image
    private static BufferedImage loadCardImage(Console con, String imagePath) {
        return con.loadImage(imagePath);
    }

	//draws the hit button
    private static void drawHitButton(Console con) {
        con.setDrawColor(Color.RED);
        con.fillRect(900, 600, 100, 50);
        con.setDrawColor(Color.BLACK);
        con.drawRect(900, 600, 100, 50);
        con.drawString("HIT", 935, 610);
    }
	
	//draws the stand button
    private static void drawStandButton(Console con) {
        con.setDrawColor(Color.GREEN);
        con.fillRect(1020, 600, 100, 50);
        con.setDrawColor(Color.BLACK);
        con.drawRect(1020, 600, 100, 50);
        con.drawString("STAND", 1045, 610);
    }
	
	//draws the double down button
    private static void drawDoubleDownButton(Console con) {
        con.setDrawColor(Color.BLUE);
        con.fillRect(1140, 600, 100, 50);
        con.setDrawColor(Color.BLACK);
        con.drawRect(1140, 600, 100, 50);
        con.drawString("DOUBLE", 1160, 610);
    }

	//method for when hit button is clicked
    private static boolean isHitButtonClicked(Console con) {
        return con.currentMouseButton() == 1 && con.currentMouseX() >= 900 && con.currentMouseX() <= 1000 && con.currentMouseY() >= 600 && con.currentMouseY() <= 650;
    }

	//method for when stand button is clicked
    private static boolean isStandButtonClicked(Console con) {
        return con.currentMouseButton() == 1 && con.currentMouseX() >= 1020 && con.currentMouseX() <= 1120 && con.currentMouseY() >= 600 && con.currentMouseY() <= 650;
    }

    //method for when double down button is clicked
    private static boolean isDoubleDownButtonClicked(Console con) {
        return con.currentMouseButton() == 1 && con.currentMouseX() >= 1140 && con.currentMouseX() <= 1240 && con.currentMouseY() >= 600 && con.currentMouseY() <= 650;
    }

	//method for when double down is clicked
    private static void doubleDown(Console con, String[][] deck) {
		intValue = intValue*2;
        hitCard(con, deck);
        if (playerTotal > 21) {
            determineWinner(con);
        }
    }
    
    //displays the player and dealer total
    private static void displayTotals(Console con) {
        con.setDrawColor(Color.WHITE);
        con.drawString("Player Total: " + playerTotal, 10, 690);
        if (!playerTurn || gameEnded) {
            con.drawString("Dealer Total: " + dealerTotal, 10, 670);
        }
    }

	//method to ask the user to play again
    private static boolean askPlayAgain(Console con) {
	    if (intMoney > 0) {
	        con.clear();
	        con.drawImage(imgValPlayAgain, 0, 0);
	
	        while (true) {
	            int mouseX = con.currentMouseX();
	            int mouseY = con.currentMouseY();
	
	            // Sure, let's play button
	            if (mouseX >= 480 && mouseX <= 700 && mouseY >= 600 && mouseY <= 650) {
	                con.setDrawColor(Color.GREEN);
	            } else {
	                con.setDrawColor(Color.RED);
	            }
	            con.fillRect(480, 600, 220, 50);
	            con.setDrawColor(Color.BLACK);
	            con.drawRect(480, 600, 220, 50);
	            con.drawString("Sure, let's play!", 490, 610);
	
	            // Maybe not button
	            if (mouseX >= 800 && mouseX <= 1000 && mouseY >= 600 && mouseY <= 650) {
	                con.setDrawColor(Color.GREEN);
	            } else {
	                con.setDrawColor(Color.RED);
	            }
	            con.fillRect(800, 600, 200, 50);
	            con.setDrawColor(Color.BLACK);
	            con.drawRect(800, 600, 200, 50);
	            con.drawString("Maybe not", 810, 610);
	
	            con.repaint();
	
	            if (isButtonClicked(con, 480, 600, 220, 50)) {
	                resetGameState();
	                drawGameScreen(con);
	                return getValidBet(con);
	            } else if (isButtonClicked(con, 800, 600, 200, 50)) {
	                saveScore(strUser, intMoney);
	                showScoreboard(con);
	                return false;
	            }
	
	            con.sleep(16); // Add a small delay to prevent excessive CPU usage
	        }
	    } else {
	        con.drawImage(noMoney1, 0, 0);
	        con.repaint();
	        con.sleep(2000);
	        con.drawImage(noMoney2, 0, 0);
	        con.repaint();
	        con.sleep(2000);
	        System.out.println("Exiting");
	        return false;
	    }
	}



	//draws the screen to get the user's bet
	private static void drawGameScreen(Console con) {
		con.drawImage(val16, 0, 0);
		con.drawImage(imgMoneyBoard, 0, 0);
		con.drawString("$" + intMoney, 1080, 50);
		con.setTextColor(Color.WHITE);
		con.repaint();
	}

    //Method to get the user's bet
	private static boolean getValidBet(Console con) {
		do {
			con.setTextColor(Color.WHITE);
			con.setDrawColor(Color.WHITE);
			con.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			con.print("						       ");
			String input = con.readLine();
			try {
				intValue = Integer.parseInt(input);
				if (intValue > intMoney) {
					con.setDrawColor(Color.WHITE);
					displayErrorMessage(con, "Value must be less than or equal to " + intMoney + ".");
				}
			} catch (NumberFormatException e) {
				intValue = 9999;
				con.setDrawColor(Color.WHITE);
				displayErrorMessage(con, "Invalid input. Please enter a number.");
			}
		} while (intValue > intMoney);
		
		con.clear(); // Clear the console one last time
		con.drawImage(val16, 0, 0); // Redraw the image
		con.setTextColor(Color.WHITE);
		con.drawString("$" + intValue, 700, 650);
		con.repaint();
		con.sleep(1000);
		return true;
	}

	//displays the error message
	private static void displayErrorMessage(Console con, String message) {
		drawGameScreen(con);
		con.setTextColor(Color.WHITE);
		con.drawString(message, 550, 650);
		con.repaint();
		con.sleep(2000);
		con.clear();
		drawGameScreen(con);
	}
	
	//saves the scores to the file
	private static void saveScore(String user, double money) {
		scoreBoardList.println(user);
		scoreBoardList.println(money);
	}

	//displays the score board with the top 10 and the rank of the user who played recently
	private static void showScoreboard(Console con) {
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
			con.sleep(16);
		}
	}

    //display the final scores
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
	
	//method that searches and prints the rank of the user
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
	
	//method for when the play button is clicked
	//stores the images in an array such that when "enter" is pressed on the keyboard each time, it goes through each image
	private static void handleHelpButton(Console con) {
		BufferedImage[] helpImages = {
			imgHelp1, imgHelp2, imgHelp3, imgHelp5,
			imgHelp6, imgHelp7, imgHelp8, imgHelp9, imgHelp10,
			imgHelp11, imgHelp12, imgHelp13, imgHelp14, imgHelp15
		};
		
		int currentImageIndex = 0;
		
		while (currentImageIndex < helpImages.length) {
			con.clear();
			con.drawImage(helpImages[currentImageIndex], 0, 0);
			con.repaint();
			
			if (currentImageIndex == 8) { // At imgHelp10
				con.setTextColor(Color.WHITE);
				con.repaint();
				String input = con.readLine();
				
				if (input.equals("13")) {
					currentImageIndex = 11; // Show imgHelp11
					con.drawImage(imgHelp11, 0, 0);
					con.repaint();
					con.sleep(2000);
				} else {
					currentImageIndex = 10; // Show imgHelp12
					con.sleep(1000);
				}
			} else {
				while (true) {
					int key = con.currentChar();
					if (key == 10) { // Enter key
						System.out.println("Debug: currentImageIndex = " + currentImageIndex);  //Debug statement
						currentImageIndex++;
						con.sleep(1000);
						break;
					}
				}
			}
			
		}
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

	//resets the game status
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
