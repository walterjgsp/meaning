package kafka

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*

class Producer(kafka: Kafka, private val topic: String) {

    private val kafkaProducer: KafkaProducer<String, String>

    init {
        val config = Properties()
        config[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafka.bootstrapServers
        config[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        config[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        kafkaProducer = KafkaProducer(config)
    }

    fun send(msg: String) {
        kafkaProducer.send(ProducerRecord(topic, msg))
    }

    fun flush() = kafkaProducer.flush()
}