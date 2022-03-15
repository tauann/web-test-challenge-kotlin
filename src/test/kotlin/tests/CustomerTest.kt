package tests

import core.BaseTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import page.AddCustomerPage
import page.ListPage

class CustomerTest : BaseTest() {
    private val list = ListPage(driver!!)
    private val add = AddCustomerPage(driver!!)

    @BeforeEach
    fun before() {
        driver?.get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap")
    }

    @AfterEach
    fun after() {
        driver?.quit()
    }

    @Test
    fun challengeOneTest() {
        list
            .switchTheme("Bootstrap V4 Theme")
            .clickAddRecord()

        add
            .writeCustomerName("Teste Sicredi")
            .writeContactLastName("Teste")
            .writeContactFirstName("Tauan")
            .writePhone("51 9999-9999")
            .writeAdressLine1("Av Assis Brasil, 3970")
            .writeAddressLine2("Torre D")
            .writeCity("Porto Alegre")
            .writeState("RS")
            .writePostalCode("91000-000")
            .writeCountry("Brasil")
            .writeSalesRepEmployeeNumber("51")
            .writeCreditLimit("200")
            .clickSave()

        assertEquals(
            "Your data has been successfully stored into the database. Edit Record or Go back to list",
            add.getSuccessMessage()
        )
    }

    @Test
    fun challengeTwoTest() {
        list
            .switchTheme("Bootstrap V4 Theme")
            .clickAddRecord()

        add
            .writeCustomerName("Teste Sicredi")
            .writeContactLastName("Teste")
            .writeContactFirstName("Tauan")
            .writePhone("51 9999-9999")
            .writeAdressLine1("Av Assis Brasil, 3970")
            .writeAddressLine2("Torre D")
            .writeCity("Porto Alegre")
            .writeState("RS")
            .writePostalCode("91000-000")
            .writeCountry("Brasil")
            .writeSalesRepEmployeeNumber("51")
            .writeCreditLimit("200")
            .clickSave()

        assertEquals(
            "Your data has been successfully stored into the database. Edit Record or Go back to list",
            add.getSuccessMessage()
        )

        add
            .clickGoBackToList()

        list
            .searchCustomerName("Teste Sicredi")
            .clickActionsSelectAll()
            .clickActionsDelete()

        assertEquals("Are you sure that you want to delete this 1 item?", list.getDeleteAlertText())
        list.clickDeleleAlertDelete()
        assertEquals("Your data has been successfully deleted from the database.", list.getDeleteMessageSuccess())

    }
}