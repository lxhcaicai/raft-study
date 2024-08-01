package com.lxhcaicai.raft.server;

import com.lxhcaicai.raft.common.LifeCycle;
import com.lxhcaicai.raft.common.entity.LogEntry;

/**
 * 状态机接口.
 */
public interface StateMachine extends LifeCycle {

    void apply(LogEntry logEntry);

    LogEntry get(String key);

    String getString(String key);

    void setString(String key, String value);

    void delString(String ...key);
}
