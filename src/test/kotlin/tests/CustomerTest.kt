package tests

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import page.AddCustomerPage
import page.ListPage
import utils.BaseTest
import utils.Constants.Companion.ADDSUCCESSMESSAGE
import utils.Constants.Companion.DELETEALERTTEXT
import utils.Constants.Companion.DELETESUCCESSMESSAGE

class CustomerTest : BaseTest() {
    private var list = ListPage(driver)
    private var add = AddCustomerPage(driver)

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

        add.clickGoBackToList()

        list
            .searchCustomerName("Teste Sicredi")
            .clickActionsSelectAll()
            .clickActionsDelete()


        assertTrue(list.getDeleteAlertText().contains(DELETEALERTTEXT))

        list.clickDeleleAlertDelete()

        assertEquals(DELETESUCCESSMESSAGE, list.getDeleteSuccessMessage())
    }
}