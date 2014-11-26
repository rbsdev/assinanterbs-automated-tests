
/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

driver = {
  // System.setProperty('webdriver.chrome.driver', 'D:/development/drivers_at/chromedriver_win32/chromedriver.exe')
  // new ChromeDriver()
  new FirefoxDriver()
}

//baseUrl = "http://localhost:1200"
baseUrl = "http://www.assinanterbs-hlg.rbs.com.br"
