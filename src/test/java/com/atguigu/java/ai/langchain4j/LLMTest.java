package com.atguigu.java.ai.langchain4j;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.output.Response;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;

/**
 * @Author cxj
 * @Date 2025/4/29 20:06
 * @Description:
 */
@SpringBootTest
public class LLMTest {

    @Test
    public void testGPTDemo() {

        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();
        String answer = model.chat("你是谁，能为我提供什么服务?");
        System.out.println(answer);
    }

    @Resource
    private OpenAiChatModel openAiChatModel;

    @Test
    public void testSpringBoot() {
        String answer = openAiChatModel.chat("你是谁?");
        System.out.println(answer);
        System.out.println(System.getenv("DEEP_SEEK_API_KEY") );
    }

    @Resource
    private ChatLanguageModel ollamaChatModel;

    @Test
    public void testOllamaChatModel() {
        String answer = ollamaChatModel.chat("你是谁?");
        System.out.println(answer);
    }


    /**
     * 通义千问大模型
     */
    @Resource
    private QwenChatModel qwenChatModel;
    @Test
    public void testQwenChatModel() {
        String answer = qwenChatModel.chat("你是谁?");
        System.out.println(answer);
    }

    /**
     * 通义万相文生图
     */
    @Test
    public void testDashScopeWanx() {
        WanxImageModel wanxImageModel = WanxImageModel
                .builder()
                .modelName("wanx2.1-t2i-plus")
                .apiKey(System.getenv("DASH_SCOPE_API_KEY"))
                .build();
        Response<Image> response = wanxImageModel.generate("巨大的齿轮和管道纵横交错，覆盖着整个城市的建筑。高耸入云的烟囱中喷出浓浓的黑烟，天空被染成了暗灰色。街道上，蒸汽驱动的机械车辆穿梭往来，发出嘈杂的轰鸣声。人们穿着皮质的长风衣、戴着护目镜和金属头盔，手中拿着各种机械工具和武器。一座巨大的钟楼矗立在城市中央，齿轮在钟楼上飞速转动，钟声沉闷而悠远。城市边缘，巨大的蒸汽动力飞行器缓缓升空，准备开始新的旅程。");
        URI url = response.content().url();
        System.out.println(url);
    }
}
