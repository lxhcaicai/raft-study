package com.lxhcaicai.raft.server;

import com.lxhcaicai.raft.common.entity.NodeConfig;
import com.lxhcaicai.raft.server.config.Constant;
import com.lxhcaicai.raft.server.constant.StateMachineSaveType;
import com.lxhcaicai.raft.server.impl.DefaultNode;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;


@Slf4j
public class RaftNodeBootStrap {

    public static final String[] DEFAULT_PROCESS = new String[]{
            "localhost:8775", "localhost:8776", "localhost:8777", "localhost:8778", "localhost:8779"
    };

    public static void main(String[] args) throws Throwable {
        boot();
    }

    private static void boot() throws Throwable {
        String property = System.getProperty(Constant.CLUSTER_ADDR_LIST);
        String[] peerAddr;

        if (StringUtil.isNullOrEmpty(property)) {
            peerAddr = DEFAULT_PROCESS;
        } else {
            peerAddr = property.split(Constant.SPLIT);
        }

        NodeConfig config = new NodeConfig();

        // 自身节点
        config.setSelfPort(Integer.parseInt(System.getProperty(Constant.SERVER_PORT,"8779")));

        config.setPeerAddrs(Arrays.asList(peerAddr));
        config.setStateMachineSaveType(StateMachineSaveType.ROCKS_DB.getTypeName());

        Node node = DefaultNode.getInstance();

        node.setConfig(config);

        node.init();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            synchronized (node) {
                node.notifyAll();
            }
        }));

        log.info("gracefully wait");

        synchronized (node) {
            node.wait();
        }

        log.info("gracefully stop");
        node.destroy();
    }
}
