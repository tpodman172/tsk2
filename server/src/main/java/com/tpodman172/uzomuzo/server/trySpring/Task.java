package com.tpodman172.uzomuzo.server.trySpring;


import lombok.Data;

import java.util.Date;

@Data
public class Task {

    private int id;

    private String title;

    private String body;

    private Date createAt;

    private Date updateAt;
}