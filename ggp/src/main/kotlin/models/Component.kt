package models

abstract class Component {
    abstract val name: String
    abstract val importPackage: String
    abstract val parameters: List<String>
}