package base

import driver.DriverFactory
import org.apache.commons.io.FileUtils
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInfo
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import util.Constants.Companion.SCREENSHOTS_PATH
import util.Constants.Companion.TIMEOUT
import util.Constants.Companion.URL
import java.io.File


abstract class BaseTest {
    protected var driver = DriverFactory().driver

    @BeforeEach
    fun setup() {
        driver.manage().window().maximize()
        driver.manage().timeouts().implicitlyWait(TIMEOUT)
        driver.get(URL)
    }

    @AfterEach
    fun tearDown(testInfo: TestInfo) {
        screenshot(testInfo)
        driver.quit()
    }

    private fun screenshot(testInfo: TestInfo) {
        val sourceFile = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
        val outputFile = File("$SCREENSHOTS_PATH${testInfo.displayName}.png")
        FileUtils.copyFile(sourceFile, outputFile)
    }
}