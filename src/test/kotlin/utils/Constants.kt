package utils

import java.time.Duration

class Constants {
    companion object {
        val TIMEOUT: Duration? = Duration.ofSeconds(10)
        const val ADDSUCCESSMESSAGE =
            "Your data has been successfully stored into the database. Edit Record or Go back to list"
        const val DELETEALERTTEXT = "Are you sure that you want to delete"
        const val DELETESUCCESSMESSAGE = "Your data has been successfully deleted from the database."
    }
}