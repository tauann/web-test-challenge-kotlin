package page

import core.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class AddCustomerPage (driver: WebDriver) : BasePage(driver) {

    @FindBy( id = "field-customerName")
    private lateinit var customerName: WebElement

    @FindBy( id = "field-field-contactLastName")
    private lateinit var contactLastName: WebElement

    fun writeCustomerName(text: String): AddCustomerPage {
        customerName.sendKeys(text)
        return this
    }
    fun writeContactLastName(text: String): AddCustomerPage {
        contactLastName.sendKeys(text)
        return this
    }
}