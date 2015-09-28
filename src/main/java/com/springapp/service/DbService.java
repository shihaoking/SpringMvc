package com.springapp.service;

import com.springapp.dao.ScheduleDao;
import com.springapp.entity.Schedule;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Simon on 2015/9/25.
 */
@Repository
public class DbService {
    @Resource
    private ScheduleDao scheduleDao;

    public Schedule getSchedule(String id){
        if (id == null || id.isEmpty()){
            return new Schedule();
        }

        Schedule schedule = scheduleDao.getSchedule(Integer.valueOf(id));
        return schedule;
    }

    public List<Schedule> getSchedules(){
        List<Schedule> result = scheduleDao.getSchedules();
        return result;
    }

    public boolean addSchedule(Schedule schedule){
        if(schedule == null){
            return false;
        }

        try{
            scheduleDao.addSchedule(schedule);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }

        return true;
    }
}
