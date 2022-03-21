package util

import util.Constants.Companion.TEST_RESOURCES_PATH
import java.io.FileInputStream
import java.util.*

class PropertiesLoader {
    companion object {
        private val file = FileInputStream("$TEST_RESOURCES_PATH/configuration.properties")
        private val prop = Properties()

        init {
            prop.load(file)
        }

        fun getURL(): String = getProperty("url")

        fun getTimeout(): Long = getProperty("timeout").toLong()

        fun getBrowserName(): String {
            val browser = getProperty("browsername")
            if (browser == "chrome" || browser == "firefox")
                return browser.uppercase()
            else
                throw IllegalArgumentException("\"$browser\" invalid, try chrome or firefox.")
        }

        fun getHeadless(): Boolean = getProperty("headless").toBoolean()

        private fun getProperty(property: String): String = prop.getProperty(property).lowercase()
    }
}

