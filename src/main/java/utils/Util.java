package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Util {


	public static String getStringAleatoria() {
		//Tamanho da String
		int length = 5;
		boolean useLetters = true;
		boolean useNumbers = false;
		return RandomStringUtils.random(length, useLetters, useNumbers);

	}
}
