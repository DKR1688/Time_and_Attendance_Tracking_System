package com.tats.attendance.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("attendance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {
    @Id
    private String id;
    private String employeeId;
    private LocalDateTime clockIn;
    private LocalDateTime clockOut;
}
