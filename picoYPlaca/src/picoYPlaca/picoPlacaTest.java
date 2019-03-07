package picoYPlaca;

import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.InputMismatchException;

public class picoPlacaTest {
	
	public static void main(String[] args) {

		int plate = 0;
		int dayOfWeek = 0;
		int hourOfDay = 0;
		int minute = 0;
		String status = "";

		//plate number
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your licence plate number: ");
		try {
			plate = getPlate(input.nextInt());
			System.out.println();
		} catch(InputMismatchException er){
			System.out.println("Number plate must be a number.");
			plate = -1;
		}

		//date
		
		input = new Scanner(System.in);
		System.out.print("Enter the date (dd/mm/yyyy): ");
		dayOfWeek = getDay(input.next());
		if (dayOfWeek != -1) {
			System.out.println();
		} else {
			System.out.println("The date must be (dd/mm/yyyy)");
		}

		//time
		input = new Scanner(System.in);
		System.out.print("Enter the time (hh:mm): ");
		int time[] = getTime(input.next());
		hourOfDay = time[0];
		minute = time[1];
		if (hourOfDay != -1 && minute != -1) {
			System.out.println();
		} else {
			System.out.println("The hour must be (hh:mm)");
		}

		//calculation for pico y placa
		status = getStatus(dayOfWeek, hourOfDay, minute, plate);
		System.out.println(status);
	}
	
	public static int getPlate(int value) {
		int plat = (value % 10);
		return plat;
	}
	
	public static int getDay(String value) {
		int dayWeek;
		String dateStr = value;
		Calendar c = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = format.format(new Date());
		try {
			Date date = format.parse(dateStr);
			c.setTime(date);
			dayWeek = c.get(Calendar.DAY_OF_WEEK);
		} catch(ParseException ex) {
			dayWeek = -1;
		}
		return dayWeek;
	}
	
	public static int[] getTime(String value) {
		int hour;
		int min;
		String timeStr = value;
		Calendar c = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		String timeString = format.format(new Date());
		try {
			Date time = format.parse(timeStr);
			c.setTime(time);
			hour = c.get(Calendar.HOUR_OF_DAY);
			min = c.get(Calendar.MINUTE);
		} catch(ParseException e) {
			hour = -1;
			min = -1;
		}
		return new int[] {hour, min};
	}
	
	public static String getStatus(int day, int hour, int min, int plat) {
		String stat = "";
		if (day != -1 && hour != -1 && min != -1 && plat != -1) {
			if (day != 1 && day != 7) {
				if (hour < 7 || hour > 19) {
					stat = "Car can be on the road";
				} else if (hour > 9 && hour < 16) {
					stat = "Car can be on the road";
				} else if (hour == 9 && min > 30) {
					stat = "Car can be on the road";
				} else if (hour == 19 && min > 30) {
					stat = "Car can be on the road";
				} else {
					if ((((day-1)*2)-plat) == 0 || (((day-1)*2)-plat) == 1 || (((day-1)*2)-plat) == 10) {
						stat = "Car can NOT be on the road";
					} else {
						stat = "Car can be on the road";
					}
				}
			} else {
				stat = "Car can be on the road";
			}
		} else {
			stat = "Wrong parameters.";
		}
		return stat;
	}

}
