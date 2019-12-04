from faust import Record
from models.algorithm import Algorithm

class StreamIndividual(Record,serializer="json"):
    id: str
    import_str: str
    alg_str: str
    db_training_path: str
    db_test_path: str
    parameters_str: list = None

    def to_algorithm_model(self):
        return Algorithm(self.import_str,self.alg_str,self.parameters_str)
