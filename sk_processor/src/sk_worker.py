import faust
from models.stream_individual import StreamIndividual

from core.evaluate import evaluate

app = faust.App('sk-processor-app', broker='kafka://kafka-server:9092',store="memory://")
topic = app.topic('sk-individual-topic', value_type=StreamIndividual)

@app.agent(topic)
async def process_individual(individuals: faust.Stream[StreamIndividual]) -> None:
    async for individual in individuals:
        evaluate_result = evaluate(individual)
        print(f'Accuracy: {evaluate_result.accuracy_test} F1 {evaluate_result.f1_test}')

if __name__ == '__main__':
    app.main()