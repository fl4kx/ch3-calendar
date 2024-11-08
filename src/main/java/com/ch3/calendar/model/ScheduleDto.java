package com.ch3.calendar.model;

import com.ch3.calendar.domain.Schedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
@AllArgsConstructor
public class ScheduleDto {
    private Integer id;
    private String password;
    private String title;
    private String author;
    private Date registration_date;
    private Date modified_date;

    public ScheduleDto(Schedule schedule) {
        this.id = schedule.getId();
        this.password = schedule.getPassword();
        this.title = schedule.getTitle();
        this.author = schedule.getAuthor();
        this.registration_date = schedule.getRegistration_date();
        this.modified_date = schedule.getModified_date();
    }
}
