package tests

import core.Constants.Companion.ADDSUCCESSMESSAGE
import core.Constants.Companion.DELETEALERTTEXT
import core.Constants.Companion.DELETESUCCESSMESSAGE
import core.DriverFactory
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import page.AddCustomerPage
import page.ListPage

class CustomerTest : DriverFactory() {
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

        assertEquals(ADDSUCCESSMESSAGE, add.getAddSuccessMessage())
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


        assertEquals(ADDSUCCESSMESSAGE, add.getAddSuccessMessage())

        add
            .clickGoBackToList()

        list
            .searchCustomerName("Teste Sicredi")
            .clickActionsSelectAll()
            .clickActionsDelete()


        assertEquals(DELETEALERTTEXT, list.getDeleteAlertText())
        list.clickDeleleAlertDelete()
        assertEquals(DELETESUCCESSMESSAGE, list.getDeleteSuccessMessage())
    }
}