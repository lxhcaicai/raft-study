package com.lxhcaicai.raft.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogEntry implements Serializable, Comparable {

    private Long idnex;

    private long term;

    private Command command;


    @Override
    public int compareTo(Object obj) {
        if(obj == null) {
            return -1;
        }
        if (this.getIdnex() > ((LogEntry) obj).getIdnex()) {
            return 1;
        }
        return -1;
    }
}
