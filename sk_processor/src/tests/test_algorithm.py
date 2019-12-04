import pytest
from models.algorithm import Algorithm
from models.stream_algorithm import StreamAlgorithm

def test_algorithm_model():
    algorithm = Algorithm("from sklearn.tree import DecisionTreeClassifier","DecisionTreeClassifier",[])
    assert algorithm.import_str == "from sklearn.tree import DecisionTreeClassifier", "test failed"
    assert algorithm.alg_str == "DecisionTreeClassifier",  "test failed"
    assert len(algorithm.parameters_str) == 0, "teste failed"

def test_from_stream_algorithm():
    stream_algorithm = StreamAlgorithm(import_str = "from sklearn.tree import DecisionTreeClassifier",alg_str="DecisionTreeClassifier")
    algorithm = stream_algorithm.to_algorithm_model()
    assert algorithm.import_str == "from sklearn.tree import DecisionTreeClassifier", "test failed"
    assert algorithm.alg_str == "DecisionTreeClassifier",  "test failed"