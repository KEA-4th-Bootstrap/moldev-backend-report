package org.bootstrap.moldev.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bootstrap.moldev.common.BaseTimeEntity;
import org.bootstrap.moldev.dto.request.ReportRequestDto;
import org.bootstrap.moldev.entity.converter.ReasonTypeConverter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "report_type")
public abstract class Report extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;

    @Column(name = "reporter_id", nullable = false)
    private String reporterId;

    @Column(name = "reportee_id", nullable = false)
    private String reporteeId;

    @Convert(converter = ReasonTypeConverter.class)
    private ReasonType reason;

    @Column(name = "is_processed")
    private boolean isProcessed;

    public Report(ReportRequestDto reportRequestDto) {
        this.reporterId = reportRequestDto.reporterId();
        this.reporteeId = reportRequestDto.reporteeId();
        this.reason = reportRequestDto.reason();
        this.isProcessed = false;
    }

    public void updateProcess(boolean isProcessed) {
        this.isProcessed = isProcessed;
    }
}
