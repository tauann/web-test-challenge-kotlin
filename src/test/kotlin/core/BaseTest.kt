package core

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.time.Duration

abstract class BaseTest {
    protected var driver: WebDriver? = null
        get() {
            if (field == null) {
                field = ChromeDriver()
                field!!.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
            }
            return field
        }

    companion object {
        init {
            WebDriverManager.chromedriver().setup()
        }
    }
}