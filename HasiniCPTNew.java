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
import java.awt.Font;
import java.awt.image.*;

public class HasiniCPTNew {
	//Initializing global variables for the images, variables and lists
	
    private static final int intBAR_WIDTH = 50;
    private static final int intBAR_HEIGHT = 20;
    private static final int intSCREEN_WIDTH = 1280;
    private static final int intSCREEN_HEIGHT = 720;
    private static final int intSTART_X = 525;
    private static final int intEND_X = 710;
    private static final int intCARD_WIDTH = 100;
    private static final int intCARD_SPACING = 20;
	private static final int intTOP_SCORES_COUNT = 10;
	private static String[] strTopNames = new String[intTOP_SCORES_COUNT];
	private static double[] dblTopScores = new double[intTOP_SCORES_COUNT];
    private static final int intSPEED = 5;
	private static double dblMoney;
    private static int intCardIndex = 0;
    private static BufferedImage[][] imgPlayerCards = new BufferedImage[5][2];
    private static BufferedImage[][] imgDealerCards = new BufferedImage[5][2];
    private static String[][] strPlayerCardValues = new String[5][2];
    private static String[][] strDealerCardValues = new String[5][2];
    private static int intPlayerCardCount = 0;
    private static int intDealerCardCount = 0;
    private static int intDealerCardCountForArray = 2;
    private static int intMAX_SCORES = 100;
    private static String[] strNames = new String[intMAX_SCORES];
    private static double[] dblScores = new double[intMAX_SCORES];
    private static int intScoreCount = 0;


    private static int intPlayerTotal = 0;
    private static int intDealerTotal = 0;
    private static boolean blnPlayerTurn = true;
    private static boolean blnGameEnded = false;

    private static boolean blnCanDoubleDown = false;
    private static boolean blnPlayAgain = false;   
    private static BufferedImage imgMoneyBoard; 
    private static double dblValue;
    private static BufferedImage imgScoreBoard;
    private static String strUser;
    private static TextOutputFile scoreBoardList;
    private static TextInputFile scoreBoardListInput;
    
    //image global variables
    private static BufferedImage imgLoad;
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
    private static BufferedImage imgNoMoney1;
    private static BufferedImage imgNoMoney2;
    private static BufferedImage imgMain1;
    private static BufferedImage imgMain2;
    private static BufferedImage imgPlay;
    private static BufferedImage imgQuit;
    private static BufferedImage imgHigh;
    private static BufferedImage imgMoneyBonus;
    private static BufferedImage imgMiniStoryBoard;
    private static BufferedImage imgVal_pix;
    private static BufferedImage imgNico_pix;
    private static BufferedImage imgNico_pix_1;
    private static BufferedImage imgVal0;
    private static BufferedImage imgVal1;
    private static BufferedImage imgVal2;
    private static BufferedImage imgVal3;
    private static BufferedImage imgVal4;
    private static BufferedImage imgVal5;
    private static BufferedImage imgVal6;
    private static BufferedImage imgNico7;
    private static BufferedImage imgNico8;
    private static BufferedImage imgNico9;
    private static BufferedImage imgNico10;
    private static BufferedImage imgNico11;
    private static BufferedImage imgVal12;
    private static BufferedImage imgNico13;
    private static BufferedImage imgNico14;
    private static BufferedImage imgNico15;
    private static BufferedImage imgVal16;
    private static BufferedImage imgInstructionboard;
    private static BufferedImage imgWinNico;
    private static BufferedImage imgWinVal;
    private static BufferedImage imgLose;
    private static BufferedImage imgNormalUser;
    private static BufferedImage imgWin;
    private static BufferedImage imgTie;
    private static BufferedImage imgTie1;
    private static BufferedImage imgValPlayAgain;
    private static BufferedImage imgBoard;
    private static BufferedImage imgMaybeNot;
    private static BufferedImage imgCardBack;
    private static BufferedImage imgBlackjack;
    private static BufferedImage imgCharlie;
    
    private static int intLastXPosition;
    private static int intLastYPosition;
    
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
    
    private static Console con;
    
    //Main game start
    public static void main(String[] args) {
		if (args.length == 0 || !args[0].equalsIgnoreCase("repeat")) {
			con = new Console("Valentina Moretti", 1280, 720);
		}
        Color darkGray = Color.decode("#262927");
        loadImages(con);

        int intCountMainPage = 0;
        scoreBoardList = new TextOutputFile("winners.txt", true);

        // Main animation loop.  Create flickering effect by using 2 images - main1 and main2
        while (intCountMainPage < 5) {
            con.drawImage(imgMain1, 0, 0);
            con.repaint();
            con.sleep(300);
            con.drawImage(imgMain2, 0, 0);
            con.repaint();
            con.sleep(300);
            intCountMainPage++;
        }

        // Play, High Score, Quit Button animation effect in main page 
        // (slide button from right for animation effect)
        animateButton(con, imgMain2, imgPlay, 200);
        animateButton(con, imgMain2, imgPlay, imgHigh, 370);
        animateButton(con, imgMain2, imgPlay, imgHigh, imgQuit, 540);

        // Main game loop
        boolean blnRunning = true;
        while (blnRunning) {
            con.drawImage(imgMain2, 0, 0);
            con.drawImage(imgPlay, 500, 200);
            con.drawImage(imgHigh, 500, 370);
            con.drawImage(imgQuit, 500, 540);
            con.drawImage(imgHelpButton, 1170, 610);
            con.setDrawColor(Color.BLACK);
            con.fillRect(1240, 0, 40, 40);
            con.repaint();
			
            // If "Play" button is clicked
            if (isButtonClicked(con, 500, 200, 400, 150)) {
				
				//loading screen
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
				boolean blnButtonClicked = false;
				while (!blnButtonClicked) {
					
					//initialize mouse variables
					int intMouseX = con.currentMouseX();
					int intMouseY = con.currentMouseY();
					
					// Sure, let's play button when mouse button is hovered, changes color to green from red
					if (intMouseX >= 490 && intMouseX <= 690 && intMouseY >= 600 && intMouseY <= 650) {
						con.setDrawColor(Color.GREEN);
					} else {
						con.setDrawColor(Color.RED);
					}
					con.fillRect(480, 600, 220, 50);
					con.setDrawColor(Color.BLACK);
					con.drawRect(480, 600, 220, 50);
					con.drawString("Sure, let's play!", 490, 610);
	
					// Maybe not button when mouse button is hovered, changes color to green from red
					if (intMouseX >= 800 && intMouseX <= 1000 && intMouseY >= 600 && intMouseY <= 650) {
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
							loading(con);
							blnButtonClicked = true;
							playBackStoryPart2(con);
							
							//Main BlackJack Game starts here
							con.clear(); 
							
							//Capture bet amount as input from the player
							captureAndDisplayBetAmount(con);				
					
							// initializes the game 
							// & play game in loop until user wants to continue
							blnPlayAgain = true;
							resetGameState ();
							while (blnPlayAgain) {
								blnPlayAgain = playGame(con);
								if (blnPlayAgain) {
									resetGameState();
								}
							}
							con.closeConsole();
							
					//when "maybe not" button is clicked
					//exits the program after a small animation
					} else if (isButtonClicked(con, 800, 600, 200, 50)) {
						loading(con);
						con.drawImage(imgMaybeNot, 0, 0);
						con.repaint();
						con.sleep(2000);
						playEndingAnimation(con);
						con.sleep(2000);
						break;
					}
				
				    con.sleep(16); // Short sleep to prevent excessive CPU usage
			    }  // while !button clicked
		
            } // end of if play button clicked
        
        // If High Score Button is clicked
        else if (isButtonClicked(con, 500, 370, 400, 150)) {
				
				//loading screen
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
		
		//When the hidden black joke button is clicked
		}else if (isButtonClicked(con, 1240, 0, 40, 40)) {
            showGreenScreen = true;
            intYellowX = 0; // Reset yellow position when animation starts
            while(showGreenScreen){
				runAnimation(con);
			}
		//help button when clicked goes to the help screens
        }else if(isButtonClicked(con, 1170, 610, 110, 110)){//help button code
			handleHelpButton(con);
			
		}
		
		//when quit button is clicked, it automatically exits the game
        else if (isButtonClicked(con, 500, 540, 400, 150)) {
                    System.exit(0);
        }

        con.sleep(16); 
        }  // main while blnRunning = true
    }
    
    //plays the among us animation
    private static void runAnimation(Console con) {
        con.drawImage(imgSpace, 0, 0);
        con.drawImage(imgYellow, intYellowX, 250);
        con.drawImage(imgRed, 700, 250);
        
        // Move yellow.png to the right
        intYellowX += 5; 
        con.repaint();
        con.sleep(16);
        
        // Check if yellow has reached red
        if (intYellowX >= 550) {
            playEndSequence(con);
            showGreenScreen = false;
            intYellowX = 0; // Reset for next time
            con.clear(); // Clear the screen before returning to start
        }
    }
    
    //plays the joke sequence
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
    
    // Method to load all images used in the game
    
    private static void loadImages(Console con)
    {
        imgMain1 = con.loadImage("images/main1.png");
        imgMain2 = con.loadImage("images/main2.png");
        imgHelpButton = con.loadImage("images/helpButton.png");
        imgPlay = con.loadImage("images/play.png");
        imgQuit = con.loadImage("images/quit.png");
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
        imgHigh = con.loadImage("images/high.png");
        imgMoneyBonus = con.loadImage("images/bonusmoney.png");
        imgMoneyBoard = con.loadImage("images/moneyCount.png");
        imgScoreBoard = con.loadImage("images/scoreBoard.png");
        imgBackButton = con.loadImage("images/back_button.png");
        imgFinalBoard = con.loadImage("images/finalBoard.png");
        imgMoneyWithBet = con.loadImage("images/moneyWithBet.png");
        imgNoMoney1 = con.loadImage("images/noMoney1.png");
        imgNoMoney2 = con.loadImage("images/noMoney2.png");
		imgBoard = con.loadImage("images/board.png");
		imgCardBack = con.loadImage("images/cards/card_back.png");
		imgWinVal = con.loadImage("images/val_win.png");
		imgWinNico = con.loadImage("images/nico_win.png");
		imgLose = con.loadImage("images/lose.png");
		imgWin = con.loadImage("images/win.png");
		imgValPlayAgain = con.loadImage("images/page6.png");
		imgBlackjack = con.loadImage("images/blackjack.png");
		
		imgMiniStoryBoard = con.loadImage("images/miniStoryBoard.png");
		imgVal_pix = con.loadImage("images/pix_val.png");
		imgNico_pix = con.loadImage("images/pix_nico.png");
		imgNico_pix_1 = con.loadImage("images/pix_nico_1.png");
		imgVal0 = con.loadImage("images/page0.png");
		imgVal1 = con.loadImage("images/page1.png");
		imgVal2 = con.loadImage("images/page2.png");
		imgVal3 = con.loadImage("images/page3.png");
		imgVal4 = con.loadImage("images/page4.png");
		imgVal5 = con.loadImage("images/page5.png");
		imgVal6 = con.loadImage("images/page6.png");
		imgNico7 = con.loadImage("images/page7.png");
		imgNico8 = con.loadImage("images/page8.png");
		imgNico9 = con.loadImage("images/page9.png");
		imgNico10 = con.loadImage("images/page10.png");
		imgNico11 = con.loadImage("images/page11.png");
		imgVal12 = con.loadImage("images/page12.png");
		imgNico13 = con.loadImage("images/page13.png");
		imgNico14 = con.loadImage("images/page14.png");
		imgNico15 = con.loadImage("images/page15.png");
		imgVal16 = con.loadImage("images/page16.png");
		imgInstructionboard = con.loadImage("images/instructionsboard.png");
		imgYellow = con.loadImage("images/yellow.png");
        imgRed = con.loadImage("images/red.png");
        imgYellowSlap = con.loadImage("images/yellowSlap.png");
        imgDeadRed = con.loadImage("images/deadRed.png");
        imgJokePage1 = con.loadImage("images/jokePage1.png");
        imgJokePage2 = con.loadImage("images/jokePage2.png");
        imgJokePage3 = con.loadImage("images/jokePage3.png");
        imgJokePage4 = con.loadImage("images/jokePage4.png");
        imgSpace = con.loadImage("images/space.png");
        imgCharlie = con.loadImage("images/charlie.png");
    }
    
    //method for the user to get the user's username
	public static void captureUserName(Console con) {
        BufferedImage imgStatitan = con.loadImage("images/statitan.png");
        imgNormalUser = con.loadImage("images/normal_user.png");

        // Load the custom font
        Font fntFont = con.loadFont("font.ttf", 50);
        con.setTextFont(fntFont); // Set the custom font

        // User enters their username
        con.drawImage(imgNormalUser, 0, 0); // Redraw the image
        con.repaint();
        con.setTextColor(Color.WHITE);
        
        // Positioning the user entry with new lines and spaces
        // Adjust spacing as needed
        con.println("\n\n\n\n\n\n\n");
        con.print("                              ");  
        
        strUser = con.readLine(); // Read user input and stores it in strUser

        // Cheatcode - statitan gets $2000. Other users get only $1000
        if (strUser.equalsIgnoreCase("statitan")) {
            con.clear();
            con.drawImage(imgStatitan, 0, 0);
            con.repaint();
            dblMoney = 2000;
            con.sleep(2000);
        } else {
            con.drawImage(imgNormalUser, 0, 0);
            dblMoney = 1000;
            con.sleep(2000);
        }
    }
	
	// Play back story Part 1
	//  -- Animation to introduce Nico and Val characters & story backdrop
	public static void playBackStoryPart1(Console con) {
	
		con.clear();
		
		//pixel gameboard for starting the story
		con.drawImage(imgInstructionboard, 0, 0);
		
		//initialize variables for the positions of the pixel characters - Val and Nico
		int intX = 200;
		int intY = 250;
		
		//setting the boundaries for the characters to move
		int intTopBoundary = 150;
		int intBottomBoundary = 600 - imgVal_pix.getHeight();
		int intLeftBoundary = 0;
		int intRightBoundary = 600 - imgVal_pix.getWidth();
		
		//drawing the characters - Nico and Val
		con.drawImage(imgNico_pix, 580, 250);
		con.drawImage(imgVal_pix, intX, intY);
		con.repaint();
		con.sleep(5000);
		
		//does this loop while the x value of the val pizel character is not equal to the right boundary variable
		while (intX != intRightBoundary) {
			con.clear();
			con.drawImage(imgMiniStoryBoard, 0, 0);
			con.drawImage(imgMoneyBoard, 0, 0);
			con.drawString("$" + String.valueOf(dblMoney), 1080, 50);
			con.drawImage(imgNico_pix, 580, 250);
			con.drawImage(imgVal_pix, intX, intY);
			con.repaint();
			
			//key controls to move the character to meet nico like up, down, left, right
			int intKey = con.getKey();
			if (intKey == 38 && intY > intTopBoundary) 
			{
				intY -= intSPEED;
			} else if (intKey == 40 && intY < intBottomBoundary) 
			{
				intY += intSPEED;
			}else if (intKey == 37 && intX > intLeftBoundary) 
			{
				intX -= intSPEED;
			}else if (intKey == 39 && intX < intRightBoundary) 
			{
				intX += intSPEED;
			}

			con.sleep(16);
		}
		
		//initialize position of x and y for the next pixel board scene animation
		intLastXPosition = intX;
		intLastYPosition = intY;
 
		//Start of story board - interaction between Val and Nico
		con.sleep(1000);
		drawStoryBoardPage(con, imgVal0);
		con.sleep(2000);
		drawStoryBoardPage(con, imgVal1);
		con.sleep(2000);
		drawStoryBoardPage(con, imgVal2);
		con.sleep(2000);
		drawStoryBoardPage(con, imgVal3);
		con.sleep(2000);
		drawStoryBoardPage(con, imgNico7);
		con.sleep(2000);
		drawStoryBoardPage(con, imgNico8);
		con.sleep(2000);
		drawStoryBoardPage(con, imgNico9);
		con.sleep(2000);
		drawStoryBoardPage(con, imgNico10);
		con.sleep(2000);
		drawStoryBoardPage(con, imgNico11);
		con.sleep(2000);
		drawStoryBoardPage(con, imgVal4);
		con.sleep(2000);
		drawStoryBoardPage(con, imgVal5);
		con.sleep(2000);
		drawStoryBoardPage(con, imgVal6);
		con.sleep(2000);

	}
	
	// Play back story Part 2
	//  -- After back story part1, when user choose lets play option
	//  -- Animation to move Nico and Val characters to blackjack table
	//  -- Continuation of story board
	
	private static void playBackStoryPart2(Console con) {
		
		int intX = intLastXPosition;
		int intY = intLastYPosition;
		con.setDrawColor(Color.WHITE);
		//goes to the pixel game board and does an animation to move nico
		drawStoryBoardPage(con, imgMiniStoryBoard);
		con.drawImage(imgVal_pix, intX, intY);
		con.drawImage(imgNico_pix_1, 580, 250);
		con.repaint();
		int intNico_x = 580;
		int intNico_y = 250;
		
		//x-coordinates changes to move nico to the desired location
		while (intNico_x < 800) {
			intNico_x += intSPEED; 
			drawStoryBoardPage(con, imgMiniStoryBoard);
			con.drawImage(imgVal_pix, intX, 200);
			con.drawImage(imgNico_pix_1, intNico_x, 250);
			con.repaint();
			con.sleep(16); 
		}
		
		//y-coordinates changes to move nico to the desired location
		while(intNico_y > 0){
			intNico_y -= intSPEED;
			drawStoryBoardPage(con, imgMiniStoryBoard);
			con.drawImage(imgVal_pix, intX, intY);
			con.drawImage(imgNico_pix_1, intNico_x, intNico_y);
			con.repaint();
			con.sleep(16);
		}     
		con.drawImage(imgNico_pix, intNico_x, intNico_y);
		con.repaint(); 
		
		//x-coordinates changes to move valentina to the desired location
		while (intX < 900) {
			intX += intSPEED; // Move the button to the middle animation
			drawStoryBoardPage(con, imgMiniStoryBoard);
			con.drawImage(imgVal_pix, intX, intY);
			con.drawImage(imgNico_pix, intNico_x, intNico_y);
			con.repaint();
			con.sleep(16); // Approximately 60 FPS
		}
			
		//y-coordinates changes to move valentina to the desired location
		while(intY > 0){
			intY -= intSPEED;
			drawStoryBoardPage(con, imgMiniStoryBoard);
			con.drawImage(imgVal_pix, intX, intY);
			con.drawImage(imgNico_pix, intNico_x, intNico_y);
			con.repaint();
			con.sleep(16);
		}     
		
		// if statement to change the storyboard backdrop image according 
		// to whether the user has $1000 or $2000
		con.sleep(1000);
		if(dblMoney == 1000){
			drawStoryBoardPage(con, imgVal12);
			con.sleep(2000);
		}else{
			drawStoryBoardPage(con, imgMoneyBonus);
			con.sleep(2000);
		}
		
		//Continuition of story board
		drawStoryBoardPage(con, imgNico13);
		con.sleep(2000);
		drawStoryBoardPage(con, imgNico14);
		con.sleep(2000);
		drawStoryBoardPage(con, imgNico15);
		con.sleep(2000);
		drawStoryBoardPage(con, imgVal16);
		con.sleep(2000);
	}
	
	//Function: Capture bet amount as input from the player
	public static void captureAndDisplayBetAmount(Console con) {
		
		//User types their bet and the statement prevents the user from 
		//typing a number over their allocated money amount or a character which is not a number
		do {
			drawStoryBoardPage(con, imgVal16);
			con.setTextColor(Color.WHITE);
			con.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            con.print("	                   ");
			String input = con.readLine();
			drawStoryBoardPage(con, imgVal16);
			// Handle error conditions on the bet amount.
			// 1. Bet Amount <= Wallet Amount
			// 2. Bet Amount should be integer
			try {
				dblValue = Double.parseDouble(input);
			
				if (dblValue > dblMoney || dblValue == 0) {
					// Print user message that value must be lesser for few seconds
					con.setTextColor(Color.WHITE);
					con.drawString("Value must be less than or equal to " + dblMoney + " and not equal to 0. Try again.", 550, 650);
					con.repaint();
					con.sleep(2000);
					con.clear();
				}
			} catch (NumberFormatException e) {
				// If entered amount is not valid, then print user mesage accordingy.
				dblValue = 9999;
				con.setTextColor(Color.WHITE);
				con.drawString("Invalid input. Please enter a number.", 550, 650);
				con.repaint();
				con.sleep(2000);
				con.clear();
			}
		} while (dblValue > dblMoney || dblValue == 0);
		
		con.clear(); // Clear the console one last time
		con.drawImage(imgVal16, 0, 0); // Redraw the image
		con.setTextColor(Color.WHITE);
		con.drawString("$" + dblValue, 700, 650);  //Display bet amount
		con.repaint();
		con.sleep(1000);
	}

	//reads the scoreboard file, create list, sort by scores and display top 10 scores
	
	private static void showHighScores(Console con) {
		con.drawImage(imgScoreBoard, 0, 0);
		con.repaint();
		scoreBoardListInput = new TextInputFile("winners.txt");
		
		// Read top scores from file and display them
		readTopScoresFromFile(con);
		displayScores(con);
		
		con.drawImage(imgBackButton, 1080, 520);
		con.repaint();
	}

	// Method to read top scores from file
	private static void readTopScoresFromFile(Console con) {
		// Temporary storage for scores and names
		String[] strTempNames = new String[100]; // Assuming a maximum of 100 entries
		double[] dblTempScores = new double[100];
		int intCount = 0;

		// Read the file and populate temporary arrays
		while (!scoreBoardListInput.eof()) {
			String strName = scoreBoardListInput.readLine();
			double strScore = Double.parseDouble(scoreBoardListInput.readLine());
			
			// Store names and scores in temporary arrays
			strTempNames[intCount] = strName;
			dblTempScores[intCount] = strScore;
			intCount++;
		}
		
		scoreBoardListInput.close();

		// Determine the number of top scores to keep
		int intActualCount = Math.min(intCount, intTOP_SCORES_COUNT);
		
		// Initialize top scores and names arrays
		dblTopScores = new double[intTOP_SCORES_COUNT];
		strTopNames = new String[intTOP_SCORES_COUNT];

		// Populate top scores and names based on the temporary arrays
		for (int intI = 0; intI < intActualCount; intI++) {
			updateTopScores(strTempNames[intI], dblTempScores[intI]);
		}
	}

	// Method to update the top scores
	private static void updateTopScores(String strName, double dblScore) {
		int intInsertIndex = -1;

		// Find the position to insert the new score
		for (int intI = 0; intI < intTOP_SCORES_COUNT; intI++) {
			if (dblScore > dblTopScores[intI]) {
				intInsertIndex = intI;
				break;
			}
		}

		// If we found a position to insert, shift existing entries
		if (intInsertIndex != -1) {
			for (int intI = intTOP_SCORES_COUNT - 1; intI > intInsertIndex; intI--) {
				dblTopScores[intI] = dblTopScores[intI - 1];
				strTopNames[intI] = strTopNames[intI - 1];
			}
			dblTopScores[intInsertIndex] = dblScore;
			strTopNames[intInsertIndex] = strName;
		}
	}

	// Display total scores on the screen
	private static void displayScores(Console con) {
		Font font2 = new Font("Courier New", Font.BOLD, 20);
		con.setDrawFont(font2);
		
		for (int intI = 0; intI < intTOP_SCORES_COUNT; intI++) {
			if (dblTopScores[intI] != 0) { // Check if there is a valid score
				con.setDrawColor(Color.WHITE);
				if (intI < 5) {
					con.drawString(strTopNames[intI] + ": " + dblTopScores[intI], 200, 180 + intI * 90);
				} else {
					con.drawString(strTopNames[intI] + ": " + dblTopScores[intI], 770, 180 + (intI - 5) * 92);
				}
				con.repaint();
			}
		}
	}


    
    //Draw story board page - Generic function reused from multiple places
    //  -- Draw story board image passed in input (as full backdrop)
    //  -- Draw the money board image and show the player's money
    //  -- Sleep before moving to next page
    private static void drawStoryBoardPage(Console con, BufferedImage imgImage) {
		con.drawImage(imgImage, 0, 0);
		con.drawImage(imgMoneyBoard, 0, 0);
		con.drawString("$" + String.valueOf(dblMoney), 1080, 50);
		con.repaint();
    }
    
    //ending animation when maybe not is clicked
    private static void playEndingAnimation(Console con) {
		BufferedImage miniStoryBoard = con.loadImage("images/miniStoryBoard.png");
		BufferedImage imgVal_pix = con.loadImage("images/pix_val.png");
		BufferedImage imgNico_pix = con.loadImage("images/pix_nico.png");
		BufferedImage imgNico_pix_1 = con.loadImage("images/pix_nico_1.png");
		int intX = 900;
		int intY = 0;
		int intNico_x = 800;
		int intNico_y = 0;

		while (intY < 250) {
		    intY += intSPEED;
			con.drawImage(miniStoryBoard, 0, 0);
			con.drawImage(imgMoneyBoard, 0, 0);
			con.drawString("$" + String.valueOf(dblMoney), 1080, 50);
			con.drawImage(imgVal_pix, intX, intY);
			con.drawImage(imgNico_pix, intNico_x, intNico_y);
			con.repaint();
			con.sleep(16);
		} 
		
		//animations for the pixel characters
		while (intX > 0) {
			intX -= intSPEED; // Changed += to -= to move left
			con.drawImage(miniStoryBoard, 0, 0);
			con.drawImage(imgMoneyBoard, 0, 0);
			con.drawString("$" + String.valueOf(dblMoney), 1080, 50);
			con.drawImage(imgVal_pix, intX, intY);
			con.drawImage(imgNico_pix, intNico_x, intNico_y);
			con.repaint();
			con.sleep(16); // Approximately 60 FPS
		}
	}

    
    
    //animates the play button by changing x-coordinate values and repainting.
    private static void animateButton(Console con, BufferedImage imgBackground, BufferedImage imgButton, int intY) {
        int intX = 1280;
        while (intX > 500) {
            intX -= 30;
            con.drawImage(imgBackground, 0, 0);
            con.drawImage(imgButton, intX, intY);
            con.repaint();
            con.sleep(16);
        }
    }
    
    //loading animation
     private static void loading(Console con){
			imgLoad = con.loadImage("images/loading.png");
			int intCounter;
				con.clear(); // Clear the console before starting
				con.setDrawColor(new Color(0, 0, 0)); // Set custom RGB color (black)

				// First animation: black rectangle sliding from left to right
				for (intCounter = 0; intCounter < 1280; intCounter += 4) {
					con.fillRect(0, 0, intCounter, 720);
					con.repaint();
					con.sleep(1);
				}
				
			for (int intI = intSTART_X; intI <= intEND_X; intI += 2) {
				// Clear the screen
				con.clear();

				// Draw the background image
				con.drawImage(imgLoad, 0, 0);

				// Draw the loading bar
				con.setDrawColor(Color.WHITE);
				con.fillRect(intI, 530, intBAR_WIDTH, intBAR_HEIGHT);

				// Draw the border of the loading bar
				con.setDrawColor(Color.BLACK);
				con.drawRect(intSTART_X, 530, intEND_X - intSTART_X + intBAR_WIDTH, intBAR_HEIGHT);

				// Update the display
				con.repaint();

				// Add a small delay to control the animation speed
				con.sleep(16); // Approximately 60 FPS
        }
        con.sleep(1000);
	 }
    
    
    //animates the high score button.  play button is kept in fixed position
    private static void animateButton(Console con, BufferedImage imgBackground, BufferedImage imgButton1, BufferedImage imgButton2, int intY) {
        int intX = 1280;
        while (intX > 500) {
            intX -= 30;
            con.drawImage(imgBackground, 0, 0);
            con.drawImage(imgButton1, 500, 200);
            con.drawImage(imgButton2, intX, intY);
            con.repaint();
            con.sleep(16);
        }
    }
    
    //animates the quit button.  play button and high score button are kept in fixed position
    private static void animateButton(Console con, BufferedImage imgBackground, BufferedImage imgButton1, BufferedImage imgButton2, BufferedImage imgButton3, int intY) {
        int intX = 1280;
        while (intX > 500) {
            intX -= 30;
            con.drawImage(imgBackground, 0, 0);
            con.drawImage(imgButton1, 500, 200);
            con.drawImage(imgButton2, 500, 370);
            con.drawImage(imgButton3, intX, intY);
            con.repaint();
            con.sleep(16);
        }
    }

    //To determine whether the button in the input coordinates is clicked or not
    private static boolean isButtonClicked(Console con, int intX, int intY, int intWidth, int intHeight) {
        int intMouseX = con.currentMouseX();
        int intMouseY = con.currentMouseY();
        return con.currentMouseButton() == 1 && intMouseX >= intX && intMouseX <= (intX + intWidth) && intMouseY >= intY && intMouseY <= (intY + intHeight);
    }
    
    //Method for the main gameplay to start blackjack
    private static boolean playGame(Console con) {
		
		//initializes the 52x4 array
        String[][] strDeck = new String[52][4];
        String[] strSuits = {"D", "C", "H", "S"};
        String[] strValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        initializeDeck(strDeck, strSuits, strValues);
        shuffleDeck(strDeck);
        dealInitialCards(con, strDeck);
        drawScene(con);
        
        //if the player total is already 21, it's blackjack.  It goes to the determine winner method
        if (intPlayerTotal == 21) {
            determineWinner(con);
        }
        
        //while game is not ended, it runs the player turn method and determines the logic for when the hit button, stand button or double down button is clicked
        while (!blnGameEnded) {
            if (blnPlayerTurn) {
                if (isHitButtonClicked(con) && intPlayerTotal < 21) {
                    hitCard(con, strDeck);
                    //If playerTotal > 21 (busted) or player got 5 cards (Charlie rule) - then determine winner
                    if (intPlayerTotal > 21 || intPlayerCardCount == 5) {
                        blnPlayerTurn = false;
                        determineWinner(con);
                    //if playerTotal is equal to 21, then dealer turn
                    }else if(intPlayerTotal == 21){
						blnPlayerTurn = false;
						dealerTurn(con, strDeck);
					}
				//if stand button is clicked, then dealer turn
                } else if (isStandButtonClicked(con)) {
                    blnPlayerTurn = false;
                    dealerTurn(con, strDeck);
                   //if double down button is clicked, adds a card and dealer turn
                } else if (blnCanDoubleDown && isDoubleDownButtonClicked(con)) {
                    doubleDown(con, strDeck);
                    blnPlayerTurn = false;
                    dealerTurn(con, strDeck);
                }
            }
            drawScene(con);
            con.sleep(10);
        }

	//ask the user if he/she wants to play again
        return askPlayAgain(con);
    }
	
	//Initializes the deck of cards
    private static void initializeDeck(String[][] strDeck, String[] strSuits, String[] strValues) {
        int intIndex = 0;
        for (String strSuit : strSuits) {
            for (String strValue : strValues) {
                strDeck[intIndex][0] = strValue;
                strDeck[intIndex][1] = strSuit;
                strDeck[intIndex][2] = String.valueOf(getCardValue(strValue));
                strDeck[intIndex][3] = "images/cards/" + strValue + "-" + strSuit + ".png";
                intIndex++;
            }
        }
    }

    //gets the card value for each card using new java code I learnt: cases
    private static int getCardValue(String strValue) {
        switch (strValue) {
            case "A":
                return 11;
            case "K":
            case "Q":
            case "J":
                return 10;
            default:
                return Integer.parseInt(strValue);
        }
    }
    
    //algorithm to shuffle the deck of cards
    private static void shuffleDeck(String[][] strDeck) {
        for (int intI = strDeck.length - 1; intI > 0; intI--) {
            int intJ = (int)(Math.random() * (intI + 1));
            String[] strTemp = strDeck[intI];
            strDeck[intI] = strDeck[intJ];
            strDeck[intJ] = strTemp;
        }
    }
	
	//deals the first 2 cards for the player and the dealer
    private static void dealInitialCards(Console con, String[][] strDeck) {
        for (int intI = 0; intI < 2; intI++) {
            addCardToPlayer(con, strDeck[intCardIndex]);
            intCardIndex++;
            addCardToDealer(con, strDeck[intCardIndex]);
            intCardIndex++;
        }
        blnCanDoubleDown = (intPlayerTotal == 9 || intPlayerTotal == 10 || intPlayerTotal == 11);
    }

	//add a card to the player when this method is run
    private static void addCardToPlayer(Console con, String[] strCard) {
        imgPlayerCards[intPlayerCardCount][0] = loadCardImage(con, strCard[3]);
        strPlayerCardValues[intPlayerCardCount][0] = strCard[0];
        intPlayerCardCount++;
        intPlayerTotal = reCalculateTotal(strPlayerCardValues, intPlayerCardCount);
    }
	
	
	//adds a card to the dealer when this method is run
    private static void addCardToDealer(Console con, String[] strCard) {
        imgDealerCards[intDealerCardCount][0] = loadCardImage(con, strCard[3]);
        strDealerCardValues[intDealerCardCount][0] = strCard[0];
        intDealerCardCount++;
        intDealerTotal = reCalculateTotal(strDealerCardValues, intDealerCardCount);
    }


	//when the user plays "hit"
    private static void hitCard(Console con, String[][] strDeck) {
        addCardToPlayer(con, strDeck[intCardIndex]);
        intCardIndex++;
        
        animateCardShuffle(con);
        blnCanDoubleDown = false;

    }

	//recalculates the total for the special case which is the ace to recalculate it
    private static int reCalculateTotal(String[][] strCardValues, int intCardCount) {
        int intTotal = 0;
        int intAceCount = 0;
        for (int intI = 0; intI < intCardCount; intI++) {
            int intValue = getCardValue(strCardValues[intI][0]);
            if (intValue == 11) {
                intAceCount++;
            } else {
                intTotal += intValue;
            }
        }
    
        for (int intI = 0; intI < intAceCount; intI++) {
            if (intTotal < 10) {
                intTotal += 11;
            } else if (intTotal == 10 && intAceCount == 1) {
				intTotal += 11;
			} else {
                intTotal += 1;
            }
        }
        return intTotal;
    }

	//method when it is time for the dealer's turn
	//has to be checked still
     private static void dealerTurn(Console con, String[][] deck) {
        drawScene(con);
        while (intDealerTotal < 17 || intDealerTotal < intPlayerTotal) {
			if (intDealerCardCount == 5){
				break;
				
			}
            addCardToDealer(con, deck[intCardIndex]);
            intCardIndex++;
            
            drawScene(con);
            con.sleep(1000);
            intDealerCardCountForArray ++;
            System.out.println(intDealerCardCount);
        }
        determineWinner(con);
    }
    
    //method to determine the winner
	private static void determineWinner(Console con) {
		if(intPlayerTotal > 21){ //player bust
			con.sleep(2000);
            dblMoney = dblMoney - dblValue;
            con.drawImage(imgWinNico, 0, 0);
            con.repaint();
            con.sleep(2000);
            con.drawImage(imgLose, 0, 0);
		}else if(intPlayerTotal == 21 && intPlayerCardCount == 2){//blackjack
			con.sleep(2000);
			dblMoney = dblMoney + (2*dblValue);
			con.drawImage(imgBlackjack, 0, 0);
			con.repaint();
			con.sleep(2000);
			con.drawImage(imgWin, 0, 0);
		}else if(intPlayerCardCount == 5){//charlie rule
			dblMoney = dblMoney + (2*dblValue);
			con.drawImage(imgCharlie, 0, 0);
			System.out.println("charlie rule");
			con.repaint();
			con.sleep(2000);
			con.drawImage(imgWin, 0, 0);
		}else if(intPlayerTotal == intDealerTotal){//tie
			dblMoney = dblMoney;
            con.sleep(2000);
            con.drawImage(imgTie, 0, 0);
            con.repaint();
            con.sleep(2000);
            con.drawImage(imgTie1, 0, 0);
		}else if(intPlayerTotal > intDealerTotal || intDealerTotal > 21){//player wins
			dblMoney = dblMoney + dblValue;         
			con.drawImage(imgWinVal, 0, 0);
			con.repaint();
			con.sleep(2000);
			con.drawImage(imgWin, 0, 0);
		}else{//dealer wins
			con.sleep(2000);
            dblMoney = dblMoney - dblValue;
            con.drawImage(imgWinNico, 0, 0);
            con.repaint();
            con.sleep(2000);
            con.drawImage(imgLose, 0, 0);
		}
		con.repaint();
        con.sleep(2000);
        blnGameEnded = true;
        drawScene(con);
	}


	//animates the card when the player presses hit to move the cards to the side
    private static void animateCardShuffle(Console con) {
        int intTotalWidth = (intPlayerCardCount - 1) * (intCARD_WIDTH + intCARD_SPACING);
        int intStartX = 640 - intTotalWidth / 2;
        for (int intStep = 0; intStep < intCARD_SPACING; intStep++) {
            drawScene(con);
            for (int intI = 0; intI < intPlayerCardCount - 1; intI++) {
                con.drawImage(imgPlayerCards[intI][0], intStartX + intI * (intCARD_WIDTH + intCARD_SPACING) - intStep, 450);
            }
            con.drawImage(imgPlayerCards[intPlayerCardCount - 1][0], 1180, 450);
            con.repaint();
            con.sleep(16);
        }
        drawScene(con);
    }
	
	//draws the scene for the gameplay
    private static void drawScene(Console con) {
        con.drawImage(imgBoard, 0, 0);
        con.drawImage(imgMoneyWithBet, 0, 0);
		con.drawString("$" + String.valueOf(dblMoney), 1080, 50);
		con.drawString("$" + String.valueOf(dblValue), 1100, 256);
        displayDealerCards(con);
        displayPlayerCards(con);
        if (blnPlayerTurn && intPlayerTotal < 21 && intPlayerCardCount != 5) {
            drawHitButton(con);
            drawStandButton(con);
            if (blnCanDoubleDown) {
                drawDoubleDownButton(con);
            }
        }
        displayTotals(con);
        con.repaint();
    }

	//display's the player's cards on the screen
	private static void displayPlayerCards(Console con) {
		int intTotalWidth = (intPlayerCardCount - 1) * (intCARD_WIDTH + intCARD_SPACING);
        int intStartX = 640 - intTotalWidth / 2;
        for (int i = 0; i < intPlayerCardCount; i++) {
            con.drawImage(imgPlayerCards[i][0], intStartX + i * (intCARD_WIDTH + intCARD_SPACING), 450);
        }
	}


	//display's the dealer's cards
    private static void displayDealerCards(Console con) {
        con.drawImage(imgDealerCards[0][0], 500, 0);
        if (blnPlayerTurn) {
            con.drawImage(imgCardBack, 600, 0);
        } else {
            for (int i = 1; i < intDealerCardCount; i++) {
                con.drawImage(imgDealerCards[i][0], 500 + i * (intCARD_WIDTH + intCARD_SPACING), 0);
            }
        }
    }

	//loads the images
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
		dblValue = dblValue*2;
        hitCard(con, deck);
        if (intPlayerTotal > 21) {
            determineWinner(con);
        }
    }
    
    //displays the player and dealer total
    private static void displayTotals(Console con) {
        con.setDrawColor(Color.WHITE);
        con.drawString("Player Total: " + intPlayerTotal, 10, 690);
        if (!blnPlayerTurn || blnGameEnded) {
            con.drawString("Dealer Total: " + intDealerTotal, 10, 670);
        }
    }
	
	//displays the score board with the top 10 and the rank of the user who played recently
	private static void showScoreBoard(Console con) {
        boolean blnBringScoreBoard = true;
        while (blnBringScoreBoard) {
            con.drawImage(imgFinalBoard, 0, 0); 
            con.repaint();
            scoreBoardListInput = new TextInputFile("winners.txt");
            readScoresFromFileFinal(con);
            sortScores(con);
            displayScoresFinal(con);
            searchUserAndPrintRank(con);
            con.drawImage(imgBackButton, 1080, 520);
            con.repaint();
            con.sleep(16);
            if (isButtonClicked(con, 1080, 520, 200, 200)) {
					blnBringScoreBoard = false;
					String [] args = new String[1];
					args[0] = "repeat";
					main(args);
					break; // Exit the while loop
			}
        }
    }
	
	
	//read scores from file
    private static void readScoresFromFileFinal(Console con) {
        intScoreCount = 0;
        while (!scoreBoardListInput.eof() && intScoreCount < intMAX_SCORES) {
            strNames[intScoreCount] = scoreBoardListInput.readLine();
            dblScores[intScoreCount] = Double.parseDouble(scoreBoardListInput.readLine());
            intScoreCount++;
        }
        scoreBoardListInput.close();
    }

	//sorts the scores using bubble sort
    private static void sortScores(Console con) {
        for (int intI = 0; intI < intScoreCount - 1; intI++) {
            for (int intJ = 0; intJ < intScoreCount - intI - 1; intJ++) {
                if (dblScores[intJ] < dblScores[intJ + 1]) {
                    // Swap scores
                    double dblTempScore = dblScores[intJ];
                    dblScores[intJ] = dblScores[intJ + 1];
                    dblScores[intJ + 1] = dblTempScore;
                    // Swap names
                    String dblTempName = strNames[intJ];
                    strNames[intJ] = strNames[intJ + 1];
                    strNames[intJ + 1] = dblTempName;
                }
            }
        }
    }
	
	//displays the final scores for the score board --> first five on the left and second five on the left
    private static void displayScoresFinal(Console con) {
        for (int intI = 0; intI < Math.min(5, intScoreCount); intI++) {
            con.setDrawColor(Color.WHITE);
            con.drawString(strNames[intI] + ": " + dblScores[intI], 300, 180 + intI * 80);
            con.repaint();
        }
        for (int intI = 5; intI < Math.min(10, intScoreCount); intI++) {
            con.setDrawColor(Color.WHITE);
            con.drawString(strNames[intI] + ": " + dblScores[intI], 790, 180 + (intI - 5) * 80);
            con.repaint();
        }
    }

	//searches and prints the current rank of the user
    private static void searchUserAndPrintRank(Console con) {
        // count the number of users
        int intUserCount = 0;
        scoreBoardListInput = new TextInputFile("winners.txt");
        while (!scoreBoardListInput.eof()) {
            scoreBoardListInput.readLine(); // name
            scoreBoardListInput.readLine(); // money
            intUserCount++;
        }
        scoreBoardListInput.close();

        // Create array with exact size
        double[] dblAllMoney = new double[intUserCount];

        // populate the array and find user's money
        double dblUserMoney = -1;
        int intIndex = 0;
        scoreBoardListInput = new TextInputFile("winners.txt");
        while (!scoreBoardListInput.eof()) {
            String strName = scoreBoardListInput.readLine();
            String strMoney = scoreBoardListInput.readLine();
            dblAllMoney[intIndex] = Double.parseDouble(strMoney);
            if (strName.equalsIgnoreCase(strUser)) {
                dblUserMoney = dblAllMoney[intIndex];
            }
            intIndex++;
        }
        scoreBoardListInput.close();

        // Sort the money array in descending order
        bubbleSortDescending(dblAllMoney);

        // Find the user's rank
        int intRank = 1;
        for (int intI = 0; intI < dblAllMoney.length; intI++) {
            if (dblAllMoney[intI] == dblUserMoney) {
                break;
            }
            intRank++;
        }

        // Print the rank
        con.drawString(String.valueOf(intRank), 500, 650);
    }

	//bubble sort method
    private static void bubbleSortDescending(double[] dblArr) {
        int intN = dblArr.length;
        for (int intI = 0; intI < intN - 1; intI++) {
            for (int intJ = 0; intJ < intN - intI - 1; intJ++) {
                if (dblArr[intJ] < dblArr[intJ + 1]) {
                    // Swap elements
                    double dblTemp = dblArr[intJ];
                    dblArr[intJ] = dblArr[intJ + 1];
                    dblArr[intJ + 1] = dblTemp;
                }
            }
        }
    }
	//method to ask the user to play again
    private static boolean askPlayAgain(Console con) {
	    if (dblMoney > 0) {
	        con.clear();
	        con.drawImage(imgValPlayAgain, 0, 0);
	
	        while (true) {
	            int intMouseX = con.currentMouseX();
	            int intMouseY = con.currentMouseY();
	
	            // Sure, let's play button
	            if (intMouseX >= 480 && intMouseX <= 700 && intMouseY >= 600 && intMouseY <= 650) {
	                con.setDrawColor(Color.GREEN);
	            } else {
	                con.setDrawColor(Color.RED);
	            }
	            con.fillRect(480, 600, 220, 50);
	            con.setDrawColor(Color.BLACK);
	            con.drawRect(480, 600, 220, 50);
	            con.drawString("Sure, let's play!", 490, 610);
	
	            // Maybe not button
	            if (intMouseX >= 800 && intMouseX <= 1000 && intMouseY >= 600 && intMouseY <= 650) {
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
	                saveScore(strUser, dblMoney);
	                showScoreBoard(con);
	                
	                return false;
	            }
	
	            con.sleep(16); // Add a small delay to prevent excessive CPU usage
	        }
	    } else {
	        con.drawImage(imgNoMoney1, 0, 0);
	        con.repaint();
	        con.sleep(2000);
	        con.drawImage(imgNoMoney2, 0, 0);
	        con.repaint();
	        con.sleep(2000);
	        System.out.println("Exiting");
	        return false;
	    }
	}



	//draws the screen to get the user's bet
	private static void drawGameScreen(Console con) {
		con.drawImage(imgVal16, 0, 0);
		con.drawImage(imgMoneyBoard, 0, 0);
		con.drawString("$" + dblMoney, 1080, 50);
		con.setTextColor(Color.WHITE);
		con.repaint();
	}

    //Method to get the user's bet
	private static boolean getValidBet(Console con) {
		do {
			con.setTextColor(Color.WHITE);
			con.setDrawColor(Color.WHITE);
			//spacing to let the user enter their bet
			con.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            con.print("	                      ");
			String strInput = con.readLine();
			//try and catch exception error
			try {
				dblValue = Double.parseDouble(strInput);
				if (dblValue > dblMoney || dblValue < 0 || dblValue == 0) {
					con.setDrawColor(Color.WHITE);
					displayErrorMessage(con, "Value must be < or = to " + dblMoney + " or greater than 0.");
				}
			} catch (NumberFormatException e) {
				dblValue = 9999;
				con.setDrawColor(Color.WHITE);
				displayErrorMessage(con, "Invalid input. Please enter a number.");
			}
		} while (dblValue > dblMoney || dblValue == 0);
		
		con.clear(); // Clear the console one last time
		con.drawImage(imgVal16, 0, 0); // Redraw the image
		con.setTextColor(Color.WHITE);
		con.drawString("$" + dblValue, 700, 650);
		con.repaint();
		con.sleep(1000);
		return true;
	}

	//displays the error message
	private static void displayErrorMessage(Console con, String strMessage) {
		drawGameScreen(con);
		con.setTextColor(Color.WHITE);
		con.drawString(strMessage, 550, 650);
		con.repaint();
		con.sleep(2000);
		con.clear();
		drawGameScreen(con);
	}
	
	//saves the scores to the file
	private static void saveScore(String strUser, double dblMoney) {
		scoreBoardList.println(strUser);
		scoreBoardList.println(dblMoney);
	}

	
	
	//method for when the play button is clicked
	//stores the images in an array such that when "enter" is pressed on the keyboard each time, it goes through each image
	private static void handleHelpButton(Console con) {
		BufferedImage[] imgHelpImages = {
			imgHelp1, imgHelp2, imgHelp3, imgHelp5,
			imgHelp6, imgHelp7, imgHelp8, imgHelp9, imgHelp10,
			imgHelp11, imgHelp12, imgHelp13, imgHelp14, imgHelp15
		};
		
		int intCurrentImageIndex = 0;
		
		//goes through each image and checks the page logic when it is time for the user should ansert the question
		while (intCurrentImageIndex < imgHelpImages.length) {
			con.clear();
			con.drawImage(imgHelpImages[intCurrentImageIndex], 0, 0);
			con.repaint();
			
			if (intCurrentImageIndex == 8) { // At imgHelp10
				con.setTextColor(Color.WHITE);
				con.repaint();
				String input = con.readLine();
				
				if (input.equals("13")) {
					intCurrentImageIndex = 11; // Show imgHelp11
					con.drawImage(imgHelp11, 0, 0);
					con.repaint();
					con.sleep(2000);
				} else {
					intCurrentImageIndex = 10; // Show imgHelp12
					con.sleep(1000);
				}
			} else {
				while (true) {
					int intKey = con.currentChar();
					if (intKey == 10) { // Checks if user clicked the Enter key
						System.out.println("Debug: currentImageIndex = " + intCurrentImageIndex);  //Debug statement
						intCurrentImageIndex++;
						con.sleep(160);
						break;
					}
				}
			}
			
		}
	}

	//resets the game status by resetting all the variables
    private static void resetGameState() {
        intCardIndex = 0;
        intPlayerCardCount = 0;
        intDealerCardCount = 0;
        intPlayerTotal = 0;
        intDealerTotal = 0;
        blnPlayerTurn = true;
        blnGameEnded = false;
        blnCanDoubleDown = false;
    }
}
