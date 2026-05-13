package com.masters.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "sce_term_master", schema = "sce_course_temp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TermMaster {

    @Id
    @Column(name = "term_id")
    private Integer termId;

    @Column(name = "term_name", length = 20)
    private String termName;

    @Column(name = "is_active")
    private Short isActive;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
}
