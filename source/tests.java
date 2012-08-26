import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
 

@RunWith(value = Parameterized.class)
public class tests {
 
	 private String name;
 
	 public tests(String name) {
	    this.name = name;
	 }
 
	 @Parameters
	 public static Collection<Object[]> data() {
	   Object[][] data = new Object[][] { { "a" }, { "aa" }, { "aa " }, { "72wr6evw" } };
	   return Arrays.asList(data);
	 }
 
	 @Test (expected = IllegalArgumentException.class)
	 public void testBadClientNames() {
	   new Client(this.name);
	 }
 
 
}