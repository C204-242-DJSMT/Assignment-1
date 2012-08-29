import java.util.*;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
 

@RunWith(value = Parameterized.class)
public class tests {
 
	 private String name;
	 String[] address = {"10 example street", "1234", "Hamilton"};
	 ArrayList<String[]> addresses = new ArrayList<String[]>();
 
	 public tests(String name) {
	    this.name = name;
	    addresses.add(address);
	 }
 
	 @Parameters
	 public static Collection<Object[]> data() {
	   Object[][] data = new Object[][] { 
	   	{ "a" }, 
	   	{ "aa" }, 
	   	{ "aa " }, 
	   	{ "72wr6evw" } 
	   };
	   return Arrays.asList(data);
	 }
 
	 @Test (expected = IllegalArgumentException.class)
	 public void testBadClientNames() {
	   new Client(this.name, addresses);
	 }
 
 
}