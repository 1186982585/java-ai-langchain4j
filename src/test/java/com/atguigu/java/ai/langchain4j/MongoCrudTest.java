package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.bean.ChatMessages;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * @Author cxj
 * @Date 2025/5/5 16:27
 * @Description:
 */
@SpringBootTest
public class MongoCrudTest {

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 插入文档
     */
//    @Test
//    public void testInsert() {
//        ChatMessages chatMessages = new ChatMessages(1L, "test");
//        mongoTemplate.insert(chatMessages);
//    }

    @Test
    public void testInsert2() {
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("test");
        mongoTemplate.insert(chatMessages);
    }

    @Test
    public void testFindById() {
        ChatMessages chatMessages = mongoTemplate.findById("68187f4d7fb78d0b531545cf", ChatMessages.class);
        System.out.println(chatMessages);
        Iterable<ChatMessages> chatMessages2 = mongoTemplate.findAll(ChatMessages.class);
        chatMessages2.forEach(System.out::println);
    }

    /**
     * 修改或新增测试
     */
    @Test
    public void testUpdate() {
        Criteria criteria = Criteria.where("_id").is("68187f851eeef5659e68f55e");
//        Criteria criteria = Criteria.where("content").is("test");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "guess");

        //修改或新增
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }

    @Test
    public void testDelete() {
        Criteria criteria = Criteria.where("content").is("聊天记录");
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);
    }
}
