package models

data class Individual(
    var tree: IndividualTreeNode? = null,
    var fitness: Double = -1.0,
    var componentsMap: Map<String,IndividualTreeNode>
) {
}

