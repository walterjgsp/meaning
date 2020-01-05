package cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import core.PopulationFactory
import kafka.KafkaController
import models.StreamIndividual
import repository.ConfigurationRepository
import repository.GrammarRepository
import shared.Artifacts
import shared.Constants.CLASSIFIER_JSON_PATH
import shared.Constants.COMPONENT_CLASSIFIER_KEY
import shared.Constants.CONFIG_JSON_PATH
import shared.Constants.GRAMMAR_JSON_PATH
import java.util.*

class GGP : CliktCommand() {

    val trainingDatabase by option("-trDb", "--training-database", help = "Training database")
    val testDatabase by option("-teDb", "--test-database", help = "Test database")
    val configurationFilePath: String by option("-cp", "--config-path", help = "Path to configuration file").default(
        CONFIG_JSON_PATH
    )
    val grammarFilePath: String by option("-gp", "--grammar-path", help = "Path to grammar file").default(
        GRAMMAR_JSON_PATH
    )

    override fun run() {
        echo("Loading configuration file")
        Artifacts.configuration = ConfigurationRepository.loadConfiguration(configurationFilePath)

        echo("Loading grammar tree from file")
        Artifacts.grammarTree = GrammarRepository.loadGrammarTree(grammarFilePath)

        echo("Loading classifiers")
        Artifacts.components.putIfAbsent(
            COMPONENT_CLASSIFIER_KEY,
            GrammarRepository.loadClassifiers(CLASSIFIER_JSON_PATH)
        )

        val population = PopulationFactory.generateInitialPopulation()
        echo("Initial population generated with ${population.size} individuals")

        Artifacts.trainingDataset = trainingDatabase ?: ""
        Artifacts.testDataset = testDatabase ?: ""

        population.forEach{
            KafkaController.sendIndividual(StreamIndividual(
                id = UUID.randomUUID().toString(),
                importStr = "from sklearn.tree import DecisionTreeClassifier",
                algStr = "DecisionTreeClassifier",
                dbTrainingPath = Artifacts.trainingDataset,
                dbTestPath = Artifacts.testDataset
            ))
        }
    }
}