package com.lxhcaicai.raft.server.impl;

import com.lxhcaicai.raft.common.entity.*;
import com.lxhcaicai.raft.server.Node;
import com.lxhcaicai.raft.server.changes.ClusterMembershipChanges;
import com.lxhcaicai.raft.server.changes.Result;

public class DefaultNode implements Node, ClusterMembershipChanges {



    private DefaultNode() {
    }

    public static DefaultNode getInstance() {
        return DefaultNodeLazyHolder.INSTANCE;
    }

    private static class DefaultNodeLazyHolder {
        private static final DefaultNode INSTANCE = new DefaultNode();
    }

    @Override
    public void init() throws Throwable {
        // TODO
    }

    @Override
    public void destroy() throws Throwable {
        // TODO

    }

    @Override
    public void setConfig(NodeConfig config) {
        // TODO
    }

    @Override
    public RvoteResult handlerRequestVote(RvoteParam param) {
        // TODO
        return null;
    }

    @Override
    public AentryResult handlerAppendEntries(AentryParam param) {
        // TODO
        return null;
    }

    @Override
    public ClientKVAck handlerClientRequest(ClientKVReq request) {
        // TODO
        return null;
    }

    @Override
    public ClientKVAck redirect(ClientKVReq request) {
        // TODO
        return null;
    }

    @Override
    public Result addPeer(Peer newPeer) {
        // TODO
        return null;
    }

    @Override
    public Result removePeer(Peer oldPeer) {
        // TODO
        return null;
    }
}
