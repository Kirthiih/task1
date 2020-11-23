package Task;

import java.util.Scanner;

public class Main {
	
	public static void main (String[] args) throws java.lang.Exception
	{
	Gettingdata readdata=new Gettingdata();
	readdata.readCSVfile();
	System.out.println("Maximum Temperature Date :"+ readdata.findMAXTempDate());
	Scanner scr=new Scanner(System.in);
	System.out.println("Enter Date from 2019-03-27 to 2019-03-31 in formate 'yyyy-mm-dd' :");
	String dateEntered= scr.nextLine();
	System.out.println("Maximum TempMin_TempMax_Humidity_weather :"+ readdata.findTempHumidityWeather(dateEntered));
	System.out.println("Raining  Dates :"+ readdata.findRainingDates());
	}

}
