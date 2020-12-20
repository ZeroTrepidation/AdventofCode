
public class teststuff {
	public static void main(String[] args) {
		
		String value = "#1234aAb43c4";
		
		if(value.matches("^#{1}[a-fA-F0-9]+")) {
			System.out.println("Valid");
		}
		else {
			System.out.println("Somethings fucked");
		}
	}
}
