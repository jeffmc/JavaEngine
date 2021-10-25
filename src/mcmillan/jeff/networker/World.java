package mcmillan.jeff.networker;

public class World {
	
	// for now, don't use dimensions greater than double-digit in either dimension
	public static void printMap(int w, int h) {
		System.out.print("   ");
		for (int x=0;x<w;x++) {
			System.out.print(x + (x < 10 ? "   " : "  "));
		}
		System.out.print("\n");
		
		for (int y=0;y<h;y++) {
			System.out.print((y < 10 ? " " : "") + y + " ");
			for (int x=0;x<w;x++) {
				System.out.print("["+Util.getRandomLetter()+"] ");
			}
			System.out.print("\n");
		}
	}

}
