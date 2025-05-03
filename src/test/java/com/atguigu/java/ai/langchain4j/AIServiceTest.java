package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.assistant.Assistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author cxj
 * @Date 2025/5/3 10:40
 * @Description:
 */
@SpringBootTest
public class AIServiceTest {

    @Resource
    private QwenChatModel qwenChatModel;

    @Test
    public void testChat() {
        Assistant assistant = AiServices.create(Assistant.class, qwenChatModel);
        String answer = assistant.chat("你是谁?");
        System.out.println(answer);
    }

    @Resource
    private Assistant assistant;
    @Test
    public void testAssistant() {
        String answer = assistant.chat("你是谁?");
        System.out.println(answer);
    }
}
