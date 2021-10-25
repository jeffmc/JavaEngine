package mcmillan.jeff.networker;

import java.util.Random;
import java.util.Scanner;

public class Util {

	public static Random rand;
	public static Scanner scanner;
	
	public static void init() {
		rand = new Random();
		scanner = new Scanner(System.in);
	}
	
	public static void close() {
		scanner.close();
	}
	
	public static char getRandomLetter() {
		return "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ".charAt(rand.nextInt(53));
	}
	
	public static String readLine() {
		return scanner.nextLine();
	}
	
	// https://stackoverflow.com/questions/2979383/how-to-clear-the-console
    public static void clear(String... arg) {
    	System.out.println("\nCLEAR SCREEN\n");
        try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	System.out.println("\n\n");
    }
}
