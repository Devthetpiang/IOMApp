package com.xavey.proto.api.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by tinmaungaye on 3/30/16.
 */
public class FormRecords implements Serializable {
    private String _id;
    private String records;
    private int q_id;
    private Date created_on;
    private Date finished_on;
    private Boolean synced;
    private int user_id;
    private Boolean completed;

    public FormRecords() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getQ_id() {
        return q_id;
    }

    public void setQ_id(int q_id) {
        this.q_id = q_id;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public Date getFinished_on() {
        return finished_on;
    }

    public void setFinished_on(Date finished_on) {
        this.finished_on = finished_on;
    }

    public Boolean getSynced() {
        return synced;
    }

    public void setSynced(Boolean synced) {
        this.synced = synced;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
