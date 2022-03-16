package driver

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class DriverFactory {
    var driver: WebDriver = ChromeDriver()

    companion object {
        init {
            WebDriverManager.chromedriver().setup()
        }
    }
}