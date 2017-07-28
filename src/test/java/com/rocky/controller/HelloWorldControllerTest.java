package com.rocky.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by rocky on 17-7-28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mvc;  /* mvc的mock对象 */

    @Test
    public void testHello() {
        RequestBuilder request = get("/hello/");  /* 定义URL，已经发起请求为get方式 */

        /* 模拟发起Http请求 */
        try {
            mvc.perform(request)
                    .andExpect(status().isOk()) /* 比较返回码是否为200 */
                    .andExpect(content().string(equalTo("{" +  /* 比较返回内容 */
                            "\"msg\":\"HelloWorld\"," +
                            "\"status\":\"success\"" +
                            "}")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}