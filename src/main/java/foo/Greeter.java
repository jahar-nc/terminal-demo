package foo;

public class Greeter {

	public static final String DEFAULT_WHO = "world";

	public void greet() {
		greet(DEFAULT_WHO);
	}

	public void greet(String who) {
		System.out.println(makeGreeting(who));
	}

	public String makeGreeting(String who) {
		if (who == null) {
			who = DEFAULT_WHO;
		}
		return "hello " + who;
	}
}
