package com.masters.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "sce_program_name", schema = "sce_course_temp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private Integer programId;

    @Column(name = "program_name", nullable = false, length = 50)
    private String programName;

    @Column(name = "class_id")
    private Integer classId;

    @Column(name = "promoting_program_id")
    private Integer promotingProgramId;

    @Column(name = "no_hours_day")
    private Integer noHoursDay;

    @Column(name = "no_days_week")
    private Integer noDaysWeek;

    @Column(name = "no_of_holidays")
    private Integer noOfHolidays;

    @Column(name = "status")
    private Integer status;

    @Column(name = "is_active", nullable = false)
    private Short isActive = 1;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "created_by", nullable = false)
    private Integer createdBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "start_time", length = 50)
    private String startTime;

    @Column(name = "end_time", length = 50)
    private String endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stream_id")
    private Stream stream;
}
