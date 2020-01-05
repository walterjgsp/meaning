package kafka

import com.google.gson.Gson
import models.StreamIndividual


object KafkaController {
    val kafka = Kafka("kafka-server:9092")
    val processorTopic = "sk-individual-topic"

    fun sendIndividual(streamIndividual: StreamIndividual){
        val producer = Producer(kafka, processorTopic)
        val jsonString = Gson().toJson(streamIndividual)
        producer.send(jsonString)
        producer.flush()
    }
}