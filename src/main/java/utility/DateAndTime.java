package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {
	public static String getDateAndTime() {
		LocalDateTime time=LocalDateTime.now();
		DateTimeFormatter type= DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
		String datetime=time.format(type);
		return datetime;	
	}

}
