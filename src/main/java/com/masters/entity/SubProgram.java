package com.masters.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "sce_sub_program", schema = "sce_course_temp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_program_id")
    private Integer subProgramId;

    @Column(name = "sub_program_name", nullable = false, length = 50)
    private String subProgramName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id", nullable = false)
    private Program program;

    @Column(name = "acdc_id", nullable = false)
    private Integer acdcId;

    @Column(name = "status", nullable = false)
    private Short status;

    @Column(name = "is_active", nullable = false)
    private Short isActive = 1;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "created_by", nullable = false)
    private Short createdBy = 1;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "updated_by")
    private Integer updatedBy;
}
