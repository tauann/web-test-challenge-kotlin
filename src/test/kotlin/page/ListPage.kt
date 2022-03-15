package page

import core.BasePage
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
    private lateinit var actionsRadioAll: WebElement

    @FindBy(linkText = "Delete")
    private lateinit var actionsDelete: WebElement

    @FindBy(className = "alert-delete-multiple-one")
    private lateinit var deleteAlertText: WebElement

    @FindBy(className = "delete-multiple-confirmation-button")
    private lateinit var deleteAlertDelete: WebElement

    @FindBy(css = "span[data-growl='message']")
    private lateinit var deleteMessageSuccess: WebElement

    fun switchTheme(text: String): ListPage {
        Select(switchTheme).selectByVisibleText(text)
        return this
    }

    fun clickAddRecord() = addRecord.click()

    fun searchCustomerName(text: String): ListPage {
        customerName.sendKeys(text)
        waitVisibilityOfElement(clearSearch)
        return this
    }

    fun clickActionsSelectAll(): ListPage {
        actionsRadioAll.click()
        return this
    }

    fun clickActionsDelete(): ListPage {
        actionsDelete.click()
        return this
    }

    fun getDeleteAlertText(): String = waitVisibilityOfElement(deleteAlertText).text

    fun clickDeleleAlertDelete(): ListPage {
        deleteAlertDelete.click()
        return this
    }

    fun getDeleteMessageSuccess(): String = waitVisibilityOfElement(deleteMessageSuccess).text
}
