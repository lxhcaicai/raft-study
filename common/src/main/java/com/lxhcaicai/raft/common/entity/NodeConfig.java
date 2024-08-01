package com.lxhcaicai.raft.common.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class NodeConfig {

    /** 自身 selfPort */
    public int selfPort;

    /** 所有节点地址. */
    public List<String> peerAddrs;

    /**
     *  状态快照存储类型
     */
    public String stateMachineSaveType;
}
