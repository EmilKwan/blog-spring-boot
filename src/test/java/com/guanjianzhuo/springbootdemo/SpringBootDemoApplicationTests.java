package com.guanjianzhuo.springbootdemo;

import com.guanjianzhuo.springbootdemo.controller.DemoController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
// 指定Spring Boot的启动类
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class SpringBootDemoApplicationTests {
	// 模拟调用Controller接口发起请求
	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new DemoController()).build();
	}

	@Test
	public void demo() throws Exception {
		ResultActions perform = mvc.perform(MockMvcRequestBuilders.get("/demo").accept(MediaType.APPLICATION_JSON));
		perform.andExpect(status().isOk()).andExpect(content().string(equalTo("demo")));
	}
}
