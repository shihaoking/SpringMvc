package com.springapp.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Simon on 2015/9/26.
 */
@XmlRootElement(name = "schedules")
public class ScheduleResult extends QueryResult<Schedule> {

    @XmlElement(name = "schedule")
    public List<Schedule> getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
