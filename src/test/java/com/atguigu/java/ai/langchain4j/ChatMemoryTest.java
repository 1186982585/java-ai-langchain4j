package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.assistant.Assistant;
import com.atguigu.java.ai.langchain4j.assistant.MemoryChatAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @Author cxj
 * @Date 2025/5/3 22:22
 * @Description:
 */
@SpringBootTest
public class ChatMemoryTest {

    @Resource
    private Assistant assistant;

    @Test
    public void testChatMemory() {
        String answer1 = assistant.chat("我是环环");
        System.out.println(answer1);

        String answer2 = assistant.chat("我是谁?");
        System.out.println(answer2);
    }


    @Resource
    private QwenChatModel qwenChatModel;
    @Test
    public void testChatMemory2() {

        //第一轮对话
        UserMessage userMessage1 = UserMessage.userMessage("我是环环");
        ChatResponse chatResponse1 = qwenChatModel.chat(userMessage1);
        AiMessage aiMessage1 = chatResponse1.aiMessage();
        //输出大语言模型的回复
        System.out.println(aiMessage1.text());

        //第二轮对话
        UserMessage userMessage2 = UserMessage.userMessage("你知道我是谁吗?");
        ChatResponse chatResponse2 = qwenChatModel.chat(Arrays.asList(userMessage1, aiMessage1, userMessage2));
        AiMessage aiMessage2 = chatResponse2.aiMessage();
        //输出大语言模型的回复
        System.out.println(aiMessage2.text());
    }

    @Test
    public void testChatMemory3() {

        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        Assistant assistant = AiServices
                .builder(Assistant.class)
                .chatLanguageModel(qwenChatModel)
                .chatMemory(chatMemory)
                .build();

        String answer1 = assistant.chat("我是环环");
        System.out.println(answer1);
        String answer2 = assistant.chat("我是谁?");
        System.out.println(answer2);
    }


    @Resource
    private MemoryChatAssistant memoryChatAssistant;
    @Test
    public void testChatMemory4() {
        String answer1 = memoryChatAssistant.chat("我是张三");
        System.out.println(answer1);
        String answer2 = memoryChatAssistant.chat("我是谁?");
        System.out.println(answer2);
    }

}
