package utils

import java.io.File

object FileUtils {

    fun readFile(fileName: String): String? {
        val file = File(fileName)
        return if (file.exists()) {
            file.readText(Charsets.UTF_8)
        } else {
            null
        }
    }

}