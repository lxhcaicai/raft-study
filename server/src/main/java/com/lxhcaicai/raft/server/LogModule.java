package com.lxhcaicai.raft.server;

import com.lxhcaicai.raft.common.LifeCycle;
import com.lxhcaicai.raft.common.entity.LogEntry;

public interface LogModule extends LifeCycle {

    void write(LogEntry logEntry);

    LogEntry read(long index);

    void removeOnStartIndex(Long startIndex);

    LogEntry getLast();

    Long getLastIndex();

}
