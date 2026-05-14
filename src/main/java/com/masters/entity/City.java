package com.masters.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "sce_city", schema = "sce_locations_temp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "city_code", length = 10)
    private String cityCode;

    @Column(name = "city_name", nullable = false, length = 50)
    private String cityName;

    @Column(name = "status", nullable = false)
    private Integer status = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private District district;

    @Column(name = "created_on", updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private LocalDateTime createdOn;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_on")
    @org.hibernate.annotations.UpdateTimestamp
    private LocalDateTime updatedOn;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "payroll_city_code", length = 10)
    private String payrollCityCode;

    // @PrePersist
    // protected void onCreate() {
    // if (this.createdOn == null) {
    // this.createdOn = LocalDateTime.now();
    // }
    // if (this.status == null) {
    // this.status = 1;
    // }
    // }

    // @PreUpdate
    // protected void onUpdate() {
    // this.updatedOn = LocalDateTime.now();
    // }
}
