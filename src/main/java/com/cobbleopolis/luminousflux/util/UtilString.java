package com.cobbleopolis.luminousflux.util;

import java.text.NumberFormat;
import java.util.Locale;

public class UtilString {

	public static String formatIntWithCommas(int num){
		return NumberFormat.getNumberInstance(Locale.US).format(num);
	}
}
