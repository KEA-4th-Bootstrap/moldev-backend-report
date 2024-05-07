package org.bootstrap.moldev.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.bootstrap.moldev.common.BaseTimeEntity;
import org.bootstrap.moldev.dto.request.ReportRequestDto;
import org.bootstrap.moldev.entity.converter.ReasonTypeConverter;
import org.bootstrap.moldev.util.EnumValueUtils;
import org.springframework.lang.NonNull;

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
    private Long reporterId;

    @Convert(converter = ReasonTypeConverter.class)
    @Column(nullable = false)
    private ReasonType reason;

    @Column(name = "is_processed")
    private boolean isProcessed;

    public Report(ReportRequestDto reportRequestDto) {
        this.reporterId = reportRequestDto.reporterId();
        this.reason = EnumValueUtils.toEntityCode(ReasonType.class, reportRequestDto.reasonCode());
        this.isProcessed = false;
    }
}
