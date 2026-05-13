package com.masters.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "sce_sct_orientation", schema = "sce_course_temp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SctOrientation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sct_orientation_id")
    private Integer sctOrientationId;

    @Column(name = "section_id", nullable = false)
    private Integer sectionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmps_orientation_id", nullable = false)
    private CmpsOrientation cmpsOrientation;

    @Column(name = "sct_incharge_id")
    private Integer sctInchargeId;

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
}
