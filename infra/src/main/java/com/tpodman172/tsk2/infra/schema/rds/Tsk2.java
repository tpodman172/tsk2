/*
 * This file is generated by jOOQ.
 */
package com.tpodman172.tsk2.infra.schema.rds;


import com.tpodman172.tsk2.infra.schema.rds.tables.ChallengeHistory;
import com.tpodman172.tsk2.infra.schema.rds.tables.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Tsk2 extends SchemaImpl {

    private static final long serialVersionUID = 1074151806;

    /**
     * The reference instance of <code>tsk2</code>
     */
    public static final Tsk2 TSK2 = new Tsk2();

    /**
     * The table <code>tsk2.challenge_history</code>.
     */
    public final ChallengeHistory CHALLENGE_HISTORY = com.tpodman172.tsk2.infra.schema.rds.tables.ChallengeHistory.CHALLENGE_HISTORY;

    /**
     * The table <code>tsk2.task</code>.
     */
    public final Task TASK = com.tpodman172.tsk2.infra.schema.rds.tables.Task.TASK;

    /**
     * No further instances allowed
     */
    private Tsk2() {
        super("tsk2", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            ChallengeHistory.CHALLENGE_HISTORY,
            Task.TASK);
    }
}
