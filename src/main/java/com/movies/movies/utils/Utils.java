package com.movies.movies.utils;

import java.util.Calendar;
import java.util.Date;

public class Utils {

	public static Date menosAnios(int anio)
	{
		final Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -anio);
		final Date anios = calendar.getTime();
		return anios;
	}
	
}
