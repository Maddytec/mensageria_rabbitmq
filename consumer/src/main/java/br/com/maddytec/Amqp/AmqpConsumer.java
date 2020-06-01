package br.com.maddytec.Amqp;

public interface AmqpConsumer<T> {

    void consumer(T t);
}
