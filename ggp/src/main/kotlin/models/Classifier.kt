package models

import com.google.gson.annotations.SerializedName

data class Classifier(
    override val name: String,
    @SerializedName("import_package")
    override val importPackage: String,
    override val parameters: List<String> = emptyList()
) : Component()

data class ClassifierList(
    val classifiers: List<Classifier> = emptyList()
)