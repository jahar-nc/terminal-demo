package foo;

public class Main {

	public static void main(String[] args) {
		String who;
		if (args.length == 0) {
			who = "world";
		} else {
			who = args[0];
		}
		System.out.println("Hello "+ who);
	}
}
