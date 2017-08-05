package kr.co.redcore.util;

import java.util.Random;

public class UserRand {
	public static String randString(int size, int radix) {
		StringBuffer buf = new StringBuffer();
		
		for (int i = 0; i < size; i++) {
			buf.append(Integer.toString((int) (Math.random() * radix), radix));
		}
		
		return buf.toString();
	}
	
	public static String randomDecimal(int lenWidth, int seed) {
		int tmp = 0;
		int size = lenWidth;
		int i = 0;
		int[] buffer = new int[lenWidth];
		
		Random rnd = new Random(seed);		
		for (i = 0; i < lenWidth; i++) {
			buffer[i] = i;
		}
		
		for (i = 0; i < lenWidth; i++) {
			int des = rnd.nextInt(size);
			tmp = buffer[i];
			buffer[i] = buffer[des];
			buffer[des] = tmp;
		}
		
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < buffer.length; j++) {			
			sb.append(buffer[j]);
		}
		
		return sb.toString();
	}	
}