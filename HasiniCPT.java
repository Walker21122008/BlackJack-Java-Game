import arc.*;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;

public class HasiniCPT {

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
  private static BufferedImage imgexitmainpage;
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
  private static BufferedImage imgTie2;
  private static BufferedImage imgValPlayAgain;
  private static BufferedImage imgBoard;
  private static BufferedImage imgMaybeNot;
  private static BufferedImage imgCardBack;
  private static BufferedImage imgBlackjack;
  private static BufferedImage imgCharlie;
  private static BufferedImage imgSkipButton;
  private static BufferedImage imgAngryVal1;
  private static BufferedImage imgAngryVal2;
  private static BufferedImage imgAngryVal3;
  private static BufferedImage imgAngryNico1;
  private static BufferedImage imgAngryNico2;

  private static int intLastXPosition;
  private static int intLastYPosition;

  private static boolean blnShowGreenScreen = false;
  private static BufferedImage imgYellow;
  private static BufferedImage imgRed;
  private static BufferedImage imgYellowSlap;
  private static BufferedImage imgDeadRed;
  private static BufferedImage imgJokePage1;
  private static BufferedImage imgJokePage2;
  private static BufferedImage imgJokePage3;
  private static BufferedImage imgJokePage4;
  private static BufferedImage imgSpace;
  private static int intYellowX = 0; 

  private static Console con;


  public static void main(String[] args) {
    if (args.length == 0 || !args[0].equalsIgnoreCase("repeat")) {
      con = new Console("Valentina Moretti", 1280, 720);
    }

    Color darkGray = Color.decode("#262927");
    loadImages(con);

    int intCountMainPage = 0;
    scoreBoardList = new TextOutputFile("winners.txt", true);

    while (intCountMainPage < 5) {
      con.drawImage(imgMain1, 0, 0);
      con.repaint();
      con.sleep(300);
      con.drawImage(imgMain2, 0, 0);
      con.repaint();
      con.sleep(300);
      intCountMainPage++;
    }


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

      if (isButtonClicked(con, 500, 200, 400, 150)) {

        loading(con);
        con.sleep(1000);

        // User enter's their username.
        captureUserName(con);

        con.setDrawColor(Color.WHITE);
        
        playBackStoryPart1(con);

        
        boolean blnButtonClicked = false;
        while (!blnButtonClicked) {

          int intMouseX = con.currentMouseX();
          int intMouseY = con.currentMouseY();


          if (intMouseX >= 490 && intMouseX <= 690 && intMouseY >= 600 && intMouseY <= 650) {
            con.setDrawColor(Color.GREEN);
          } else {
            con.setDrawColor(Color.RED);
          }
          con.fillRect(480, 600, 220, 50);
          con.setDrawColor(Color.BLACK);
          con.drawRect(480, 600, 220, 50);
          con.drawString("Sure, let's play!", 490, 610);

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


          if (isButtonClicked(con, 490, 600, 200, 50)) {
            loading(con);
            blnButtonClicked = true;
            playBackStoryPart2(con);

            con.clear();

            captureAndDisplayBetAmount(con);

  
            blnPlayAgain = true;
            resetGameState();
            while (blnPlayAgain) {
              blnPlayAgain = playGame(con);
              if (blnPlayAgain) {
                resetGameState();
              }
            }
            con.closeConsole();


          } else if (isButtonClicked(con, 800, 600, 200, 50)) {
            loading(con);
            con.drawImage(imgMaybeNot, 0, 0);
            con.repaint();
            con.sleep(2000);
            playEndingAnimation(con);
            con.sleep(2000);
            loadingOutScreen(con);
            break;
          }

          con.sleep(16);
        } 

      } 

      else if (isButtonClicked(con, 500, 370, 400, 150)) {

        loading(con);
        con.sleep(1000);

        boolean blnBringScoreBoard = true;
        while (blnBringScoreBoard) {
     
          showHighScores(con);

          if (isButtonClicked(con, 1080, 520, 200, 200)) {
            blnBringScoreBoard = false;
            break; 
          }

          con.sleep(16);
        }


      } else if (isButtonClicked(con, 1240, 0, 40, 40)) {
        blnShowGreenScreen = true;
        intYellowX = 0;
        while (blnShowGreenScreen) {
          runAnimation(con);
        }
      } else if (isButtonClicked(con, 1170, 610, 110, 110)) { // help button code
        handleHelpButton(con);

      }

      else if (isButtonClicked(con, 500, 540, 400, 150)) {
        System.exit(0);
      }

      con.sleep(16);
    } 
  }

  private static void runAnimation(Console con) {
    con.drawImage(imgSpace, 0, 0);
    con.drawImage(imgYellow, intYellowX, 250);
    con.drawImage(imgRed, 700, 250);

    intYellowX += 5;
    con.repaint();
    con.sleep(16);

    if (intYellowX >= 550) {
      playEndSequence(con);
      blnShowGreenScreen = false;
      intYellowX = 0; 
      con.clear(); 
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


  private static void loadImages(Console con) {
    imgMain1 = con.loadImage("images/main1.png");
    imgMain2 = con.loadImage("images/main2.png");
    imgHelpButton = con.loadImage("images/helpButton.png");
    imgPlay = con.loadImage("images/play.png");
    imgQuit = con.loadImage("images/quit.png");
    imgTie = con.loadImage("images/imgTie.png");
    imgTie1 = con.loadImage("images/imgTie1.png");
    imgTie2 = con.loadImage("images/imgTie2.png");
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
    imgAngryVal1 = con.loadImage("images/angryval1.png");
    imgAngryVal2 = con.loadImage("images/angryval2.png");
    imgAngryVal3 = con.loadImage("images/angryval3.png");
    imgAngryNico1 = con.loadImage("images/angrynico1.png");
    imgAngryNico2 = con.loadImage("images/angrynico2.png");

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
    imgSkipButton = con.loadImage("images/skip_button.png");
  }

  public static void captureUserName(Console con) {
    BufferedImage imgStatitan = con.loadImage("images/statitan.png");
    imgNormalUser = con.loadImage("images/normal_user.png");

    Font fntFont = con.loadFont("font.ttf", 50);
    con.setTextFont(fntFont);

    con.drawImage(imgNormalUser, 0, 0);
    con.repaint();
    con.setTextColor(Color.WHITE);


    con.println("\n\n\n\n\n\n\n");
    con.print("                              ");

    strUser = con.readLine(); 

    if (strUser.equalsIgnoreCase("attract")) {
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

  
  public static void playBackStoryPart1(Console con) {

    con.clear();

    con.drawImage(imgInstructionboard, 0, 0);

    int intX = 200;
    int intY = 250;

    int intTopBoundary = 150;
    int intBottomBoundary = 600 - imgVal_pix.getHeight();
    int intLeftBoundary = 0;
    int intRightBoundary = 600 - imgVal_pix.getWidth();

    con.drawImage(imgNico_pix, 580, 250);
    con.drawImage(imgVal_pix, intX, intY);
    con.repaint();


    while (intX != intRightBoundary) {
      con.clear();
      con.drawImage(imgInstructionboard, 0, 0);
      con.drawImage(imgMoneyBoard, 0, 0);
      con.drawString("$" + String.valueOf(dblMoney), 1080, 50);
      con.drawImage(imgNico_pix, 580, 250);
      con.drawImage(imgVal_pix, intX, intY);
      con.repaint();

      int intKey = con.getKey();
      if (intKey == 38 && intY > intTopBoundary) {
        intY -= intSPEED;
      } else if (intKey == 40 && intY < intBottomBoundary) {
        intY += intSPEED;
      } else if (intKey == 37 && intX > intLeftBoundary) {
        intX -= intSPEED;
      } else if (intKey == 39 && intX < intRightBoundary) {
        intX += intSPEED;
      }

      con.sleep(16);
    }

    intLastXPosition = intX;
    intLastYPosition = intY;

    BufferedImage[] storyImages = {
      imgVal0, imgVal1, imgVal2, imgVal3, imgNico7,
      imgNico8, imgNico9, imgNico10, imgNico11, imgVal4,
      imgVal5, imgVal6
    };
    
    for (BufferedImage image : storyImages) {
        drawStoryBoardPageWithSkipButton(con, image);
    }
  }



  private static void playBackStoryPart2(Console con) {

    int intX = intLastXPosition;
    int intY = intLastYPosition;
    con.setDrawColor(Color.WHITE);
    drawStoryBoardPage(con, imgMiniStoryBoard);
    con.drawImage(imgVal_pix, intX, intY);
    con.drawImage(imgNico_pix_1, 580, 250);
    con.repaint();
    int intNico_x = 580;
    int intNico_y = 250;

    while (intNico_x < 800) {
      intNico_x += intSPEED;
      drawStoryBoardPage(con, imgMiniStoryBoard);
      con.drawImage(imgVal_pix, intX, 200);
      con.drawImage(imgNico_pix_1, intNico_x, 250);
      con.repaint();
      con.sleep(16);
    }

    while (intNico_y > 0) {
      intNico_y -= intSPEED;
      drawStoryBoardPage(con, imgMiniStoryBoard);
      con.drawImage(imgVal_pix, intX, intY);
      con.drawImage(imgNico_pix_1, intNico_x, intNico_y);
      con.repaint();
      con.sleep(16);
    }
    con.drawImage(imgNico_pix, intNico_x, intNico_y);
    con.repaint();

    while (intX < 900) {
      intX += intSPEED; 
      drawStoryBoardPage(con, imgMiniStoryBoard);
      con.drawImage(imgVal_pix, intX, intY);
      con.drawImage(imgNico_pix, intNico_x, intNico_y);
      con.repaint();
      con.sleep(16); 
    }

    while (intY > 0) {
      intY -= intSPEED;
      drawStoryBoardPage(con, imgMiniStoryBoard);
      con.drawImage(imgVal_pix, intX, intY);
      con.drawImage(imgNico_pix, intNico_x, intNico_y);
      con.repaint();
      con.sleep(16);
    }

    BufferedImage[] secondStoryImages = {
      imgVal12, imgNico13, imgNico14, imgNico15, imgVal16
    };
    
    for (BufferedImage image : secondStoryImages) {
        drawStoryBoardPageWithSkipButton(con, image);
    }
    
  }

  public static void captureAndDisplayBetAmount(Console con) {


    do {
      drawStoryBoardPage(con, imgVal16);
      con.setTextColor(Color.WHITE);
      con.println("\n\n\n\n\n\n\n\n\n\n\n\n");
      con.print("	                   ");
      String strInput = con.readLine();
      drawStoryBoardPage(con, imgVal16);

      try {
        dblValue = Double.parseDouble(strInput);

        if (dblValue > dblMoney || dblValue == 0) {
          con.setTextColor(Color.WHITE);
          con.drawString("Value must be less than or equal to " + dblMoney + " and not equal to 0. Try again.", 550,
              650);
          con.repaint();
          con.sleep(2000);
          con.clear();
        }
      } catch (NumberFormatException e) {
        dblValue = 9999;
        con.setTextColor(Color.WHITE);
        con.drawString("Invalid input. Please enter a number.", 550, 650);
        con.repaint();
        con.sleep(2000);
        con.clear();
      }
    } while (dblValue > dblMoney || dblValue == 0);

    con.clear(); 
    con.drawImage(imgVal16, 0, 0); 
    con.setTextColor(Color.WHITE);
    con.drawString("$" + dblValue, 700, 650); 
    con.repaint();
    con.sleep(1000);
  }

  private static void showHighScores(Console con) {
    con.drawImage(imgScoreBoard, 0, 0);
    con.repaint();
    scoreBoardListInput = new TextInputFile("winners.txt");
    readScoresFromFileFinal(con);
    sortScores(con);
    displayScores(con);

    con.drawImage(imgBackButton, 1080, 520);
    con.repaint();
  }

  private static void displayScores(Console con) {
    Font fntFont2 = new Font("Courier New", Font.BOLD, 20);
    con.setDrawFont(fntFont2);

    for (int intI = 0; intI < Math.min(5, intScoreCount); intI++) {
      con.setDrawColor(Color.WHITE);
      con.drawString(strNames[intI] + ": " + dblScores[intI], 200, 180 + intI * 92);
      con.repaint();
    }
    for (int intI = 5; intI < Math.min(10, intScoreCount); intI++) {
      con.setDrawColor(Color.WHITE);
      con.drawString(strNames[intI] + ": " + dblScores[intI], 770, 180 + (intI - 5) * 92);
      con.repaint();
    }
  }


  private static void drawStoryBoardPage(Console con, BufferedImage imgImage) {
    con.drawImage(imgImage, 0, 0);
    con.drawImage(imgMoneyBoard, 0, 0);
    con.drawString("$" + String.valueOf(dblMoney), 1080, 50);
    con.repaint();
  }
  
  private static void drawStoryBoardPageWithSkipButton(Console con, BufferedImage imgImage) {
      con.drawImage(imgImage, 0, 0);
      con.drawImage(imgMoneyBoard, 0, 0);
      con.drawString("$" + String.valueOf(dblMoney), 1080, 50);
      con.drawImage(imgSkipButton, 20, 20);
      con.repaint();
      con.sleep(160);

      long startTime = System.currentTimeMillis();
      boolean blnClicked = false;

      
      if (!blnClicked) {
        int intKey = con.getKey();
        if (intKey == 10) { 
            return;
        }
      }
      con.sleep(160);
  }

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

    while (intX > 0) {
      intX -= intSPEED; 
      con.drawImage(miniStoryBoard, 0, 0);
      con.drawImage(imgMoneyBoard, 0, 0);
      con.drawString("$" + String.valueOf(dblMoney), 1080, 50);
      con.drawImage(imgVal_pix, intX, intY);
      con.drawImage(imgNico_pix, intNico_x, intNico_y);
      con.repaint();
      con.sleep(16); 
    }
  }

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

  private static void loading(Console con) {
    imgLoad = con.loadImage("images/loading.png");
    int intCounter;
    con.clear(); 
    con.setDrawColor(new Color(0, 0, 0)); 

    for (intCounter = 0; intCounter < 1280; intCounter += 4) {
      con.fillRect(0, 0, intCounter, 720);
      con.repaint();
      con.sleep(1);
    }

    for (int intI = intSTART_X; intI <= intEND_X; intI += 2) {
      con.clear();

      con.drawImage(imgLoad, 0, 0);

      con.setDrawColor(Color.WHITE);
      con.fillRect(intI, 530, intBAR_WIDTH, intBAR_HEIGHT);

      con.setDrawColor(Color.BLACK);
      con.drawRect(intSTART_X, 530, intEND_X - intSTART_X + intBAR_WIDTH, intBAR_HEIGHT);

      con.repaint();

      con.sleep(16); 
    }
    con.sleep(1000);
  }

  private static void loadingOutScreen(Console con) {
    imgexitmainpage = con.loadImage("images/ExitMainPage.png");
    int intCounter;
    con.clear();
    con.setDrawColor(new Color(0, 0, 0)); 

    for (intCounter = 0; intCounter < 1280; intCounter += 4) {
      con.fillRect(0, 0, intCounter, 720);
      con.repaint();
      con.sleep(1);
    }

    for (int intI = intSTART_X; intI <= intEND_X; intI += 2) {
      con.clear();

      con.drawImage(imgexitmainpage, 0, 0);

      con.setDrawColor(Color.WHITE);
      con.fillRect(intI, 600, intBAR_WIDTH, intBAR_HEIGHT);

      con.setDrawColor(Color.BLACK);
      con.drawRect(intSTART_X, 600, intEND_X - intSTART_X + intBAR_WIDTH, intBAR_HEIGHT);

      con.repaint();

      con.sleep(16); 
    }
    con.sleep(1000);
  }

  private static void animateButton(Console con, BufferedImage imgBackground, BufferedImage imgButton1,
      BufferedImage imgButton2, int intY) {
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


  private static void animateButton(Console con, BufferedImage imgBackground, BufferedImage imgButton1,
      BufferedImage imgButton2, BufferedImage imgButton3, int intY) {
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

  private static boolean isButtonClicked(Console con, int intX, int intY, int intWidth, int intHeight) {
    int intMouseX = con.currentMouseX();
    int intMouseY = con.currentMouseY();
    return con.currentMouseButton() == 1 && intMouseX >= intX && intMouseX <= (intX + intWidth) && intMouseY >= intY
        && intMouseY <= (intY + intHeight);
  }

  private static boolean playGame(Console con) {

    String[][] strDeck = new String[52][4];
    String[] strSuits = { "D", "C", "H", "S" };
    String[] strValues = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

    initializeDeck(strDeck, strSuits, strValues);
    shuffleDeck(strDeck);
    dealInitialCards(con, strDeck);
    drawScene(con);


    if (intPlayerTotal == 21) {
      determineWinner(con);
    }


    while (!blnGameEnded) {
      if (blnPlayerTurn) {
        if (isHitButtonClicked(con) && intPlayerTotal < 21) {
          hitCard(con, strDeck);
          if (intPlayerTotal > 21 || intPlayerCardCount == 5) {
            blnPlayerTurn = false;
            determineWinner(con);
          } else if (intPlayerTotal == 21) {
            blnPlayerTurn = false;
            dealerTurn(con, strDeck);
          }
        } else if (isStandButtonClicked(con)) {
          blnPlayerTurn = false;
          dealerTurn(con, strDeck);
        } else if (blnCanDoubleDown && isDoubleDownButtonClicked(con)) {
          doubleDown(con, strDeck);
          blnPlayerTurn = false;
          dealerTurn(con, strDeck);
        }
      }
      drawScene(con);
      con.sleep(10);
    }

    return askPlayAgain(con);
  }

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

  private static void shuffleDeck(String[][] strDeck) {
    for (int intI = strDeck.length - 1; intI > 0; intI--) {
      int intJ = (int) (Math.random() * (intI + 1));
      String[] strTemp = strDeck[intI];
      strDeck[intI] = strDeck[intJ];
      strDeck[intJ] = strTemp;
    }
  }

  private static void dealInitialCards(Console con, String[][] strDeck) {
    for (int intI = 0; intI < 2; intI++) {
      addCardToPlayer(con, strDeck[intCardIndex]);
      intCardIndex++;
      addCardToDealer(con, strDeck[intCardIndex]);
      intCardIndex++;
    }
    blnCanDoubleDown = (intPlayerTotal == 9 || intPlayerTotal == 10 || intPlayerTotal == 11);
  }

  private static void addCardToPlayer(Console con, String[] strCard) {
    imgPlayerCards[intPlayerCardCount][0] = loadCardImage(con, strCard[3]);
    strPlayerCardValues[intPlayerCardCount][0] = strCard[0];
    intPlayerCardCount++;
    intPlayerTotal = reCalculateTotal(strPlayerCardValues, intPlayerCardCount);
  }

  private static void addCardToDealer(Console con, String[] strCard) {
    imgDealerCards[intDealerCardCount][0] = loadCardImage(con, strCard[3]);
    strDealerCardValues[intDealerCardCount][0] = strCard[0];
    intDealerCardCount++;
    intDealerTotal = reCalculateTotal(strDealerCardValues, intDealerCardCount);
  }

  private static void hitCard(Console con, String[][] strDeck) {
    addCardToPlayer(con, strDeck[intCardIndex]);
    intCardIndex++;

    animateCardShuffle(con);
    blnCanDoubleDown = false;

  }

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

  private static void dealerTurn(Console con, String[][] strDeck) {
    drawScene(con);
    while (intDealerTotal < 17 || intDealerTotal < intPlayerTotal) {
      if (intDealerCardCount == 5) {
        break;

      }
      addCardToDealer(con, strDeck[intCardIndex]);
      intCardIndex++;

      drawScene(con);
      con.sleep(1000);
      intDealerCardCountForArray++;
      System.out.println(intDealerCardCount);
    }
    determineWinner(con);
  }

  private static void determineWinner(Console con) {
    if (intPlayerTotal > 21) { 
      con.sleep(2000);
      dblMoney = dblMoney - dblValue;
      con.drawImage(imgWinNico, 0, 0);
      con.repaint();
      con.sleep(2000);
      con.drawImage(imgAngryVal1, 0, 0);
      con.repaint();
      con.sleep(1000);
      con.drawImage(imgAngryVal2, 0, 0);
      con.repaint();
      con.sleep(1000);
      con.drawImage(imgAngryVal3, 0, 0);
      con.repaint();
      con.sleep(1000);
      con.drawImage(imgLose, 0, 0);
    } else if (intPlayerTotal == 21 && intPlayerCardCount == 2) { // blackjack
      con.sleep(2000);
      dblMoney = dblMoney + (2 * dblValue);
      con.drawImage(imgBlackjack, 0, 0);
      con.repaint();
      con.sleep(2000);
      con.drawImage(imgAngryNico1, 0, 0);
      con.repaint();
      con.sleep(1000);
      con.drawImage(imgAngryNico2, 0, 0);
      con.repaint();
      con.sleep(1000);
      con.drawImage(imgWin, 0, 0);
    } else if (intPlayerCardCount == 5) {
      dblMoney = dblMoney + (2 * dblValue);
      con.drawImage(imgCharlie, 0, 0);
      System.out.println("charlie rule");
      con.repaint();
      con.sleep(2000);
      con.drawImage(imgAngryNico1, 0, 0);
      con.repaint();
      con.sleep(1000);
      con.drawImage(imgAngryNico2, 0, 0);
      con.repaint();
      con.sleep(1000);
      con.drawImage(imgWin, 0, 0);
    } else if (intPlayerTotal == intDealerTotal) { 
      dblMoney = dblMoney;
      con.sleep(2000);
      con.drawImage(imgTie, 0, 0);
      con.repaint();
      con.sleep(2000);
      BufferedImage[] storyImages = {
      imgTie1, imgTie2
      };
      
      for (BufferedImage image : storyImages) {
          drawStoryBoardPageWithSkipButton(con, image);
      }
    } else if (intPlayerTotal > intDealerTotal || intDealerTotal > 21) { // player wins
      dblMoney = dblMoney + dblValue;
      con.drawImage(imgWinVal, 0, 0);
      con.repaint();
      con.sleep(2000);
      con.drawImage(imgAngryNico1, 0, 0);
      con.repaint();
      con.sleep(1000);
      con.drawImage(imgAngryNico2, 0, 0);
      con.repaint();
      con.sleep(1000);
      con.drawImage(imgWin, 0, 0);
    } else { 
      con.sleep(2000);
      dblMoney = dblMoney - dblValue;
      con.drawImage(imgWinNico, 0, 0);
      con.repaint();
      con.sleep(2000);
      con.drawImage(imgAngryVal1, 0, 0);
      con.repaint();
      con.sleep(1000);
      con.drawImage(imgAngryVal2, 0, 0);
      con.repaint();
      con.sleep(1000);
      con.drawImage(imgAngryVal3, 0, 0);
      con.repaint();
      con.sleep(1000);
      con.drawImage(imgLose, 0, 0);
    }
    con.repaint();
    con.sleep(2000);
    blnGameEnded = true;
    drawScene(con);
  }

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

  

  private static void displayPlayerCards(Console con) {
    int intTotalWidth = (intPlayerCardCount - 1) * (intCARD_WIDTH + intCARD_SPACING);
    int intStartX = 640 - intTotalWidth / 2;
    for (int intI = 0; intI < intPlayerCardCount; intI++) {
      con.drawImage(imgPlayerCards[intI][0], intStartX + intI * (intCARD_WIDTH + intCARD_SPACING), 450);
    }
  }

  private static void displayDealerCards(Console con) {
    con.drawImage(imgDealerCards[0][0], 500, 0);
    if (blnPlayerTurn) {
      con.drawImage(imgCardBack, 600, 0);
    } else {
      for (int intI = 1; intI < intDealerCardCount; intI++) {
        con.drawImage(imgDealerCards[intI][0], 500 + intI * (intCARD_WIDTH + intCARD_SPACING), 0);
      }
    }
  }

  private static BufferedImage loadCardImage(Console con, String strImagePath) {
    return con.loadImage(strImagePath);
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
    return con.currentMouseButton() == 1 && con.currentMouseX() >= 900 && con.currentMouseX() <= 1000
        && con.currentMouseY() >= 600 && con.currentMouseY() <= 650;
  }

  private static boolean isStandButtonClicked(Console con) {
    return con.currentMouseButton() == 1 && con.currentMouseX() >= 1020 && con.currentMouseX() <= 1120
        && con.currentMouseY() >= 600 && con.currentMouseY() <= 650;
  }

  private static boolean isDoubleDownButtonClicked(Console con) {
    return con.currentMouseButton() == 1 && con.currentMouseX() >= 1140 && con.currentMouseX() <= 1240
        && con.currentMouseY() >= 600 && con.currentMouseY() <= 650;
  }

  private static void doubleDown(Console con, String[][] strDeck) {
    dblValue = dblValue * 2;
    hitCard(con, strDeck);
    if (intPlayerTotal > 21) {
      determineWinner(con);
    }
  }

  private static void displayTotals(Console con) {
    con.setDrawColor(Color.WHITE);
    con.drawString("Player Total: " + intPlayerTotal, 10, 690);
    if (!blnPlayerTurn || blnGameEnded) {
      con.drawString("Dealer Total: " + intDealerTotal, 10, 670);
    }
  }

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
        String[] strArgs = new String[1];
        strArgs[0] = "repeat";
        main(strArgs);
        break; 
      }
    }
  }

  private static void readScoresFromFileFinal(Console con) {
    intScoreCount = 0;
    while (!scoreBoardListInput.eof() && intScoreCount < intMAX_SCORES) {
      strNames[intScoreCount] = scoreBoardListInput.readLine();
      dblScores[intScoreCount] = Double.parseDouble(scoreBoardListInput.readLine());
      intScoreCount++;
    }
    scoreBoardListInput.close();
  }

  private static void sortScores(Console con) {
    for (int intI = 0; intI < intScoreCount - 1; intI++) {
      for (int intJ = 0; intJ < intScoreCount - intI - 1; intJ++) {
        if (dblScores[intJ] < dblScores[intJ + 1]) {
          double dblTempScore = dblScores[intJ];
          dblScores[intJ] = dblScores[intJ + 1];
          dblScores[intJ + 1] = dblTempScore;
          String strTempName = strNames[intJ];
          strNames[intJ] = strNames[intJ + 1];
          strNames[intJ + 1] = strTempName;
        }
      }
    }
  }


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

  private static void searchUserAndPrintRank(Console con) {
    int intUserCount = 0;
    scoreBoardListInput = new TextInputFile("winners.txt");
    while (!scoreBoardListInput.eof()) {
      scoreBoardListInput.readLine(); 
      scoreBoardListInput.readLine();
      intUserCount++;
    }
    scoreBoardListInput.close();

    double[] dblAllMoney = new double[intUserCount];

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

    bubbleSortDescending(dblAllMoney);

    int intRank = 1;
    for (int intI = 0; intI < dblAllMoney.length; intI++) {
      if (dblAllMoney[intI] == dblUserMoney) {
        break;
      }
      intRank++;
    }

    con.drawString(String.valueOf(intRank), 500, 650);
  }

  private static void bubbleSortDescending(double[] dblArr) {
    int intN = dblArr.length;
    for (int intI = 0; intI < intN - 1; intI++) {
      for (int intJ = 0; intJ < intN - intI - 1; intJ++) {
        if (dblArr[intJ] < dblArr[intJ + 1]) {
          double dblTemp = dblArr[intJ];
          dblArr[intJ] = dblArr[intJ + 1];
          dblArr[intJ + 1] = dblTemp;
        }
      }
    }
  }

  private static boolean askPlayAgain(Console con) {
    if (dblMoney > 0) {
      con.clear();
      con.drawImage(imgValPlayAgain, 0, 0);

      while (true) {
        int intMouseX = con.currentMouseX();
        int intMouseY = con.currentMouseY();

        if (intMouseX >= 480 && intMouseX <= 700 && intMouseY >= 600 && intMouseY <= 650) {
          con.setDrawColor(Color.GREEN);
        } else {
          con.setDrawColor(Color.RED);
        }
        con.fillRect(480, 600, 220, 50);
        con.setDrawColor(Color.BLACK);
        con.drawRect(480, 600, 220, 50);
        con.drawString("Sure, let's play!", 490, 610);

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

        con.sleep(16);
      }
    } else {
      con.drawImage(imgNoMoney1, 0, 0);
      con.repaint();
      con.sleep(2000);
      con.drawImage(imgNoMoney2, 0, 0);
      con.repaint();
      con.sleep(2000);
      loadingOutScreen(con);
      System.out.println("Exiting");
      String[] strArgs = new String[1];
      strArgs[0] = "repeat";
      main(strArgs);
      return false;
    }
  }

  private static void drawGameScreen(Console con) {
    con.drawImage(imgVal16, 0, 0);
    con.drawImage(imgMoneyBoard, 0, 0);
    con.drawString("$" + dblMoney, 1080, 50);
    con.setTextColor(Color.WHITE);
    con.repaint();
  }

  private static boolean getValidBet(Console con) {
    do {
      con.setTextColor(Color.WHITE);
      con.setDrawColor(Color.WHITE);
      con.println("\n\n\n\n\n\n\n\n\n\n\n\n");
      con.print("	                      ");
      String strInput = con.readLine();
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

    con.clear();
    con.drawImage(imgVal16, 0, 0);
    con.setTextColor(Color.WHITE);
    con.drawString("$" + dblValue, 700, 650);
    con.repaint();
    con.sleep(1000);
    return true;
  }

  private static void displayErrorMessage(Console con, String strMessage) {
    drawGameScreen(con);
    con.setTextColor(Color.WHITE);
    con.drawString(strMessage, 550, 650);
    con.repaint();
    con.sleep(2000);
    con.clear();
    drawGameScreen(con);
  }

  private static void saveScore(String strUser, double dblMoney) {
    scoreBoardList.println(strUser);
    scoreBoardList.println(dblMoney);
  }

  private static void handleHelpButton(Console con) {
    BufferedImage[] imgHelpImages = {
        imgHelp1, imgHelp2, imgHelp3, imgHelp5,
        imgHelp6, imgHelp7, imgHelp8, imgHelp9, imgHelp10,
        imgHelp11, imgHelp12, imgHelp13, imgHelp14, imgHelp15
    };

    int intCurrentImageIndex = 0;


    while (intCurrentImageIndex < imgHelpImages.length) {
      con.clear();
      con.drawImage(imgHelpImages[intCurrentImageIndex], 0, 0);
      con.repaint();

      if (intCurrentImageIndex == 8) {
        con.setTextColor(Color.WHITE);
        con.repaint();
        String strInput = con.readLine();

        if (strInput.equals("13")) {
          intCurrentImageIndex = 11; 
          con.drawImage(imgHelp11, 0, 0);
          con.repaint();
          con.sleep(2000);
        } else {
          intCurrentImageIndex = 10; 
          con.sleep(1000);
        }
      } else {
        while (true) {
          int intKey = con.currentChar();
          if (intKey == 10) {
            System.out.println("Debug: currentImageIndex = " + intCurrentImageIndex); // Debug statement
            intCurrentImageIndex++;
            con.sleep(160);
            break;
          }
        }
      }

    }
  }

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