package com.masters.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "sce_stream", schema = "sce_course_temp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stream_id")
    private Integer streamId;

    @Column(name = "stream_name", nullable = false, length = 50)
    private String streamName;

    @Column(name = "stream_colour", length = 50)
    private String streamColour;

    @Column(name = "test_stream")
    private Integer testStream;

    @Column(name = "onsite_reg")
    private Integer onsiteReg;

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
}
