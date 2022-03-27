package ru.yamangulov.elk.mock.configuration;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitOutListener {
//    Этот метод использовался при настройке, чтобы чистить очередь, пока logstash еще не забирал сам сообщения из rabbitmq
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = "${rabbitmq.queue}"),
//            exchange = @Exchange(value = "${rabbitmq.exchange}"),
//            key = "${rabbitmq.routingKey}"
//    ))
//    public void listenAndDoNothing(String in) {
//        //this listener read packages from Rabbit and do nothing in order to remove this packages from rabbitmq queue
//    }
}
