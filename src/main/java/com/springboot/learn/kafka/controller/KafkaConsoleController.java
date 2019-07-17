package com.springboot.learn.kafka.controller;

import com.springboot.learn.kafka.bean.KafkaProducer;
import com.springboot.learn.common.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author 熊乾坤
 * <p>
 * 注意，@Profile注解也可以用在Controller层，如果该profile未激活时，Controller路径不会映射出来。
 */
@RestController
@RequestMapping("/kafka")
@Slf4j
@Profile("kafka")
public class KafkaConsoleController {
    private final KafkaProducer kafkaProducerBean;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired(required = false)
    public KafkaConsoleController(KafkaProducer kafkaProducerBean, KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaProducerBean = kafkaProducerBean;
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * 向指定topic发送消息，当使用@RequestBody报错时，可以使用@ModelAttribute替代
     * <p>
     * As said dknight @RequestBody means use of JSON or XML data with maps your DTO bean.
     * In case of MultipartFile you can't use JSON data so you can't use @RequestBody.
     * Try with @ModelAttribute annotation.
     *
     * @param topic 指定的topic
     * @param user  发送的user对象
     */
    @PostMapping("/send-user")
    public void send(@RequestParam("topic") String topic, String key, @ModelAttribute UserDTO user) {
        log.info("Get a Post request---topic: " + topic + "---msg: " + user);
        kafkaProducerBean.produce(topic, key, user);
    }


    @PostMapping("/send-str")
    public void sendStr(@RequestParam("topic") String topic, String key, String data) {
        log.info("Get a Post request---topic: " + topic + "---msg: " + data);
        kafkaProducerBean.produceStr(topic, key, data);
    }

    /**
     * 查询topic的分区信息
     *
     * @param topic 分区
     * @return 分区列表
     */
    @GetMapping("/partition/{topic}")
    public String partitionInfo(@PathVariable("topic") String topic) {
        return kafkaTemplate.partitionsFor(topic).toString();
    }
}
