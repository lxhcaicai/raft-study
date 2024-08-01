package com.lxhcaicai.raft.server.rpc;

import com.alipay.remoting.AsyncContext;
import com.alipay.remoting.BizContext;
import com.alipay.remoting.rpc.protocol.AbstractUserProcessor;
import com.lxhcaicai.raft.common.rpc.Request;
import com.lxhcaicai.raft.server.exception.RaftNotSupportException;

public abstract class RaftUserProcessor<T> extends AbstractUserProcessor<T> {

    @Override
    public void handleRequest(BizContext bizCtx, AsyncContext asyncCtx, T request) {
        throw new RaftNotSupportException(
                "Raft Server not support handleRequest(BizContext bizCtx, AsyncContext asyncCtx, T request) ");
    }

    @Override
    public String interest() {
        return Request.class.getName();
    }
}
