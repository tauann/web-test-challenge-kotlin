package page

import util.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.Select

class ListPage(driver: WebDriver) : BasePage(driver) {
    @FindBy(id = "switch-version-select")
    private lateinit var switchTheme: WebElement

    @FindBy(partialLinkText = "Add Record")
    private lateinit var addRecord: WebElement

    @FindBy(name = "customerName")
    private lateinit var customerName: WebElement

    @FindBy(className = "clear-search")
    private lateinit var clearSearch: WebElement

    @FindBy(className = "select-all-none")
    private lateinit var selectAll: WebElement

    @FindBy(linkText = "Delete")
    private lateinit var deleteAll: WebElement

    @FindBy(css = "div.delete-multiple-confirmation.modal.fade.in.show div.modal-body")
    private lateinit var deleteAlertText: WebElement

    @FindBy(className = "delete-multiple-confirmation-button")
    private lateinit var deleteAlertDelete: WebElement

    @FindBy(css = "span[data-growl='message']")
    private lateinit var deleteSuccessMessage: WebElement

    fun switchTheme(text: String): ListPage {
        Select(switchTheme).selectByVisibleText(text)
        return this
    }

    fun addRecord() = addRecord.click()

    fun searchCustomerName(text: String): ListPage {
        customerName.sendKeys(text)
        waitVisibilityOfElement(clearSearch)
        return this
    }

    fun selectAll(): ListPage {
        selectAll.click()
        return this
    }

    fun deleteAll(): ListPage {
        deleteAll.click()
        return this
    }

    fun deleteAlertText(): String = waitVisibilityOfElement(deleteAlertText).text

    fun deleleAlertDelete(): ListPage {
        deleteAlertDelete.click()
        return this
    }

    fun deleteSuccessMessage(): String = waitVisibilityOfElement(deleteSuccessMessage).text
}
