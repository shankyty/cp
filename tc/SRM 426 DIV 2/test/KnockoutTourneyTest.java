import org.junit.Test;
import static org.junit.Assert.*;

public class KnockoutTourneyTest {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 16;
		int you = 1;
		int rival = 2;
		assertEquals(1, new KnockoutTourney().meetRival(N, you, rival));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 16;
		int you = 8;
		int rival = 9;
		assertEquals(4, new KnockoutTourney().meetRival(N, you, rival));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 1000;
		int you = 20;
		int rival = 31;
		assertEquals(4, new KnockoutTourney().meetRival(N, you, rival));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int N = 65536;
		int you = 1000;
		int rival = 35000;
		assertEquals(16, new KnockoutTourney().meetRival(N, you, rival));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int N = 60000;
		int you = 101;
		int rival = 891;
		assertEquals(10, new KnockoutTourney().meetRival(N, you, rival));
	}
}
