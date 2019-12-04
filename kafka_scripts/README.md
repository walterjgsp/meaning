# Kafka

Kafka was chosen as the mediator between the GGP(application that gonna create possible machine learning pipelines) and the consumers (applications
that gonna evaluate the created pipelines)

This project deployed Kafka using Docker, so, the first step is to install Docker on your machine to make it work.

## 1. Setup

It's necessary to change your IP address on the kafka container to your machine ip.
For unix based SO just run the command 

```bash
ifconfig |grep inet
```

to discover your machine IP. 

Open your file "/etc/hosts" with admin permission and your favorite editor.
Add the following line to the final of this file:

```bash
<YOUR_IP> kafka_server
```

To test if everything worked just use the command

```bash
ping kafka-server
```

and if no package is lost the setup is done

## 2. Commands

This sections list important commands for Kafka usage with docker:

To enter the kafka container shell:

```bash
docker-compose exec -it kafka-server /bin/bash
```

Create a producer inside kafka container:

```bash
kafka-console-producer.sh --broker-list kafka-server:9092 --topic test
```

And to create the consumer also inside the kafka container:

```bash
kafka-console-consumer.sh --bootstrap-server kafka-server:9092 --topic test
```

If you want to list all the topics in your Kafka machine:

```bash
kafka-topics.sh --list --bootstrap-server kafka-server:9092
```

## 3. Other info

If you want to test the connection outside the container, there is two scripts
in kafka_scripts folder. One is a producer and the other is a consumer. Execute
them and see if the message is being sent and processed.