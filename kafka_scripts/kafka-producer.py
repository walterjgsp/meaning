from kafka import KafkaProducer
import json
import random
from time import sleep
from datetime import datetime

# Create an instance of the Kafka producer
producer = KafkaProducer(bootstrap_servers='kafka-server:9092',
                         value_serializer=lambda v: str(v).encode('utf-8'),
                         api_version=(0,11,5))

# Call the producer.send method with a producer-record
print("Ctrl+c to Stop")
while True:
    number = random.randint(1, 999)
    print("Produce: ", number)
    producer.send('kafka-python-topic', number)
