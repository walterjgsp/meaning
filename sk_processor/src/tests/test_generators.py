import pytest
from core.generators import *
from models.algorithm import Algorithm

from sklearn.tree import DecisionTreeClassifier
from sklearn.neighbors import KNeighborsClassifier

def test_generator_DecisionTreeClassifier():
    algorithm = Algorithm("from sklearn.tree import DecisionTreeClassifier","DecisionTreeClassifier",[])
    assert isinstance(generateModel(algorithm),DecisionTreeClassifier), "test failed"

def test_generator_KNeighborsClassifier():
    algorithm = Algorithm("from sklearn.neighbors import KNeighborsClassifier","KNeighborsClassifier",[])
    assert isinstance(generateModel(algorithm),KNeighborsClassifier), "test failed"