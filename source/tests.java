import org.junit.Test;
import java.util.ArrayList;
//import static org.junit.Assert.*;

public class tests {
	@Test(expected=IllegalArgumentException.class)
	public void testBadClientNames() {
		new Client("aaaaa");
	}

	@Test
	public void testGoodClientNames() {
		new Client("duncan willcock");
	}
}