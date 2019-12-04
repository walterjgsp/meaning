from faust import Record
from models.algorithm import Algorithm

class StreamAlgorithm(Record,serializer="json"):
    import_str: str
    alg_str: str
    parameters_str: list = None

    def to_algorithm_model(self):
        return Algorithm(self.import_str,self.alg_str,self.parameters_str)
