package tests

import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.Test
import org.openqa.selenium.chrome.ChromeDriver
import page.AddCustomerPage
import page.ListPage
import java.time.Duration

class CustomerTest {

    @Test
    fun test() {
        WebDriverManager.chromedriver().setup()
        val url = "https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap"
        val defaultTimeout = 10L

        val driver = ChromeDriver()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(defaultTimeout))

        driver.get(url)

        val list = ListPage(driver)
        val add = AddCustomerPage(driver)

        list
            .switchTheme("Bootstrap V4 Theme")
            .clickAddRecord()

        add
            .writeCustomerName("Teste")
            .writeContactLastName("Teste")

        driver.quit()
    }
}