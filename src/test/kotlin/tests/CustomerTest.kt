package tests

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import page.AddCustomerPage
import page.ListPage
import util.BaseTest
import util.Constants.Companion.SAVEMESSAGE
import util.Constants.Companion.DELETEALERTTEXT
import util.Constants.Companion.DELETESUCCESSMESSAGE

class CustomerTest : BaseTest() {
    private var list = ListPage(driver)
    private var add = AddCustomerPage(driver)

    @Test
    fun challengeOneTest() {
        list
            .switchTheme("Bootstrap V4 Theme")
            .addRecord()

        fillAllRequiredFieldsOfCustomer()
        add.save()

        assertEquals(SAVEMESSAGE, add.saveMessage())
    }

    @Test
    fun challengeTwoTest() {
        list
            .switchTheme("Bootstrap V4 Theme")
            .addRecord()

        fillAllRequiredFieldsOfCustomer()

        add.save()

        assertEquals(SAVEMESSAGE, add.saveMessage())

        add.goBackToList()

        list
            .searchCustomerName("Teste Sicredi")
            .selectAll()
            .deleteAll()

        assertTrue(list.deleteAlertText().contains(DELETEALERTTEXT))

        list.deleleAlertDelete()

        assertEquals(DELETESUCCESSMESSAGE, list.deleteSuccessMessage())
    }

    private fun fillAllRequiredFieldsOfCustomer() {
        add
            .customerName("Teste Sicredi")
            .contactLastName("Teste")
            .contactFirstName("Tauan")
            .phone("51 9999-9999")
            .adressLine1("Av Assis Brasil, 3970")
            .addressLine2("Torre D")
            .city("Porto Alegre")
            .state("RS")
            .postalCode("91000-000")
            .country("Brasil")
            .salesRepEmployeeNumber("51")
            .creditLimit("200")
    }
}