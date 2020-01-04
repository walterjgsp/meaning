package repository

import com.google.gson.Gson
import models.Configuration
import utils.FileUtils

object ConfigurationRepository {

    fun loadConfiguration(configPath: String): Configuration {
        val jsonString = FileUtils.readFile(configPath)
        return Gson().fromJson(jsonString, Configuration::class.java)
    }
}