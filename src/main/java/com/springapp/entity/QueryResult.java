package com.springapp.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2015/9/25.
 */


public abstract class QueryResult<T> {

    protected List<T> list;

    public QueryResult() {
        this.list = new ArrayList<T>();
    }

    public abstract void setList(List list);
    public abstract List<T> getList();

    public void add(T ob){
        list.add(ob);
    }
}
