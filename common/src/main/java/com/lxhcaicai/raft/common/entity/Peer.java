package com.lxhcaicai.raft.common.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Peer {

    /**
     * ip:selfPort
     */
    private final String addr;


    public Peer(String addr) {
        this.addr = addr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(addr);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Peer peer = (Peer) obj;
        return Objects.equals(addr, peer.addr);
    }

    @Override
    public String toString() {
        return "Peer{" +
                "addr='" + addr + '\'' +
                '}';
    }
}
