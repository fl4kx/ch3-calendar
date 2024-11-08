package com.ch3.calendar.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;



@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Schedule {
    private Integer id;
    private String password;
    private String title;
    private String author;
    private Date registration_date;
    private Date modified_date;


    @Builder
    public Schedule(String password, String title, String author, Date registration_date, Date modified_date) {
        this.password = password;
        this.title = title;
        this.author = author;
        this.registration_date = registration_date;
        this.modified_date = modified_date;
    }

    public Schedule(int id, String title, String author, Date registration_date, Date modified_date) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.registration_date = registration_date;
        this.modified_date = modified_date;

    }

}
