package utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf
import org.openqa.selenium.support.ui.WebDriverWait

@Suppress("LeakingThis")
abstract class BasePage(driver: WebDriver) {
    private var wait: WebDriverWait

    init {
        PageFactory.initElements(driver, this)
        wait = WebDriverWait(driver, Constants.TIMEOUT)
    }

    fun waitVisibilityOfElement(element: WebElement): WebElement = wait.until(visibilityOf(element))
}