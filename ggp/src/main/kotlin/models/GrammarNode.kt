package models

data class GrammarNode(
    val name: String,
    val key: String,
    val terminal: Boolean = true,
    val probability: Double = 1.0,
    val children: List<GrammarNode> = emptyList()
)