package com.selfstudy.kuibu.vo;

import com.selfstudy.kuibu.constants.*;
import com.selfstudy.kuibu.persistence.TaskCommonInfoEntity;
import com.selfstudy.kuibu.persistence.TaskReadingInfoEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TaskInfo {

    private String taskId;

    private String username;

    private String userId;

    private String taskName;

    private String taskType;

    private String taskStatus;

    private int taskFrom;

    private int taskPriority;

    private Date createTime;

    private Date startTime;

    private Date lastUpdateTime;

    private Date endTime;

    private int pagesIntotal;

    private int pagesCurrent;

    private int expectedDays;

    private Map<Integer, Integer> history;

    public TaskInfo() {

    }

    public TaskInfo(TaskCommonInfoEntity commonInfoEntity, TaskReadingInfoEntity readingInfoEntity) {
        if(commonInfoEntity != null) {
            this.setTaskId(commonInfoEntity.getTaskId().toString());
            this.setTaskName(commonInfoEntity.getTaskName());
            this.setTaskType(commonInfoEntity.getTaskType().name());
            this.setTaskStatus(commonInfoEntity.getTaskStatus().name());
        }
        if (readingInfoEntity != null) {
            this.setTaskId(readingInfoEntity.getTaskId().toString());
            this.setPagesIntotal(readingInfoEntity.getPagesIntotal());
            this.setPagesCurrent(readingInfoEntity.getPagesCurrent());
            this.setExpectedDays(readingInfoEntity.getExpectedDays());
            this.setHistory(readingInfoEntity.getHistory());
        }
    }

    public TaskCommonInfoEntity toTaskCommonInfoEntity () {
        TaskCommonInfoEntity commonInfoEntity = new TaskCommonInfoEntity();
        commonInfoEntity.setTaskId(UUID.fromString(this.taskId));
        commonInfoEntity.setTaskName(this.taskName);
        commonInfoEntity.setTaskType(TaskType.valueOf(this.taskType));
        commonInfoEntity.setCreateTime(this.createTime);
        return commonInfoEntity;
    }

    public void updateTaskCommonInfoEntity (TaskCommonInfoEntity commonInfoEntity) {
        commonInfoEntity.setTaskName(this.taskName);
        commonInfoEntity.setTaskStatus(TaskStatus.valueOf(this.taskStatus));
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public TaskReadingInfoEntity toTaskReadingInfoEntity () {
        TaskReadingInfoEntity readingInfoEntity = new TaskReadingInfoEntity();
        readingInfoEntity.setTaskId(UUID.fromString(this.taskId));
        readingInfoEntity.setPagesIntotal(this.pagesIntotal);
        readingInfoEntity.setPagesCurrent(this.pagesCurrent);
        readingInfoEntity.setExpectedDays(this.expectedDays);
        if (this.history == null) {
            this.history = new HashMap<Integer, Integer>();
            this.history.put(0,0);
        }
        readingInfoEntity.setHistory(this.history);
        return readingInfoEntity;
    }

    public void updateTaskReadingInfoEntity(TaskCommonInfoEntity commonInfoEntity, TaskReadingInfoEntity readingInfoEntity) {
        readingInfoEntity.setPagesCurrent(this.pagesCurrent);
        readingInfoEntity.setPagesIntotal(this.pagesIntotal);
        readingInfoEntity.setExpectedDays(this.expectedDays);

        Long theDay = (System.currentTimeMillis() - commonInfoEntity.getCreateTime().getTime()) / KuiBuConstants.ONE_DAY+1;
        readingInfoEntity.getHistory().put(theDay.intValue(), this.pagesCurrent);
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getPagesIntotal() {
        return pagesIntotal;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public int getTaskFrom() {
        return taskFrom;
    }

    public void setTaskFrom(int taskFrom) {
        this.taskFrom = taskFrom;
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setPagesIntotal(int pagesIntotal) {
        this.pagesIntotal = pagesIntotal;
    }

    public int getPagesCurrent() {
        return pagesCurrent;
    }

    public void setPagesCurrent(int pagesCurrent) {
        this.pagesCurrent = pagesCurrent;
    }

    public int getExpectedDays() {
        return expectedDays;
    }

    public void setExpectedDays(int expectedDays) {
        this.expectedDays = expectedDays;
    }

    public Map<Integer, Integer> getHistory() {
        return history;
    }

    public void setHistory(Map<Integer, Integer> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Task:[");
        sb.append("taskId=").append(this.taskId).append(",");
        sb.append("loginName=").append(this.username).append(",");
        sb.append("TaskName=").append(this.taskName).append(",");
        sb.append("taskType=").append(this.taskType).append(",");
        sb.append("taskStatus=").append(this.taskStatus).append(",");
        sb.append("taskFrom=").append(this.taskFrom).append(",");
        sb.append("taskPriority=").append(this.taskPriority).append(",");
        sb.append("expectedDays=").append(this.expectedDays).append(",");
        sb.append("pagesCurrent=").append(this.pagesCurrent).append(",");
        sb.append("pagesIntotal=").append(this.pagesIntotal).append(",");
        sb.append("createTime=").append(this.createTime).append(",");
        sb.append("endTime=").append(this.endTime).append(",");
        sb.append("history=").append(this.history).append(",");

        return sb.toString();
    }
}
