
public class teststuff {
	public static void main(String[] args) {
		
		String value = "087499704";
		
		if(value.matches("^0*[0-9]+")) {
			System.out.println("Valid");
		}
		else {
			System.out.println("Somethings fucked");
		}
	}
}
