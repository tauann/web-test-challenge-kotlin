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

    fun switchTheme(text: String): ListPage {
        Select(switchTheme).selectByVisibleText(text)
        return this
    }

    fun clickAddRecord(): ListPage {
        addRecord.click()
        return this
    }
}