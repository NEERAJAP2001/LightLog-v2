# 🔍 Real-Time Log Monitoring with Kafka & Spring Boot

A microservice-based logging solution that captures logs from Spring Boot applications, streams them to Kafka, and optionally visualizes them using Kibana. Designed to run efficiently on Kubernetes/OpenShift with scalable architecture.

---

## 🧩 Features

- ✅ Real-time log ingestion from Spring Boot services
- ✅ Structured logging using Logback JSON (LogstashEncoder)
- ✅ Kafka integration for log streaming
- ✅ Lightweight consumer service to process logs
- ✅ Configurable keywords for log monitoring (`error`, `exception`, `shutdown`, etc.)
- ✅ REST API to expose logs as JSON
- ✅ Pluggable alerting system via thresholds
- ✅ Deployable to Red Hat OpenShift or Kubernetes
- ✅ Optional ELK integration for advanced analytics

---

## 🛠️ Technologies Used

| Layer | Technology | Purpose |
|-------|------------|---------|
| Logging | `logback-kafka-appender`, `logstash-logback-encoder` | Structured logging + Kafka |
| Messaging | **Apache Kafka**, **Confluent Cloud** | Stream logs between services |
| Backend | **Spring Boot** (Java 17) | Log producer & consumer services |
| Containerization | Docker | To package and deploy to cloud |
| Orchestration | **OpenShift** / Kubernetes | Service deployment and scaling |
| Visualization (optional) | **Kibana**, **Logstash**, **Elasticsearch** | Real-time dashboard of logs |
| Alerting (optional) | Email, Slack (planned) | Trigger alerts based on thresholds |

---

## 🧱 Architecture

```plaintext
+------------------+         Kafka Topic        +------------------+
|  Spring Boot App |  --->  logs-topic   --->   |  Log Consumer    |
| (Logback JSON)   |                           | (Spring Boot)     |
+------------------+                           +------------------+
                                                        |
                                                        | Optional
                                                        v
                                                +------------------+
                                                | Logstash         |
                                                | Elasticsearch    |
                                                | Kibana (Dashboard)|
                                                +------------------+
