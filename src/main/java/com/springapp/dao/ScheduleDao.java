package com.springapp.dao;

import com.springapp.entity.Schedule;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Simon on 2015/9/25.
 */
@Repository
public class ScheduleDao {
    @Resource
    private SessionFactory sessionFactory;

    public Schedule getSchedule(int id){
        return (Schedule)getSession().get(Schedule.class, id);
    }

    public List<Schedule> getSchedules(){
        Query query = getSession().createQuery("from schedule");
        List<Schedule> result = query.list();
        return result;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    public void addSchedule(Schedule schedule){
        getSession().save(schedule);
    }
}
