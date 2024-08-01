package com.lxhcaicai.raft.common.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Command implements Serializable {

    String key;

    String value;

}
