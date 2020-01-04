package core

import models.*
import shared.Artifacts
import kotlin.random.Random

object PopulationFactory {

    fun generateInitialPopulation(): List<Individual> {
        val population = mutableListOf<Individual>()
        repeat(Artifacts.configuration.population) {
            val newIndividual = generateIndividual()
            population.add(newIndividual)
        }

        return population
    }

    fun generateIndividual(): Individual {
        val componentMap: MutableMap<String, IndividualTreeNode>? = mutableMapOf()
        val individualTree = recursiveIndividualGenerator(Artifacts.grammarTree, componentMap)

        return Individual(tree = individualTree, componentsMap = componentMap ?: mapOf())
    }

    private fun recursiveIndividualGenerator(
        grammarNode: GrammarNode,
        componentsMap: MutableMap<String, IndividualTreeNode>?
    ): IndividualTreeNode? {
        val drawValue: Double = Random.nextDouble(100.0) / 100.0
        return if (drawValue < grammarNode.probability) {
            val children = mutableListOf<IndividualTreeNode>()
            var component: Component? = null
            if (grammarNode.terminal) {
                component = Artifacts.components.get(grammarNode.key)?.random()
            } else {
                for (child in grammarNode.children) {
                    val newChildrenNode = recursiveIndividualGenerator(child, componentsMap)
                    newChildrenNode?.let {
                        children.add(newChildrenNode)
                    }
                }
            }
            val newNode = IndividualTreeNode(
                key = grammarNode.key,
                terminal = grammarNode.terminal,
                component = component,
                children = children
            )
            componentsMap?.put(newNode.key, newNode)
            newNode
        } else {
            null
        }
    }
}