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
            .searchCustomerName("User Test")
            .selectAll()
            .deleteAll()

        assertTrue(list.deleteAlertText().contains(DELETEALERTTEXT))

        list.deleleAlertDelete()

        assertEquals(DELETESUCCESSMESSAGE, list.deleteSuccessMessage())
    }

    private fun fillAllRequiredFieldsOfCustomer() {
        add
            .customerName("User Test")
            .contactLastName("Test")
            .contactFirstName("User")
            .phone("99 99999-9999")
            .adressLine1("Some Street")
            .addressLine2("None")
            .city("New York")
            .state("NY")
            .postalCode("99999-999")
            .country("USA")
            .salesRepEmployeeNumber("99")
            .creditLimit("999999")
    }
}