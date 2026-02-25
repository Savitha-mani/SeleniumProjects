package org.com.projects.SeleniumProjects.project1;

import java.time.Duration;
import java.util.HashMap;

import javax.sound.sampled.TargetDataLine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginLogout {
	
	@Test(dataProvider = "getData")
	public void loginTest(HashMap<String, String> input) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		options.setExperimentalOption("excludeSwitches", new String[]{"disable-popup-blocking"});
		WebDriver driver=new ChromeDriver(options);
		String email=input.get("email");
		String password=input.get("password");
		driver.get("https://www.edureka.co/");
		driver.manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement login=driver.findElement(By.xpath("//button[text()='Log in']"));
		login.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginFormEmail")));
		WebElement loginEmail=driver.findElement(By.id("loginFormEmail"));
		
		loginEmail.clear();
		loginEmail.sendKeys(email);
		WebElement loginPassword=driver.findElement(By.id("loginPassword"));
		loginPassword.clear();
		loginPassword.sendKeys(password);
		WebElement loginBtn=driver.findElement(By.xpath("//button[text()='LOG IN']"));
		loginBtn.click();
		
		
	}
	
	@DataProvider
	
	public Object[][] getData() {
		HashMap<Object, Object> map=new HashMap<>();
		map.put("email", "savitha.mani@yahoo.com");
		map.put("password","Edu!2345" );
		HashMap<Object, Object> map1=new HashMap<>();
		map1.put("email", "savith1a.mani@yahoo.com");
		map1.put("password","Edu!2345" );
		return new Object[][] {
			{map},{map1}
			};
	}

}
