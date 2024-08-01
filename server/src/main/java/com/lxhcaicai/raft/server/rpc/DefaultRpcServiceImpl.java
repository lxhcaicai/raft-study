package com.lxhcaicai.raft.server.rpc;

import com.alipay.remoting.BizContext;
import com.alipay.remoting.rpc.RpcServer;
import com.lxhcaicai.raft.common.entity.AentryParam;
import com.lxhcaicai.raft.common.entity.ClientKVReq;
import com.lxhcaicai.raft.common.entity.Peer;
import com.lxhcaicai.raft.common.entity.RvoteParam;
import com.lxhcaicai.raft.common.rpc.Request;
import com.lxhcaicai.raft.common.rpc.Response;
import com.lxhcaicai.raft.server.changes.ClusterMembershipChanges;
import com.lxhcaicai.raft.server.impl.DefaultNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultRpcServiceImpl implements RpcService{

    private final DefaultNode node;

    private final RpcServer rpcServer;

    public DefaultRpcServiceImpl(int port, DefaultNode node) {
        rpcServer = new RpcServer(port, false, false);
        rpcServer.registerUserProcessor(new RaftUserProcessor<Request>() {

            @Override
            public Object handleRequest(BizContext bizCtx, Request request) throws Exception {
                return handlerRequest(request);
            }
        });

        this.node = node;
    }

    @Override
    public void init() throws Throwable {

    }

    @Override
    public void destroy() throws Throwable {
        rpcServer.stop();
        log.info("destroy success");
    }

    @Override
    public Response<?> handlerRequest(Request request) {
        if (request.getCmd() == Request.R_VOTE) {
            return new Response<>(node.handlerRequestVote((RvoteParam) request.getObj()));
        } else if (request.getCmd() == Request.A_ENTRIES) {
            return new Response<>(node.handlerAppendEntries((AentryParam) request.getObj()));
        } else if (request.getCmd() == Request.CLIENT_REQ) {
            return new Response<>(node.handlerClientRequest((ClientKVReq) request.getObj()));
        } else if (request.getCmd() == Request.CHANGE_CONFIG_REMOVE) {
            return new Response<>(((ClusterMembershipChanges)node).removePeer((Peer) request.getObj()));
        } else if (request.getCmd() == Request.CHANGE_CONFIG_ADD) {
            return new Response<>(((ClusterMembershipChanges)node).addPeer((Peer) request.getObj()));
        }

        return null;
    }
}
