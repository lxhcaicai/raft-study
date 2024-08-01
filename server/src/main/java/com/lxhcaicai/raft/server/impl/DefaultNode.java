package com.lxhcaicai.raft.server.impl;

import com.lxhcaicai.raft.common.entity.*;
import com.lxhcaicai.raft.server.LogModule;
import com.lxhcaicai.raft.server.Node;
import com.lxhcaicai.raft.server.StateMachine;
import com.lxhcaicai.raft.server.changes.ClusterMembershipChanges;
import com.lxhcaicai.raft.server.changes.Result;
import com.lxhcaicai.raft.server.constant.StateMachineSaveType;
import com.lxhcaicai.raft.server.rpc.DefaultRpcServiceImpl;
import com.lxhcaicai.raft.server.rpc.RpcService;

public class DefaultNode implements Node, ClusterMembershipChanges {

    /**
     * 选举时间间隔基数
     */
    public volatile long electionTime = 15 * 1000;

    /**
     * 上一次选举时间
     */
    public volatile long preElectionTime = 0;

    /**
     * 上次一心跳时间戳
     */
    public volatile long preHeartBeatTime = 0;

    /**
     * 心跳间隔基数
     */
    public final long heartBeatTick = 5 * 100;


    public volatile int status = NodeStatus.FOLLOWER;

    public PeerSet peerSet;

    volatile boolean running = false;

    /* ============ 所有服务器上持久存在的 ============= */

    /** 服务器最后一次知道的任期号（初始化为 0，持续递增） */
    volatile long currentTerm = 0;

    /**
     *  在当前获得选票的候选人的 Id
     */
    volatile String votedFor;

    /**
     * 日志条目集；每一个条目包含一个用户状态机执行的指令，和收到时的任期号
     */
    LogModule logModule;


    /* ============================== */

    public NodeConfig config;

    public RpcService rpcServer;

    public StateMachine stateMachine;




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
        running = true;

    }

    @Override
    public void destroy() throws Throwable {
        // TODO

    }

    @Override
    public void setConfig(NodeConfig config) {
        this.config = config;
        stateMachine = StateMachineSaveType.getForType(config.getStateMachineSaveType()).getStateMachine();
        logModule = DefaultLogModule.getInstance();

        peerSet = PeerSet.getInstance();
        for (String peerAddr: config.getPeerAddrs()) {
            Peer peer = new Peer(peerAddr);
            peerSet.addPeer(peer);
            if (peerAddr.equals("localhost:" + config.getSelfPort())) {
                peerSet.setSelf(peer);
            }
        }

        rpcServer = new DefaultRpcServiceImpl(config.selfPort, this);
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
