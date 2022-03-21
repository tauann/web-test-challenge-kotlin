package driver

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxOptions
import util.Constants.Companion.HEADLESS

enum class DriverEnum : DriverInterface {
    FIREFOX {
        override fun create(): WebDriver {
            val options = FirefoxOptions()
            options.setHeadless(HEADLESS)
            return WebDriverManager.firefoxdriver().capabilities(options).create()
        }
    },
    CHROME {
        override fun create(): WebDriver {
            val options = ChromeOptions()
            options.setHeadless(HEADLESS)
            return WebDriverManager.chromedriver().capabilities(options).create()
        }
    }
}