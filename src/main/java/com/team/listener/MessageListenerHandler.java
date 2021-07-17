package com.team.listener;

import com.alibaba.nacos.client.naming.utils.CollectionUtils;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname MessageListenerHandler
 * @Description TODO
 * @Date 2021/7/16 下午11:25
 * @Created by muyi
 */

@Component
public class MessageListenerHandler implements MessageListenerConcurrently {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageListenerHandler.class);

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                    ConsumeConcurrentlyContext context) {
        if (CollectionUtils.isEmpty(msgs)) {
            LOGGER.info("receive blank msgs...");
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        MessageExt messageExt = msgs.get(0);

        LOGGER.info("TOPIC:"+messageExt.getTopic());

        switch (messageExt.getTopic()){
            case "seckill":
                LOGGER.info("[{}]消费",messageExt.getTopic());
                // TODO
                break;
            default:
                LOGGER.info("[{}]无消费",messageExt.getTopic());
                break;
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

    private void mockConsume(String msg){
        LOGGER.info("receive msg: {}.", msg);
    }
}
