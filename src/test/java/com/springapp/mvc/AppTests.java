package com.springapp.mvc;

import com.springapp.entity.Schedule;
import com.springapp.service.DbService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class AppTests {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Resource
    private DbService dbService;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void simple() throws Exception {
        mockMvc.perform(get("/hello/getSchedules"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML))
                .andDo(print());
    }

    @Test
    public void addData() throws Exception {
        Schedule schedule = new Schedule();
        schedule.setTitle("写周报");
        schedule.setAlertDate(new Date(2015, 9, 27));
        schedule.setDescription("一定要记得写！！");
        schedule.setStatus(1);

        mockMvc.perform(post("/hello/add")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("title", "写周报")
                .param("alertDate", new Date(2015, 9, 27).toString())
                .param("description", "一定要记得写！！")
                .param("status", "1")
                .param("createDate", new Date().toString())
                .param("updateDate", new Date().toString()))
                .andExpect(status().isOk())
                .andExpect(view().name("success"))
                .andDo(print());
    }

    @Test
    public void add(){
        Schedule schedule = new Schedule();
        schedule.setTitle("写周报");
        schedule.setAlertDate(new Date(2015, 9, 27));
        schedule.setDescription("一定要记得写！！");
        schedule.setStatus(1);
        schedule.setCreateDate(new Date());
        schedule.setUpdateDate(new Date());

        System.out.println(dbService.addSchedule(schedule));
    }
}
