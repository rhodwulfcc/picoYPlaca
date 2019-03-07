package picoYPlaca;

import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.util.InputMismatchException;

public class picoPlaca {

	public static void main(String[] args) {

		int plate = 0;
		int dayOfWeek = 0;
		int hourOfDay = 0;
		int minute = 0;

		Scanner input = new Scanner(System.in);

		//plate number
		while (true) {
			System.out.print("Enter your licence plate number: ");
			try {
				plate = (input.nextInt() % 10);
				System.out.println();
				break;
			} catch(InputMismatchException er){
				System.out.println("Number plate must be a number.");
				input.next();
			}
		}

		//date
		while (true) {
			System.out.print("Enter the date (dd/mm/yyyy): ");
			try {
				String dateStr = input.next();
				Calendar c = Calendar.getInstance();
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				String dateString = format.format(new Date());
				Date date = format.parse(dateStr);
				c.setTime(date);
				dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
				System.out.println();
				break;
			} catch(ParseException ex) {
				System.out.println("The date must be (dd/mm/yyyy)");
			}
		}

		//time
		while (true) {
			System.out.print("Enter the time (hh:mm): ");
			try {
				String timeStr = input.next();
				Calendar c2 = Calendar.getInstance();
				SimpleDateFormat format2 = new SimpleDateFormat("HH:mm");
				String timeString = format2.format(new Date());
				Date time = format2.parse(timeStr);
				c2.setTime(time);
				hourOfDay = c2.get(Calendar.HOUR_OF_DAY);
				minute = c2.get(Calendar.MINUTE);
				System.out.println();
				break;
			} catch(ParseException e) {
				System.out.println("The hour must be (hh:mm)");
			}
		}

		//calculation for pico y placa
		if (dayOfWeek != 1 && dayOfWeek != 7) {
			if (hourOfDay < 7 || hourOfDay > 19) {
				System.out.println("Car can be on the road");
			} else if (hourOfDay > 9 && hourOfDay < 16) {
				System.out.println("Car can be on the road");
			} else if (hourOfDay == 9 && minute > 30) {
				System.out.println("Car can be on the road");
			} else if (hourOfDay == 19 && minute > 30) {
				System.out.println("Car can be on the road");
			} else {
				if ((((dayOfWeek-1)*2)-plate) == 0 || (((dayOfWeek-1)*2)-plate) == 1 || (((dayOfWeek-1)*2)-plate) == 10) {
					System.out.println("Car can NOT be on the road");
				} else {
					System.out.println("Car can be on the road");
				}
			}
		} else {
			System.out.println("Car can be on the road");
		}
	}
}