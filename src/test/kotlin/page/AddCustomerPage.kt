package page

import base.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class AddCustomerPage(driver: WebDriver) : BasePage(driver) {
    @FindBy(id = "field-customerName")
    private lateinit var customerName: WebElement

    @FindBy(id = "field-contactLastName")
    private lateinit var contactLastName: WebElement

    @FindBy(id = "field-contactFirstName")
    private lateinit var contactFirstName: WebElement

    @FindBy(id = "field-phone")
    private lateinit var phone: WebElement

    @FindBy(id = "field-addressLine1")
    private lateinit var addressLine1: WebElement

    @FindBy(id = "field-addressLine2")
    private lateinit var addressLine2: WebElement

    @FindBy(id = "field-city")
    private lateinit var city: WebElement

    @FindBy(id = "field-state")
    private lateinit var state: WebElement

    @FindBy(id = "field-postalCode")
    private lateinit var postalCode: WebElement

    @FindBy(id = "field-country")
    private lateinit var country: WebElement

    @FindBy(id = "field-salesRepEmployeeNumber")
    private lateinit var salesRepEmployeeNumber: WebElement

    @FindBy(id = "field-creditLimit")
    private lateinit var creditLimit: WebElement

    @FindBy(id = "form-button-save")
    private lateinit var save: WebElement

    @FindBy(id = "report-success")
    private lateinit var saveSuccess: WebElement

    @FindBy(linkText = "Go back to list")
    private lateinit var goBackToList: WebElement

    fun customerName(text: String): AddCustomerPage {
        customerName.sendKeys(text)
        return this
    }

    fun contactLastName(text: String): AddCustomerPage {
        contactLastName.sendKeys(text)
        return this
    }

    fun contactFirstName(text: String): AddCustomerPage {
        contactFirstName.sendKeys(text)
        return this
    }

    fun phone(text: String): AddCustomerPage {
        phone.sendKeys(text)
        return this
    }

    fun adressLine1(text: String): AddCustomerPage {
        addressLine1.sendKeys(text)
        return this
    }

    fun addressLine2(text: String): AddCustomerPage {
        addressLine2.sendKeys(text)
        return this
    }

    fun city(text: String): AddCustomerPage {
        city.sendKeys(text)
        return this
    }

    fun state(text: String): AddCustomerPage {
        state.sendKeys(text)
        return this
    }

    fun postalCode(text: String): AddCustomerPage {
        postalCode.sendKeys(text)
        return this
    }

    fun country(text: String): AddCustomerPage {
        country.sendKeys(text)
        return this
    }

    fun salesRepEmployeeNumber(text: String): AddCustomerPage {
        salesRepEmployeeNumber.sendKeys(text)
        return this
    }

    fun creditLimit(text: String): AddCustomerPage {
        creditLimit.sendKeys(text)
        return this
    }

    fun save(): AddCustomerPage {
        save.click()
        return this
    }

    fun saveMessage(): String = waitVisibilityOfElement(saveSuccess).text

    fun goBackToList() = goBackToList.click()
}