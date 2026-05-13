package com.masters.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "sce_cmps_orientation", schema = "sce_course_temp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CmpsOrientation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cmps_orientation_id")
    private Integer cmpsOrientationId;

    @Column(name = "cmps_id")
    private Integer cmpsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orientation_id")
    private Orientation orientation;

    @Column(name = "acdc_year_id", nullable = false)
    private Integer acdcYearId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orientation_batch_id")
    private OrientationBatch orientationBatch;

    @Column(name = "orientation_fee", nullable = false)
    private Double orientationFee;

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

    @Column(name = "org_concession")
    private Double orgConcession;

    @Column(name = "branch_concession")
    private Double branchConcession;

    @Column(name = "stud_type_id")
    private Integer studTypeId;

    @Column(name = "term1_fee")
    private Double term1Fee;

    @Column(name = "term1_due_date")
    private LocalDate term1DueDate;

    @Column(name = "term2_fee")
    private Double term2Fee;

    @Column(name = "term2_due_date")
    private LocalDate term2DueDate;

    @Column(name = "term3_fee")
    private Double term3Fee;

    @Column(name = "term3_due_date")
    private LocalDate term3DueDate;
}
