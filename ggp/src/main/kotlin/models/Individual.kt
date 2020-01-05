package models

import java.util.*

data class Individual(
    val id: String = UUID.randomUUID().toString(),
    var tree: IndividualTreeNode? = null,
    var fitness: Double = -1.0,
    var componentsMap: Map<String, IndividualTreeNode>
) {
}

