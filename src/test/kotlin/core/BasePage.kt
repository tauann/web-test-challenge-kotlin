package core

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

abstract class BasePage(driver: WebDriver) {

    init {
        PageFactory.initElements(driver, this)
    }
}