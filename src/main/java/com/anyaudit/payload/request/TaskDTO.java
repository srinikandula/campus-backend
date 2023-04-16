package com.anyaudit.payload.request;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class TaskDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    @NotNull(message = "Date is required")
    private Date date;

    @NotNull(message = "Plan hour is required")
    private Integer planHour;

    @Size(max = 255, message = "Plan description must be at most 255 characters")
    private String planDesc;

    @NotNull(message = "User is required")
    private Long userId;

    @NotNull(message = "Plan is required")
    private Long planId;
}
