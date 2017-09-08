package com.xavey.proto.api.model;

import java.util.Date;

/**
 * Created by tinmaungaye on 4/3/2016.
 */
public class SyncStatus {
    private int totalCount;
    private String group;
    private Boolean synced;
    private Date lastRecord;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getLastRecord() {
        return lastRecord;
    }

    public void setLastRecord(Date lastRecord) {
        this.lastRecord = lastRecord;
    }

    public Boolean getSynced() {
        return synced;
    }

    public void setSynced(Boolean synced) {
        this.synced = synced;
    }
}
