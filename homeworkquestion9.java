import arc.*;
public class homeworkquestion9{
	public static void main(String[] args){
		Console con = new Console();
        // User inputs the celcius value
        con.println("Enter the Celsius value: ");
        double dblCelcius;//celcius variable
        dblCelcius = con.readDouble();

        // Converting Celcius to Fahrenheit
        double dblFahrenheit; //Fahrenheit variable
        dblFahrenheit = (dblCelcius * (9.0/5.0)) + 32;

        // Displaying the result
        con.println(dblCelcius + "°C is equal to " + dblFahrenheit + "°F");
    }

}
