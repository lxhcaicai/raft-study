package com.lxhcaicai.raft.server.changes;

import com.lxhcaicai.raft.common.entity.Peer;

/**
 * 集群配置变更接口
 */
public interface ClusterMembershipChanges {

    /**
     * 添加节点
     * @param newPeer
     * @return
     */
    Result addPeer(Peer newPeer);

    /**
     * 删除节点
     * @param oldPeer
     * @return
     */
    Result removePeer(Peer oldPeer);


}
