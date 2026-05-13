package com.masters.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "sce_orientation_batch", schema = "sce_course_temp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrientationBatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orientation_batch_id")
    private Integer orientationBatchId;

    @Column(name = "orientation_batch_name", nullable = false, length = 50)
    private String orientationBatchName;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "acdc_id")
    private Integer acdcId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "display_name", length = 50)
    private String displayName;

    @Column(name = "orientation_duration")
    private Integer orientationDuration;

    @Column(name = "is_active", nullable = false)
    private Short isActive = 1;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "created_by")
    private Integer createdBy = 1;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "updated_by")
    private Integer updatedBy;
}
