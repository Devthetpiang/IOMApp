package com.xavey.proto.api.model.json;

import java.util.List;

/**
 * Created by tinmaungaye on 4/2/2016.
 */
public class FormDoc {
    String _id;
    Long timestamp;
    Form form;
    FormLocation location;
    String document_id;
    String submit_datetime;
    List<FormData> data;
    Worker worker;
    Organisation org;
    Boolean completed;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public FormLocation getLocation() {
        return location;
    }

    public void setLocation(FormLocation location) {
        this.location = location;
    }

    public String getDocument_id() {
        return document_id;
    }

    public void setDocument_id(String document_id) {
        this.document_id = document_id;
    }

    public String getSubmit_datetime() {
        return submit_datetime;
    }

    public void setSubmit_datetime(String submit_datetime) {
        this.submit_datetime = submit_datetime;
    }

    public List<FormData> getData() {
        return data;
    }

    public void setData(List<FormData> data) {
        this.data = data;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Organisation getOrg() {
        return org;
    }

    public void setOrg(Organisation org) {
        this.org = org;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}

