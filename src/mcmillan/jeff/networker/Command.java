package mcmillan.jeff.networker;

import java.util.Arrays;

public class Command {

	public static void InputToDispatch(String in) {
		String[] strs = in.split("\\s+");
		String[] args = strs.length > 1 ? Arrays.copyOfRange(strs, 1, strs.length) : new String[0];
		DispatchCommand(strs[0], args);
	}
	
	public static void DispatchCommand(String cmd, String[] args) {
		
		cmd = cmd.toLowerCase();
		switch (cmd) {
		
		case "exit":
			System.exit(0); 
			break;
			
		case "clear":
			Util.clear();
			break;
			
		case "print":
		case "echo":
			if (args.length > 0) System.out.println(args[0]); else System.out.println();;
			break;
			
		default:
			System.err.println("'" + cmd +"' unrecognized command!");
			break;
			
		}
	}
}
