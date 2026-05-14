package com.masters.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sce_country", schema = "sce_locations_temp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer countryId;

    @Column(name = "country_name", nullable = false, length = 50)
    private String countryName;

    @Column(name = "status", nullable = false, insertable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer status;

    @Column(name = "created_on", insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime createdOn;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_on")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime updatedOn;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "country_cont_no")
    private String countryContNo;

    @PreUpdate
    protected void onUpdate() {
        this.updatedOn = LocalDateTime.now();
    }
}
