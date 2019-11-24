import pytest
from models.algorithm import Algorithm

def test_algorithm_model():
    algorithm = Algorithm("from sklearn.tree import DecisionTreeClassifier","DecisionTreeClassifier",[])
    assert algorithm.import_str == "from sklearn.tree import DecisionTreeClassifier", "test failed"
    assert algorithm.alg_str == "DecisionTreeClassifier",  "test failed"
    assert len(algorithm.parameters_str) == 0, "teste failed"