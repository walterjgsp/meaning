import faust
from models.stream_algorithm import StreamAlgorithm

app = faust.App('sk-processor-app', broker='kafka://kafka-server:9092',store="memory://")
topic = app.topic('sk-individual-topic', value_type=StreamAlgorithm)

@app.agent(topic)
async def hello(individuals):
    async for individual in individuals:
        print(f'Algorithm: {individual.alg_str} Import {individual.import_str}')

@app.timer(interval=1.0)
async def example_sender(app):
    message = StreamAlgorithm(alg_str='Faust', import_str='Walter',parameters_str="teste")
    print(message.dumps())
    await hello.send(
        value=message,
    )

if __name__ == '__main__':
    app.main()