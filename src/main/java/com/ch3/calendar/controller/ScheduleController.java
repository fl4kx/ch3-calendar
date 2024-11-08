package com.ch3.calendar.controller;

import com.ch3.calendar.model.ScheduleDto;
import com.ch3.calendar.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/schedules")
@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping(value = "/post", headers = "Content-Type=application/json")
    public ResponseEntity<ScheduleDto> scheduleInput(@RequestBody ScheduleDto scheduleDto) {

        return new ResponseEntity<>(scheduleService.saveSchedule(scheduleDto), HttpStatus.CREATED);
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleDto> getSchedule(@PathVariable int scheduleId) {
        return new ResponseEntity<>(scheduleService.getSchedule(scheduleId), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ScheduleDto>> getAllSchedule() {
        return new ResponseEntity<>(scheduleService.getAllSchedules(), HttpStatus.OK);
    }

    @PutMapping(value = "/{scheduleId}")
    public ResponseEntity<ScheduleDto> modifySchedule(@PathVariable String scheduleId) {

        return null;
    }

    @DeleteMapping(value = "/{scheduleId}")
    public ResponseEntity<String> deleteSchedule(@PathVariable String scheduleId) {
        String message = "Success";

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}

