/*
 * This file is generated by jOOQ.
 */
package com.tpodman172.tsk2.infra.schema.rds;


import com.tpodman172.tsk2.infra.schema.rds.tables.Achievement;
import com.tpodman172.tsk2.infra.schema.rds.tables.Task;

import javax.annotation.processing.Generated;


/**
 * Convenience access to all tables in tsk2
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>tsk2.achievement</code>.
     */
    public static final Achievement ACHIEVEMENT = Achievement.ACHIEVEMENT;

    /**
     * The table <code>tsk2.task</code>.
     */
    public static final Task TASK = Task.TASK;
}
