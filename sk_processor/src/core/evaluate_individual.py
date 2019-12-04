from multiprocessing import Queue
from models.stream_individual import StreamIndividual

def evaluate_individual(process_queue: Queue,stream_individual: StreamIndividual) -> None:
    process_queue.put({"accuracy_test":2.99,"f1_test":3.22})