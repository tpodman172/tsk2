/*
 * This file is generated by jOOQ.
 */
package com.tpodman172.tsk2.infra.schema.rds.tables;


import com.tpodman172.tsk2.infra.schema.rds.Indexes;
import com.tpodman172.tsk2.infra.schema.rds.Keys;
import com.tpodman172.tsk2.infra.schema.rds.Tsk2;
import com.tpodman172.tsk2.infra.schema.rds.tables.records.AchievementRecord;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Achievement extends TableImpl<AchievementRecord> {

    private static final long serialVersionUID = -803516494;

    /**
     * The reference instance of <code>tsk2.achievement</code>
     */
    public static final Achievement ACHIEVEMENT = new Achievement();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AchievementRecord> getRecordType() {
        return AchievementRecord.class;
    }

    /**
     * The column <code>tsk2.achievement.task_id</code>.
     */
    public final TableField<AchievementRecord, Long> TASK_ID = createField(DSL.name("task_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>tsk2.achievement.target_date</code>.
     */
    public final TableField<AchievementRecord, LocalDate> TARGET_DATE = createField(DSL.name("target_date"), org.jooq.impl.SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * The column <code>tsk2.achievement.completed</code>.
     */
    public final TableField<AchievementRecord, Boolean> COMPLETED = createField(DSL.name("completed"), org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>tsk2.achievement.created_at</code>.
     */
    public final TableField<AchievementRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>tsk2.achievement.updated_at</code>.
     */
    public final TableField<AchievementRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "");

    /**
     * Create a <code>tsk2.achievement</code> table reference
     */
    public Achievement() {
        this(DSL.name("achievement"), null);
    }

    /**
     * Create an aliased <code>tsk2.achievement</code> table reference
     */
    public Achievement(String alias) {
        this(DSL.name(alias), ACHIEVEMENT);
    }

    /**
     * Create an aliased <code>tsk2.achievement</code> table reference
     */
    public Achievement(Name alias) {
        this(alias, ACHIEVEMENT);
    }

    private Achievement(Name alias, Table<AchievementRecord> aliased) {
        this(alias, aliased, null);
    }

    private Achievement(Name alias, Table<AchievementRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Achievement(Table<O> child, ForeignKey<O, AchievementRecord> key) {
        super(child, key, ACHIEVEMENT);
    }

    @Override
    public Schema getSchema() {
        return Tsk2.TSK2;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ACHIEVEMENT_PRIMARY);
    }

    @Override
    public UniqueKey<AchievementRecord> getPrimaryKey() {
        return Keys.KEY_ACHIEVEMENT_PRIMARY;
    }

    @Override
    public List<UniqueKey<AchievementRecord>> getKeys() {
        return Arrays.<UniqueKey<AchievementRecord>>asList(Keys.KEY_ACHIEVEMENT_PRIMARY);
    }

    @Override
    public List<ForeignKey<AchievementRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<AchievementRecord, ?>>asList(Keys.ACHIEVEMENT_IBFK_1);
    }

    public Task task() {
        return new Task(this, Keys.ACHIEVEMENT_IBFK_1);
    }

    @Override
    public Achievement as(String alias) {
        return new Achievement(DSL.name(alias), this);
    }

    @Override
    public Achievement as(Name alias) {
        return new Achievement(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Achievement rename(String name) {
        return new Achievement(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Achievement rename(Name name) {
        return new Achievement(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, LocalDate, Boolean, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
