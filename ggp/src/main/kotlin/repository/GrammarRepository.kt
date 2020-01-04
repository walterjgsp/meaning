package repository

import com.google.gson.Gson
import models.Classifier
import models.ClassifierList
import models.GrammarNode
import utils.FileUtils

object GrammarRepository {

    fun loadGrammarTree(grammarPath: String): GrammarNode {
        val jsonString = FileUtils.readFile(grammarPath)
        val grammarTree = Gson().fromJson(jsonString, GrammarNode::class.java)
        return grammarTree
    }

    fun loadClassifiers(classifiersPath: String): List<Classifier> {
        val jsonString = FileUtils.readFile(classifiersPath)
        val classifierList = Gson().fromJson(jsonString, ClassifierList::class.java)
        return classifierList.classifiers
    }
}