package com.masters.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "sce_zone", schema = "sce_locations_temp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zone_id")
    private Integer zoneId;

    @Column(name = "zone_name", nullable = false, length = 50)
    private String zoneName;

    @Column(name = "zh_email_id", length = 50)
    private String zhEmailId;

    @Column(name = "zh_address", length = 250)
    private String zhAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "zone", length = 100)
    private String zone;

    @Column(name = "created_on", updatable = false)
    private LocalDateTime createdOn;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @Column(name = "updated_by")
    private Integer updatedBy;
}
