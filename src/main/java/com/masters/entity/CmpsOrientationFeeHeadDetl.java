package com.masters.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "sce_cmps_orientation_fee_head_detl", schema = "sce_course_temp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CmpsOrientationFeeHeadDetl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cmps_orientation_fee_head_id")
    private Integer cmpsOrientationFeeHeadId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmps_orientation_id")
    private CmpsOrientation cmpsOrientation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "term_id")
    private TermMaster term;

    @Column(name = "transaction_head_id")
    private Integer transactionHeadId;

    @Column(name = "fee")
    private BigDecimal fee;

    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "term_concession_priorty")
    private Short termConcessionPriority;

    @Column(name = "payment_priority")
    private Integer paymentPriority;

    @Column(name = "payment_head_calculation_type", length = 50)
    private String paymentHeadCalculationType;

    @Column(name = "deduction_priority")
    private Short deductionPriority;

    @Column(name = "deduction_head_calculation_type", length = 50)
    private String deductionHeadCalculationType;

    @Column(name = "concession_priority")
    private Short concessionPriority;

    @Column(name = "concesion_head_calculation_type", length = 50)
    private String concesionHeadCalculationType;

    @Column(name = "app_sale_head_priorty")
    private Short appSaleHeadPriority;

    @Column(name = "org_id")
    private Integer orgId;

    @Column(name = "is_active", nullable = false)
    private Short isActive = 1;

    @Column(name = "created_by", nullable = false)
    private Integer createdBy;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
}
