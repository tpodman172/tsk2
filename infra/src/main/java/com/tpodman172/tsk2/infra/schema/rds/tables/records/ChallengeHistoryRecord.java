/*
 * This file is generated by jOOQ.
 */
package com.tpodman172.tsk2.infra.schema.rds.tables.records;


import com.tpodman172.tsk2.infra.schema.rds.tables.ChallengeHistory;

import java.sql.Date;
import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
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
public class ChallengeHistoryRecord extends UpdatableRecordImpl<ChallengeHistoryRecord> implements Record5<Long, Long, Date, Timestamp, Timestamp> {

    private static final long serialVersionUID = -1377886982;

    /**
     * Setter for <code>tsk2.challenge_history.challenge_history_id</code>.
     */
    public void setChallengeHistoryId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>tsk2.challenge_history.challenge_history_id</code>.
     */
    public Long getChallengeHistoryId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>tsk2.challenge_history.task_id</code>.
     */
    public void setTaskId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>tsk2.challenge_history.task_id</code>.
     */
    public Long getTaskId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>tsk2.challenge_history.challenge_date</code>.
     */
    public void setChallengeDate(Date value) {
        set(2, value);
    }

    /**
     * Getter for <code>tsk2.challenge_history.challenge_date</code>.
     */
    public Date getChallengeDate() {
        return (Date) get(2);
    }

    /**
     * Setter for <code>tsk2.challenge_history.created_at</code>.
     */
    public void setCreatedAt(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>tsk2.challenge_history.created_at</code>.
     */
    public Timestamp getCreatedAt() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>tsk2.challenge_history.updated_at</code>.
     */
    public void setUpdatedAt(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>tsk2.challenge_history.updated_at</code>.
     */
    public Timestamp getUpdatedAt() {
        return (Timestamp) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Long, Date, Timestamp, Timestamp> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, Long, Date, Timestamp, Timestamp> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return ChallengeHistory.CHALLENGE_HISTORY.CHALLENGE_HISTORY_ID;
    }

    @Override
    public Field<Long> field2() {
        return ChallengeHistory.CHALLENGE_HISTORY.TASK_ID;
    }

    @Override
    public Field<Date> field3() {
        return ChallengeHistory.CHALLENGE_HISTORY.CHALLENGE_DATE;
    }

    @Override
    public Field<Timestamp> field4() {
        return ChallengeHistory.CHALLENGE_HISTORY.CREATED_AT;
    }

    @Override
    public Field<Timestamp> field5() {
        return ChallengeHistory.CHALLENGE_HISTORY.UPDATED_AT;
    }

    @Override
    public Long component1() {
        return getChallengeHistoryId();
    }

    @Override
    public Long component2() {
        return getTaskId();
    }

    @Override
    public Date component3() {
        return getChallengeDate();
    }

    @Override
    public Timestamp component4() {
        return getCreatedAt();
    }

    @Override
    public Timestamp component5() {
        return getUpdatedAt();
    }

    @Override
    public Long value1() {
        return getChallengeHistoryId();
    }

    @Override
    public Long value2() {
        return getTaskId();
    }

    @Override
    public Date value3() {
        return getChallengeDate();
    }

    @Override
    public Timestamp value4() {
        return getCreatedAt();
    }

    @Override
    public Timestamp value5() {
        return getUpdatedAt();
    }

    @Override
    public ChallengeHistoryRecord value1(Long value) {
        setChallengeHistoryId(value);
        return this;
    }

    @Override
    public ChallengeHistoryRecord value2(Long value) {
        setTaskId(value);
        return this;
    }

    @Override
    public ChallengeHistoryRecord value3(Date value) {
        setChallengeDate(value);
        return this;
    }

    @Override
    public ChallengeHistoryRecord value4(Timestamp value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public ChallengeHistoryRecord value5(Timestamp value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public ChallengeHistoryRecord values(Long value1, Long value2, Date value3, Timestamp value4, Timestamp value5) {
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
     * Create a detached ChallengeHistoryRecord
     */
    public ChallengeHistoryRecord() {
        super(ChallengeHistory.CHALLENGE_HISTORY);
    }

    /**
     * Create a detached, initialised ChallengeHistoryRecord
     */
    public ChallengeHistoryRecord(Long challengeHistoryId, Long taskId, Date challengeDate, Timestamp createdAt, Timestamp updatedAt) {
        super(ChallengeHistory.CHALLENGE_HISTORY);

        set(0, challengeHistoryId);
        set(1, taskId);
        set(2, challengeDate);
        set(3, createdAt);
        set(4, updatedAt);
    }
}
