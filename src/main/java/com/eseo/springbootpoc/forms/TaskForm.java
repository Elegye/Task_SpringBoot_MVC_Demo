package com.eseo.springbootpoc.forms;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data public class TaskForm {

    @NotNull
    @Size(min=4)
    private String assignee;

    @NotNull
    @Size(min=5, max=255)
    private String description;

    @DateTimeFormat(pattern = "YYYY-mm-dd")
    //@FutureOrPresent()
    private Date dueTo;

}
