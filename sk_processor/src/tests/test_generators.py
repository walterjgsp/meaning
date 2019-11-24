import pytest
from core.generators import *
from models.algorithm import Algorithm

from sklearn.tree import DecisionTreeClassifier

def test_generator_DecisionTreeClassifier():
    algorithm = Algorithm("from sklearn.tree import DecisionTreeClassifier","DecisionTreeClassifier",[])
    assert isinstance(generateModel(algorithm),DecisionTreeClassifier), "test failed"