package com.tats.attendance.controller;

import com.tats.attendance.model.Attendance;
import com.tats.attendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/clockin/{employeeId}")
    public Attendance clockIn(@PathVariable String employeeId) {
        return attendanceService.clockIn(employeeId);
    }

    @PutMapping("/clockout/{attendanceId}")
    public Attendance clockOut(@PathVariable String attendanceId) {
        return attendanceService.clockOut(attendanceId);
    }

    @GetMapping("/{employeeId}")
    public List<Attendance> getByEmployee(@PathVariable String employeeId) {
        return attendanceService.getAttendanceByEmployee(employeeId);
    }
}
