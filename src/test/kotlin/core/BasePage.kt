package core

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

abstract class BasePage(driver: WebDriver) {
    private var wait: WebDriverWait

    init {
        PageFactory.initElements(driver, this)
        wait = WebDriverWait(driver, Duration.ofSeconds(10))
    }

    fun waitVisibilityOfElement(element: WebElement): WebElement = wait.until(visibilityOf(element))

}