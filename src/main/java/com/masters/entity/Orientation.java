package com.masters.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "sce_orientation", schema = "sce_course_temp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orientation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orientation_id")
    private Integer orientationId;

    @Column(name = "orientation_code", length = 100)
    private String orientationCode;

    @Column(name = "orientation_name", length = 100)
    private String orientationName;

    @Column(name = "acdc_id")
    private Integer acdcId;

    @Column(name = "class_id", nullable = false)
    private Integer classId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private OrientationGroup group;

    @Column(name = "study_type_id")
    private Integer studyTypeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_type_id")
    private TrackType trackType;

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
