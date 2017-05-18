import org.junit.Test;
import static org.junit.Assert.*;

public class LISNumberDivTwoTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] seq = new int[] {1, 4, 4, 2, 6, 3};
		assertEquals(4, new LISNumberDivTwo().calculate(seq));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] seq = new int[] {5, 8, 9, 12, 16, 32, 50};
		assertEquals(1, new LISNumberDivTwo().calculate(seq));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] seq = new int[] {1, 1, 9, 9, 2, 2, 3, 3};
		assertEquals(6, new LISNumberDivTwo().calculate(seq));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] seq = new int[] {50, 40, 30, 20, 10};
		assertEquals(5, new LISNumberDivTwo().calculate(seq));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] seq = new int[] {42};
		assertEquals(1, new LISNumberDivTwo().calculate(seq));
	}
}
