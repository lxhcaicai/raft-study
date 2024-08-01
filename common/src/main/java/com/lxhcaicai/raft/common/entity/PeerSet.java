package com.lxhcaicai.raft.common.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 节点集合. 去重
 */
@Getter
@Setter
public class PeerSet implements Serializable {

    private List<Peer> list = new ArrayList<>();

    private volatile Peer leader;

    private volatile Peer self;

    public PeerSet() {
    }

    public static PeerSet getInstance() {
        return PeerSetLazyHolder.INSTANCE;
    }

    private static class PeerSetLazyHolder {

        private static final PeerSet INSTANCE = new PeerSet();
    }

    public void addPeer(Peer peer) {
        list.add(peer);
    }

    public void removePeer(Peer peer) {
        list.remove(peer);
    }

    public List<Peer> getPeers () {
        return list;
    }

    public List<Peer> getPeersWithOutSelf() {
        List<Peer> peerList = new ArrayList<>(list);
        peerList.remove(self);
        return peerList;
    }


    @Override
    public String toString() {
        return "PeerSet{" +
                "list=" + list +
                ", leader=" + leader +
                ", self=" + self +
                '}';
    }
}
