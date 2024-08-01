package com.lxhcaicai.raft.server.impl;

import com.lxhcaicai.raft.common.entity.LogEntry;
import com.lxhcaicai.raft.server.StateMachine;
import lombok.extern.slf4j.Slf4j;
import org.rocksdb.RocksDB;

@Slf4j
public class DefaultStateMachine implements StateMachine {

    /** public just for test */
    public String dbDir;
    public String stateMachineDir;

    public RocksDB machineDb;

    private DefaultStateMachine() {
        // TODO
    }

    public static DefaultStateMachine getInstance() {
        return DefaultStateMachineLazyHolder.INSTANCE;
    }

    private static class DefaultStateMachineLazyHolder {
        private static DefaultStateMachine INSTANCE = new DefaultStateMachine();
    }

    @Override
    public void init() throws Throwable {

    }

    @Override
    public void destroy() throws Throwable {

    }

    @Override
    public void apply(LogEntry logEntry) {
        // TODO
    }

    @Override
    public LogEntry get(String key) {
        // TODO
        return null;
    }

    @Override
    public String getString(String key) {
        // TODO
        return null;
    }

    @Override
    public void setString(String key, String value) {
        // TODO
    }

    @Override
    public void delString(String... key) {
        // TODO
    }
}
