package page

import utils.BasePage
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
    private lateinit var addSuccessMessage: WebElement

    @FindBy(linkText = "Go back to list")
    private lateinit var goBackToList: WebElement

    fun writeCustomerName(text: String): AddCustomerPage {
        customerName.sendKeys(text)
        return this
    }

    fun writeContactLastName(text: String): AddCustomerPage {
        contactLastName.sendKeys(text)
        return this
    }

    fun writeContactFirstName(text: String): AddCustomerPage {
        contactFirstName.sendKeys(text)
        return this
    }

    fun writePhone(text: String): AddCustomerPage {
        phone.sendKeys(text)
        return this
    }

    fun writeAdressLine1(text: String): AddCustomerPage {
        addressLine1.sendKeys(text)
        return this
    }

    fun writeAddressLine2(text: String): AddCustomerPage {
        addressLine2.sendKeys(text)
        return this
    }

    fun writeCity(text: String): AddCustomerPage {
        city.sendKeys(text)
        return this
    }

    fun writeState(text: String): AddCustomerPage {
        state.sendKeys(text)
        return this
    }

    fun writePostalCode(text: String): AddCustomerPage {
        postalCode.sendKeys(text)
        return this
    }

    fun writeCountry(text: String): AddCustomerPage {
        country.sendKeys(text)
        return this
    }

    fun writeSalesRepEmployeeNumber(text: String): AddCustomerPage {
        salesRepEmployeeNumber.sendKeys(text)
        return this
    }

    fun writeCreditLimit(text: String): AddCustomerPage {
        creditLimit.sendKeys(text)
        return this
    }

    fun clickSave(): AddCustomerPage {
        save.click()
        return this
    }

    fun getAddSuccessMessage(): String = waitVisibilityOfElement(addSuccessMessage).text

    fun clickGoBackToList() = goBackToList.click()
}