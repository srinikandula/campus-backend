package com.anyaudit.payload.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Assignment {
    private long id;
    private String assignmentname;
    private String typeofassignment;
    private String clientname;
    private String financialyear;
    private String engagementpartner;
    private String reviewpartner;
    private String users;
    private String value;
    private String startdate;
    private String enddate;
}
