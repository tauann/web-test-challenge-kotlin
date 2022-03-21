package driver

import org.openqa.selenium.WebDriver
import util.Constants.Companion.BROWSERNAME

class DriverFactory {
    val driver: WebDriver
        get() =
            DriverEnum.valueOf(BROWSERNAME).create()
}