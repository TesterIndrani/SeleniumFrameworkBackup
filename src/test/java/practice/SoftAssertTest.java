package practice;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

	@Test
	public void createContact()
	{
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(false, true);
		System.out.println("step4");
		System.out.println("step5");
		soft.assertAll();
	}

	@Test
	public void m1()
	{
		String expData = "qspiders";
		String actData = "qspiders";
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(expData, actData);
		soft.assertAll();
		
	}
}
