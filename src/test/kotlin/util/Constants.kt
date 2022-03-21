package util

import util.PropertiesLoader.Companion.getBrowserName
import util.PropertiesLoader.Companion.getHeadless
import util.PropertiesLoader.Companion.getTimeout
import util.PropertiesLoader.Companion.getURL
import java.time.Duration

class Constants {
    companion object {
        const val SAVE_MESSAGE =
            "Your data has been successfully stored into the database. Edit Record or Go back to list"
        const val DELETE_ALERT_TEXT = "Are you sure that you want to delete"
        const val DELETE_SUCCESS_MESSAGE = "Your data has been successfully deleted from the database."
        val CURRENT_PATH: String = System.getProperty("user.dir")
        val TEST_RESOURCES_PATH = "$CURRENT_PATH/src/test/resources/"
        val SCREENSHOTS_PATH = "${CURRENT_PATH}/build/screenshots/"
        val URL = getURL()
        val TIMEOUT: Duration? = Duration.ofSeconds(getTimeout())
        val BROWSERNAME = getBrowserName()
        val HEADLESS = getHeadless()
    }
}