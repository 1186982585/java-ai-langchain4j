package com.atguigu.java.ai.langchain4j.bean;

import lombok.Data;

/**
 * @Author cxj
 * @Date 2025/5/5 21:54
 * @Description:
 */
@Data
public class ChatForm {
    private Long memoryId;//对话id
    private String message;//用户问题
}
