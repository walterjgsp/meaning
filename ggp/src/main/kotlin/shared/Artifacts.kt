package shared

import models.Component
import models.Configuration
import models.GrammarNode

object Artifacts {
    var configuration = Configuration()
    var components = mutableMapOf<String, List<Component>>()
    lateinit var grammarTree: GrammarNode
}