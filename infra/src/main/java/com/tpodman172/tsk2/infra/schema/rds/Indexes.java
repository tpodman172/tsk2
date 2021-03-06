/*
 * This file is generated by jOOQ.
 */
package com.tpodman172.tsk2.infra.schema.rds;


import com.tpodman172.tsk2.infra.schema.rds.tables.Task;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>tsk2</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index TASK_USER_USER_ID_TASK_USER_ID = Indexes0.TASK_USER_USER_ID_TASK_USER_ID;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index TASK_USER_USER_ID_TASK_USER_ID = Internal.createIndex("user_user_id_task_user_id", Task.TASK, new OrderField[] { Task.TASK.USER_ID }, false);
    }
}
