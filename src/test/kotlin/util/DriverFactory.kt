package util

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver

class DriverFactory {
    var driver = ChromeDriver()

    companion object {
        init {
            WebDriverManager.chromedriver().setup()
        }
    }
}