package it.unipol.sample.mailservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class TestController {

    @Value("${message:Hello default}")
    private String message;

    @Value("${ibm.mq.testQueue:DEV.QUEUE.1}")
    private String testQueue;

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping("/test")
    String getMessage() {
        try {
            jmsTemplate.convertAndSend(testQueue, this.message);
            logger.info("Message send to Queue");
        }catch(JmsException exception){
            logger.error(exception.getMessage());
        }
        return this.message;
    }


    @RequestMapping("/test/read")
    String getMessageReceived() {
        String message = "";
        try {
            message = jmsTemplate.receiveAndConvert(testQueue).toString();
            logger.info(message);
        }catch(JmsException exception){
            logger.error(exception.getMessage());
            message = "No message to read";
        }
        return this.message;
    }
}
