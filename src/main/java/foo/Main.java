package foo;

public class Main {

	public static void main(String[] args) {
		if (args.length == 0) {
			new Greeter().greet();
		} else {
			new Greeter().greet(args[0]);
		}
	}
}
