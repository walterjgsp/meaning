package cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import repository.ConfigurationRepository
import repository.GrammarRepository
import shared.ParamDefault.CONFIG_JSON_PATH
import shared.ParamDefault.GRAMMAR_JSON_PATH

class GGP : CliktCommand() {

    val configurationFilePath: String by option("-cp", "--config-path", help = "Path to configuration file").default(
        CONFIG_JSON_PATH
    )
    val grammarFilePath: String by option("-gp", "--grammar-path", help = "Path to grammar file").default(
        GRAMMAR_JSON_PATH
    )

    override fun run() {
        echo("Loading configuration file")
        val configuration = ConfigurationRepository.loadConfiguration(configurationFilePath)

        echo("Loading grammar tree from file")
        val grammarTree = GrammarRepository.loadGrammarTree(grammarFilePath)
        echo(grammarTree)
    }
}