package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {

/*	@Test
	public void createContact()
	{
		System.out.println("step1");
		System.out.println("step2");
		Assert.assertEquals(false, true);
		System.out.println("step3");
		System.out.println("step4");
	}
	@Test
	public void deleteContact()
	{
		System.out.println("step5");
		System.out.println("step6");
	}
*/
	@Test
	public void m1()
	{
		String expData = "qspiders";
		String actData = "qspiders";
		Assert.assertEquals(expData, actData);
	}
	
}
