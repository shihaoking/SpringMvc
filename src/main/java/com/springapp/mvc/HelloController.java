package com.springapp.mvc;

import com.springapp.entity.QueryResult;
import com.springapp.entity.Schedule;
import com.springapp.entity.ScheduleResult;
import com.springapp.service.DbService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping({"/hello"})
public class HelloController {

    @Resource
    private DbService dbService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!999");
		return "hello";
	}

    @RequestMapping(method = RequestMethod.GET, value = "getJson_{fm}")
    @ResponseBody
    public String getJson(@PathVariable("fm") String fm){
        return fm;
    }

    @RequestMapping(value = "getSchedules", method = RequestMethod.GET)
    @ResponseBody
    public ScheduleResult getSchedules(final String id) {
        ScheduleResult result = new ScheduleResult();

        if (id == null || id.isEmpty()) {
            result.setList(dbService.getSchedules());
        }
        else {
            result.add(dbService.getSchedule(id));
        }

        return result;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addSchedule(@ModelAttribute Schedule schedule){
        boolean result = dbService.addSchedule(schedule);

        if(result){
            return "success";
        }else{
            return "faild";
        }
    }
}