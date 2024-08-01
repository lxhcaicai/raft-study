package com.lxhcaicai.raft.server.rpc;

import com.lxhcaicai.raft.common.LifeCycle;
import com.lxhcaicai.raft.common.rpc.Request;
import com.lxhcaicai.raft.common.rpc.Response;

public interface RpcService extends LifeCycle {

    /**
     * 处理请求
     * @param request
     * @return
     */
    Response<?> handlerRequest(Request request);
}
