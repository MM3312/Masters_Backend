package com.masters.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "sce_district", schema = "sce_locations_temp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "district_id")
  private Integer districtId;

  @Column(name = "district_name", nullable = false, length = 50)
  private String districtName;

  @Column(name = "status", nullable = false)
  private Integer status = 1;

  @Column(name = "state_id", nullable = true)
  private Integer stateId;

  @Column(name = "created_on", updatable = false)
  private LocalDateTime createdOn;

  @Column(name = "created_by")
  private Integer createdBy;

  @Column(name = "updated_on")
  private LocalDateTime updatedOn;

  @Column(name = "updated_by")
  private Integer updatedBy;

  // @PrePersist
  // protected void onCreate() {
  // if (this.createdOn == null) {
  // this.createdOn = LocalDateTime.now();
  // }
  // }

  @PreUpdate
  protected void onUpdate() {
    this.updatedOn = LocalDateTime.now();
  }
}
