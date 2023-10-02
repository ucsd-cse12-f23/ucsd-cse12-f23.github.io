import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestJUnit {

	@Test
	public void testQuestion1() {
		//assertEquals(true, false);
		helper();
		otherHelper();
		System.out.println("test passed");
	}
	
	private void helper() {
		
	}
	
	public void otherHelper() {
		
	}

	public static int sumNumbers(String str) {
		if (str == null || str.length() == 0) return 0;
		int result = 0;
		int i = 0;
		int size = str.length();
		
		String tmp = "";
		boolean notNull = false;
		boolean run = false;
		
		while (i < size) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				tmp += str.charAt(i);		
				notNull = true;
				if (i != size - 1)
					run = true;
				else {
					run = false;
				}
			}
			else {
				run = false;
			}
			if (!run && tmp != ""){
				result += Integer.parseInt(tmp);
				tmp = "";
			}
			i++;
		}
		return result;
	}

}
