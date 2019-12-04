from multiprocessing import Process, Queue
from queue import Empty
from models.evaluation_result import EvaluationResult
from models.stream_individual import StreamIndividual

from core.evaluate_individual import evaluate_individual

def evaluate(stream_individual: StreamIndividual) -> EvaluationResult:
    evaluate_result = EvaluationResult(individual_id = stream_individual.id)

    process_queue = Queue()
    processor = Process(target=evaluate_individual,args=(process_queue,stream_individual))
    processor.start()
    try:
        result = process_queue.get(timeout=60)
        if result is not None:
            evaluate_result.accuracy_test = result["accuracy_test"]
            evaluate_result.f1_test = result["f1_test"]
    except Empty as error: 
        print("Writer: Timeout occurred {}".format(str(error)))
    finally:
        processor.join()
        processor.terminate()
        return evaluate_result