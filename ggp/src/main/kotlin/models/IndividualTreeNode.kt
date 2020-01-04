package models

data class IndividualTreeNode(
    val key: String,
    val terminal: Boolean,
    val component: Component? = null,
    val children: List<IndividualTreeNode>
)