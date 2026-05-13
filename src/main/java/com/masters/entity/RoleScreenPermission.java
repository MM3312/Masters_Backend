package com.masters.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "sce_role_screen_per", schema = "sce_admin_temp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleScreenPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_screen_per_id")
    private Integer roleScreenPermissionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_permission_id", nullable = false)
    private ScreenPermission screenPermission;

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
