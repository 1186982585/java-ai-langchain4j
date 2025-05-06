package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.assistant.SeparateChatAssistant;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author cxj
 * @Date 2025/5/6 10:09
 * @Description:
 */
@SpringBootTest
public class ToolsTest {

    @Resource
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testCalculatorTools() {
        String answer = separateChatAssistant.chat(88, "1+2等于几，475695037565的平方根是多少？");
        //答案：3，689706.4865
        System.out.println(answer);
    }
}
