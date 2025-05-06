package com.atguigu.java.ai.langchain4j.service;

import com.atguigu.java.ai.langchain4j.entity.Appointment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Author cxj
 * @Date 2025/5/6 11:42
 * @Description:
 */
public interface AppointmentService extends IService<Appointment> {
    Appointment getOne(Appointment appointment);
}
