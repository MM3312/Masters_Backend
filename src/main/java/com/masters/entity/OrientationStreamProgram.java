package com.masters.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "sce_orientation_stream_program", schema = "sce_course_temp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrientationStreamProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orientation_stream_id")
    private Integer orientationStreamId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orientation_id", nullable = false)
    private Orientation orientation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stream_id", nullable = false)
    private Stream stream;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id", nullable = false)
    private Program program;

    @Column(name = "is_active", nullable = false)
    private Short isActive = 1;

    @Column(name = "created_by", nullable = false)
    private Integer createdBy = 1;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
}
