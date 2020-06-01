package br.com.maddytec.amqp;

public interface AmqpProducer<T> {
    void producer(T t);
}
