package utils

import driver.DriverFactory
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import utils.Constants.Companion.TIMEOUT

abstract class BaseTest {
    protected var driver: WebDriver = DriverFactory().driver

    @BeforeEach
    fun setup() {
        driver.manage().timeouts().implicitlyWait(TIMEOUT)
        driver.get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap")
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}