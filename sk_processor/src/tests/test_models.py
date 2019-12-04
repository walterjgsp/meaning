import pytest
from models.algorithm import Algorithm
from models.stream_individual import StreamIndividual
from models.evaluation_result import EvaluationResult

def test_algorithm_model():
    algorithm = Algorithm(
        "from sklearn.tree import DecisionTreeClassifier", "DecisionTreeClassifier", [])
    assert algorithm.import_str == "from sklearn.tree import DecisionTreeClassifier", "test failed"
    assert algorithm.alg_str == "DecisionTreeClassifier",  "test failed"
    assert len(algorithm.parameters_str) == 0, "teste failed"


def test_algorithm_from_stream_algorithm():
    stream_algorithm = StreamIndividual(id="1",
                                        import_str="from sklearn.tree import DecisionTreeClassifier",
                                        alg_str="DecisionTreeClassifier", 
                                        db_training_path="training.csv", 
                                        db_test_path="test.csv")
    algorithm = stream_algorithm.to_algorithm_model()
    assert algorithm.import_str == "from sklearn.tree import DecisionTreeClassifier", "test failed"
    assert algorithm.alg_str == "DecisionTreeClassifier",  "test failed"
    assert stream_algorithm.db_training_path == "training.csv", "test failed"
    assert stream_algorithm.db_test_path == "test.csv", "test failed"

def test_evaluation_result():
    evaluation = EvaluationResult(individual_id="1",accuracy_test=4.56,f1_test=5.44)
    assert evaluation.individual_id == "1" , "test failed"
    assert evaluation.accuracy_test == 4.56 , "test failed"
    assert evaluation.f1_test == 5.44, "test failed"

def test_evaluation_result_default():
    evaluation = EvaluationResult(individual_id="1")
    assert evaluation.individual_id == "1" , "test failed"
    assert evaluation.accuracy_test == -1.0 , "test failed"
    assert evaluation.f1_test == -1.0, "test failed"