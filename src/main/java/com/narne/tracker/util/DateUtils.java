package com.narne.tracker.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static Date stringToDate(String dateInString) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = null ;
        try {

            date = formatter.parse(dateInString);
           

        } catch (ParseException e) {
            e.printStackTrace();
        }
		return date;
	}

}
