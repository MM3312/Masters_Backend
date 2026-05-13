package com.masters.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "sce_pin_code", schema = "sce_locations_temp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PinCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pin_code_id")
    private Integer pinCodeId;

    @Column(name = "office_name", length = 60)
    private String officeName;

    @Column(name = "office_status", length = 60)
    private String officeStatus;

    @Column(name = "pin_code")
    private Integer pinCode;

    @Column(name = "telephone_no", length = 50)
    private String telephoneNo;

    @Column(name = "taluk", length = 50)
    private String taluk;

    @Column(name = "postal_district_name", length = 50)
    private String postalDistrictName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private District district;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    private State state;

    @Column(name = "postal_division", length = 50)
    private String postalDivision;

    @Column(name = "postal_region", length = 50)
    private String postalRegion;

    @Column(name = "postal_circle", length = 50)
    private String postalCircle;

    @Column(name = "scaits_pin_id")
    private Long scaitsPinId;

    @Column(name = "is_active", nullable = false)
    private Integer isActive = 1;

    @Column(name = "created_by", nullable = false)
    private Integer createdBy = 1;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
}
