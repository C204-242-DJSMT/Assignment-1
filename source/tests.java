@org.junit.Test(expected=IllegalArgumentException.class) public void testBadClientNames() {
	new Client("hello")
}

@org.junit.Test
public void testGoodClientNames() {
	new Client("hello world")
}