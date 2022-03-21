package driver

import org.openqa.selenium.WebDriver

interface DriverInterface {

    fun create(): WebDriver
}
