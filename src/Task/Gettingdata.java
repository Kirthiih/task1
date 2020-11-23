package Task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Gettingdata {

	private List<Pojo> strList = new ArrayList<>();
	String row;

	public void readCSVfile() {

		BufferedReader br;
		String path = "data.csv";

		try {
			br = new BufferedReader(new FileReader(new File(path)));
			try {
				int iteration = 0;
				while ((row = br.readLine()) != null) {
					if (iteration == 0) {
						iteration++;
						continue;
					}
					setValuesFromCSV(row);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setValuesFromCSV(String roweach) {
		Pojo modelpojo = new Pojo();
		String[] csvArray = row.split(",");
		modelpojo.setTemp_min(csvArray[5]);
		modelpojo.setTemp_max(csvArray[6]);
		modelpojo.setHumidity(csvArray[10]);
		modelpojo.setMain_weather(csvArray[13]);
		modelpojo.setDt_txt(csvArray[20]);
		strList.add(modelpojo);
	}

	public String findMAXTempDate() throws ParseException {

		double num = 0.0;
		String date = null;
		for (Pojo str : getStrList()) {
			String temp = str.getTemp_max().toString();
			String str1 = temp.replace("\"", "");
			double maxtemp = Double.parseDouble(str1);
			String dat = str.getDt_txt().toString();
			if (maxtemp > num) {
				num = maxtemp;
				date = dat.replace("\"", "");
			}
		}
		return date;
	}

	public List<String> findTempHumidityWeather(String dateGiven) throws ParseException {
		// 5,6,10,13

		String samdate = dateGiven;//"2019-03-27";
		double num = 0.0;
		List<String> temphumiweat = new ArrayList<>();

		String date = null;
		for (Pojo str : getStrList()) {
			
			String tempmin = str.getTemp_min().toString();
			String temp_min = tempmin.replace("\"", "");
			String tempmax = str.getTemp_max().toString();
			String temp_max = tempmax.replace("\"", "");
			String humidit = str.getHumidity().toString();
			String humidity = humidit.replace("\"", "");
			String weater = str.getMain_weather().toString();
			String weather = weater.replace("\"", "");
			String dat = str.getDt_txt().toString();
			date = dat.replace("\"", "");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date daateCSV = formatter.parse(date);
			Date daateIP = formatter.parse(samdate);
			if (daateCSV.compareTo(daateIP) == 0) {
				temphumiweat.add(temp_min);
				temphumiweat.add(temp_max);
				temphumiweat.add(humidity);
				temphumiweat.add(weather);
			}

		}
		boolean testlist= temphumiweat.isEmpty();
		if(testlist==true){
			System.out.println("Data is not available for given Date");
		}
		return temphumiweat;
		


	}

	
	  public List<String> findRainingDates() {
		  
			List<String> rainDates = new ArrayList<>();
			String date;
			for (Pojo str : getStrList()) {
				String mainWeather = str.getMain_weather().toString();
				String mainWeater = mainWeather.replace("\"", "");
				String dat = str.getDt_txt().toString();
				date = dat.replace("\"", "");
				String cmp="Rain";
					if ( mainWeater.equals(cmp)) {
						
						rainDates.add(date);
					}

				}
			
		  return rainDates;

	  }
	 
	/*
	 * Return day which had the maximum temperature 
	 * For a given date return
	 * temp_min temp_max humidity main under weather 
	 * Return a list of dates when it will rain
	 */

	/*
	 * message cnt list_dt list_main_temp list_main_temp_min 5
	 * list_main_temp_max 6 list_main_pressure 7 list_main_sea_level 8
	 * list_main_grnd_level list_main_humidity 10 list_main_temp_kf  11 list_main_id   12
	 * list_weather_main 13 list_weather_description list_weather_icon
	 * list_clouds_all list_wind_speed list_wind_deg list_sys_pod list_dt_txt 20
	 * city__id 21 city__name 22 city__coord__lat 23 city__coord__lon 24
	 * city__country 25 city__population 26 list__rain__1h 27
	 */

	public List<Pojo> getStrList() {
		return strList;
	}

	public void setStrList(List<Pojo> strList) {
		this.strList = strList;
	}

}
