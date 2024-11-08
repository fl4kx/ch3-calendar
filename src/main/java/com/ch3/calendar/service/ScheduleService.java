package com.ch3.calendar.service;

import com.ch3.calendar.domain.Schedule;
import com.ch3.calendar.model.ScheduleDto;
import com.ch3.calendar.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleDto saveSchedule(ScheduleDto scheduleDto) {
        Date date = new Date();

        Schedule schedule = new Schedule(
                scheduleDto.getPassword(),
                scheduleDto.getAuthor(),
                scheduleDto.getTitle(),
                date,
                date
        );

        Schedule createdSchedule = scheduleRepository.createSchedule(schedule);

        return new ScheduleDto(createdSchedule);
    }

    public ScheduleDto getSchedule(int id) {
        return new ScheduleDto(scheduleRepository.getSchedule(id));
    }

    public List<ScheduleDto> getAllSchedules() {
        List<ScheduleDto> scheduleList = new ArrayList<>();

        scheduleRepository.getAllSchedules().forEach(schedule -> {
            scheduleList.add(new ScheduleDto(schedule));
        });

        return scheduleList;
    }

    public ScheduleDto modifySchedule(ScheduleDto scheduleDto) {

        return null;
    }


}
