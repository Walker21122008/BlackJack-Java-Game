import arc.*;

public class testingthisagain {

    public static void main(String[] args) {
        // Create a console window
        Console con = new Console("array lol", 1280, 720);
        String strArray[][];
        TextInputFile reading = new TextInputFile("winners.txt");
        String strName;
        String strScore;
        int intValue = 0;
        while (reading.eof() == false){
			strName = reading.readLine();
			strScore = reading.readLine();
			intValue+=1;
		}
		reading.close();
		TextInputFile reading2 = new TextInputFile("winners.txt");
		strArray = new String[intValue][2];
		for(int intRow = 0; intRow < intValue; intRow++){
			strArray[intRow][0] = reading2.readLine();
			strArray[intRow][1] = reading2.readLine();
			con.println(strArray[intRow][0] + "-->" + strArray[intRow][1]);
		}

        
    }

}

