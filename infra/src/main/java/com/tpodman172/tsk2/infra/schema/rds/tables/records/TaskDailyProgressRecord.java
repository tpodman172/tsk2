/*
 * This file is generated by jOOQ.
 */
package com.tpodman172.tsk2.infra.schema.rds.tables.records;


import com.tpodman172.tsk2.infra.schema.rds.tables.TaskDailyProgress;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TaskDailyProgressRecord extends UpdatableRecordImpl<TaskDailyProgressRecord> implements Record5<Long, Boolean, LocalDate, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = -336434076;

    /**
     * Setter for <code>tsk2.task_daily_progress.task_id</code>.
     */
    public void setTaskId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>tsk2.task_daily_progress.task_id</code>.
     */
    public Long getTaskId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>tsk2.task_daily_progress.completed</code>.
     */
    public void setCompleted(Boolean value) {
        set(1, value);
    }

    /**
     * Getter for <code>tsk2.task_daily_progress.completed</code>.
     */
    public Boolean getCompleted() {
        return (Boolean) get(1);
    }

    /**
     * Setter for <code>tsk2.task_daily_progress.target_date</code>.
     */
    public void setTargetDate(LocalDate value) {
        set(2, value);
    }

    /**
     * Getter for <code>tsk2.task_daily_progress.target_date</code>.
     */
    public LocalDate getTargetDate() {
        return (LocalDate) get(2);
    }

    /**
     * Setter for <code>tsk2.task_daily_progress.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>tsk2.task_daily_progress.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>tsk2.task_daily_progress.updated_at</code>.
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>tsk2.task_daily_progress.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Long, LocalDate> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Boolean, LocalDate, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, Boolean, LocalDate, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return TaskDailyProgress.TASK_DAILY_PROGRESS.TASK_ID;
    }

    @Override
    public Field<Boolean> field2() {
        return TaskDailyProgress.TASK_DAILY_PROGRESS.COMPLETED;
    }

    @Override
    public Field<LocalDate> field3() {
        return TaskDailyProgress.TASK_DAILY_PROGRESS.TARGET_DATE;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return TaskDailyProgress.TASK_DAILY_PROGRESS.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return TaskDailyProgress.TASK_DAILY_PROGRESS.UPDATED_AT;
    }

    @Override
    public Long component1() {
        return getTaskId();
    }

    @Override
    public Boolean component2() {
        return getCompleted();
    }

    @Override
    public LocalDate component3() {
        return getTargetDate();
    }

    @Override
    public LocalDateTime component4() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component5() {
        return getUpdatedAt();
    }

    @Override
    public Long value1() {
        return getTaskId();
    }

    @Override
    public Boolean value2() {
        return getCompleted();
    }

    @Override
    public LocalDate value3() {
        return getTargetDate();
    }

    @Override
    public LocalDateTime value4() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value5() {
        return getUpdatedAt();
    }

    @Override
    public TaskDailyProgressRecord value1(Long value) {
        setTaskId(value);
        return this;
    }

    @Override
    public TaskDailyProgressRecord value2(Boolean value) {
        setCompleted(value);
        return this;
    }

    @Override
    public TaskDailyProgressRecord value3(LocalDate value) {
        setTargetDate(value);
        return this;
    }

    @Override
    public TaskDailyProgressRecord value4(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public TaskDailyProgressRecord value5(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public TaskDailyProgressRecord values(Long value1, Boolean value2, LocalDate value3, LocalDateTime value4, LocalDateTime value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TaskDailyProgressRecord
     */
    public TaskDailyProgressRecord() {
        super(TaskDailyProgress.TASK_DAILY_PROGRESS);
    }

    /**
     * Create a detached, initialised TaskDailyProgressRecord
     */
    public TaskDailyProgressRecord(Long taskId, Boolean completed, LocalDate targetDate, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(TaskDailyProgress.TASK_DAILY_PROGRESS);

        set(0, taskId);
        set(1, completed);
        set(2, targetDate);
        set(3, createdAt);
        set(4, updatedAt);
    }
}