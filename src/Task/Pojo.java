package Task;

public class Pojo {
	private String temp_min;
	private String temp_max;   
	private String humidity;
	private String main_weather;
	private String dt_txt;

	public String getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(String temp_max) {
		this.temp_max = temp_max;
	}
	public String getDt_txt() {
		return dt_txt;
	}
	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}
	public String getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(String temp_min) {
		this.temp_min = temp_min;
	}
	public String getMain_weather() {
		return main_weather;
	}
	public void setMain_weather(String main_weather) {
		this.main_weather = main_weather;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	@Override
	public String toString() {
		return "Pojo [temp_min=" + temp_min + ", temp_max=" + temp_max
				+ ", humidity=" + humidity + ", main_weather=" + main_weather
				+ ", dt_txt=" + dt_txt + "]";
	}

}
