package com.anyaudit.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Milestone {
    private long id;
    private String assignmentname;
    private String typeofassignment;
    private String milestoneName;
    private String checkeruser;
    private String team;
    private String startdate;
    private String enddate;
}
