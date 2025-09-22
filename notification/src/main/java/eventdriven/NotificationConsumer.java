package eventdriven;


import model.Orders;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class NotificationConsumer {

    private static final Logger log = LoggerFactory.getLogger(NotificationConsumer.class);

    @RabbitListener(queues = "${amqp.queue.name}")
    public void handleOrderNotification(Orders orders){
        log.info("Sending notification for order ID: {}, books: {}", orders.getId(), orders.getBookIds());
    }
}
