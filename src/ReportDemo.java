import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ReportDemo
	{
		public ExtentReports report;
		public ExtentTest test;

		@BeforeSuite
		public void beforeSuite()
			{
				report = new ExtentReports("./report/report.html");
			}

		@BeforeMethod
		public void beforeMethod(Method method)
			{
				test = report.startTest(method.getName());
			}

		@Test
		public void login()
			{

			}

		@Test
		public void logout()
			{
				Assert.fail();
			}

		@AfterMethod
		public void afterMethod(ITestResult result)
			{
				if (result.getStatus() == result.SUCCESS)
					{
						test.log(LogStatus.PASS, "passed");
					} else
					{
						test.log(LogStatus.FAIL, "passed");
					}
				report.endTest(test);
			}

		@AfterSuite
		public void afterSuite()
			{
				report.flush();
			}

	}
