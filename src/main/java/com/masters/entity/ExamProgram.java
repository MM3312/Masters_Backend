package com.masters.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "sce_exam_program", schema = "sce_course_temp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_program_id")
    private Integer examProgramId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stream_id", nullable = false)
    private Stream stream;

    @Column(name = "exam_program_name", length = 50)
    private String examProgramName;

    @Column(name = "acdc_id", nullable = false)
    private Integer acdcId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id")
    private Program program;

    @Column(name = "class_id")
    private Integer classId;

    @Column(name = "target_exam", length = 50)
    private String targetExam;

    @Column(name = "status")
    private Short status;

    @Column(name = "is_active", nullable = false)
    private Short isActive = 1;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "created_by", nullable = false)
    private Integer createdBy = 1;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "new_class_id")
    private Integer newClassId;
}
