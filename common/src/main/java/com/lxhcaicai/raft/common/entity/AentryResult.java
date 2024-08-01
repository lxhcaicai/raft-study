package com.lxhcaicai.raft.common.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 附加 RPC 日志返回值.
 */
@Setter
@Getter
@ToString
public class AentryResult implements Serializable {

    /**
     * 当前的任期号，用于领导人去更新自己
     */
    long term;

    /**
     * 跟随者包含了匹配上 prevLogIndex 和 prevLogTerm 的日志时为真
     */
    boolean success;

    public AentryResult(boolean success) {
        this.success = success;
    }

    private AentryResult(Builder builder) {
        setTerm(builder.term);
        setSuccess(builder.success);
    }

    public static final class Builder {
        private long term;
        private boolean success;

        public Builder() {
        }

        public Builder term(long val) {
            term = val;
            return this;
        }

        public Builder success(boolean val) {
            success = val;
            return this;
        }

        public AentryResult build() {
            return new AentryResult(this);
        }
    }
}
