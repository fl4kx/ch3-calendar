package com.ch3.calendar.repository;

import com.ch3.calendar.domain.Schedule;
import com.ch3.calendar.model.ScheduleDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Schedule createSchedule(Schedule schedule) {
        String sql = "INSERT INTO SCHEDULES (author, title, registration_date, modified_date, password) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, schedule.getAuthor(), schedule.getTitle(), schedule.getRegistration_date(), schedule.getModified_date(), schedule.getPassword());
        // Sql 실행해서 얻은 결과를 Entity 에 저장 생성, 수정

        return schedule;
    }

    public Schedule getSchedule(int id) {
        String sql = "SELECT id, title, author, registration_date, modified_date FROM SCHEDULES WHERE id = ?;";

        return jdbcTemplate.queryForObject(sql, scheduleRowMapper(), id);
    }

    public List<Schedule> getAllSchedules() {
        String selectAll = "SELECT id, title, author, registration_date, modified_date FROM SCHEDULES;";

        return jdbcTemplate.query(selectAll, scheduleRowMapper()).stream().toList();
    }

    public Schedule updateSchedule(Schedule schedule) {
        String sql = "UPDATE SCHEDULES SET author = ?, title = ?, modified_date = ? WHERE id = ?";

        jdbcTemplate.update(sql,schedule.getAuthor(),schedule.getTitle(), schedule.getModified_date());

        return schedule;
    }

    private RowMapper<Schedule> scheduleRowMapper() {
        return (rs, rowNum) -> new Schedule(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getDate("registration_date"),
                rs.getDate("modified_date")
        );

    }


}
