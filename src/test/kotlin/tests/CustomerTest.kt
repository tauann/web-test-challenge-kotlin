package tests

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import page.AddCustomerPage
import page.ListPage
import base.BaseTest
import util.Constants.Companion.SAVE_MESSAGE
import util.Constants.Companion.DELETE_ALERT_TEXT
import util.Constants.Companion.DELETE_SUCCESS_MESSAGE

class CustomerTest : BaseTest() {
    private var list = ListPage(driver)
    private var addCustomer = AddCustomerPage(driver)

    @Test
    fun challengeOneTest() {
        list
            .switchTheme("Bootstrap V4 Theme")
            .addRecord()

        fillAllRequiredFieldsOfCustomer()
        addCustomer.save()

        assertEquals(SAVE_MESSAGE, addCustomer.saveMessage())
    }

    @Test
    fun challengeTwoTest() {
        list
            .switchTheme("Bootstrap V4 Theme")
            .addRecord()

        fillAllRequiredFieldsOfCustomer()

        addCustomer.save()

        assertEquals(SAVE_MESSAGE, addCustomer.saveMessage())

        addCustomer.goBackToList()

        list
            .searchCustomerName("User Test")
            .selectAll()
            .deleteAll()

        assertTrue(list.deleteAlertText().contains(DELETE_ALERT_TEXT))

        list.deleleAlertDelete()

        assertEquals(DELETE_SUCCESS_MESSAGE, list.deleteSuccessMessage())
    }

    private fun fillAllRequiredFieldsOfCustomer() {
        addCustomer
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