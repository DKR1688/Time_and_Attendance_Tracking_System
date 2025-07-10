package com.tats.attendance.service;

import com.tats.attendance.model.Attendance;
import com.tats.attendance.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance clockIn(String employeeId) {
        Attendance attendance = new Attendance();
        attendance.setEmployeeId(employeeId);
        attendance.setClockIn(LocalDateTime.now());
        return attendanceRepository.save(attendance);
    }

    public Attendance clockOut(String attendanceId) {
        Attendance attendance = attendanceRepository.findById(attendanceId).orElse(null);
        if (attendance != null) {
            attendance.setClockOut(LocalDateTime.now());
            return attendanceRepository.save(attendance);
        }
        return null;
    }

    public List<Attendance> getAttendanceByEmployee(String employeeId) {
        return attendanceRepository.findByEmployeeId(employeeId);
    }
}
