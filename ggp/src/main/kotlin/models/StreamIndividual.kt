package models

import com.google.gson.annotations.SerializedName

data class StreamIndividual(
    var id: String,
    @SerializedName("import_str")
    var importStr: String,
    @SerializedName("alg_str")
    var algStr: String,
    @SerializedName("db_training_path")
    var dbTrainingPath: String,
    @SerializedName("db_test_path")
    var dbTestPath: String,
    @SerializedName("parameters_str")
    var parameters: List<String> = emptyList()
)