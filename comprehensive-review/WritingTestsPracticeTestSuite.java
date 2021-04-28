import static org.junit.jupiter.api.Assertions.*; //seems like junit is the thing that gives us things like assert methods that allow us to test our code 

class WritingTestsPracticeTestSuite { //no need to think too hard about tests... it really all comes down to one thing..... checking if the result you got was what you expected

	@Test 
	void gettersTest() {
		WritingTestsPractice instance = new WritingTestsPractice();
		assertEquals(0, instance.getI());
		assertEquals("", instance.getSomeString());
		//format: assertEquals(expected, actual)
	}

	@Test 
	void settersTest() {
		WritingTestsPractice instance = new WritingTestsPractice(); 
		instance.setI(100); 
		assertEquals(100, instance.getI());
		instance.setSomeString("Yordle");
		assertEquals("YODLEEE", instance.getSomeString()); //this test would fail.... because these two are not equal... BTW when we run a particular method in a test suite what happens is it tries to run all the code inside.... and if any line of code fails / errors..... then that particular method / test fails 
	}
}