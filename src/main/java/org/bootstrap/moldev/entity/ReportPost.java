package org.bootstrap.moldev.entity;

import jakarta.persistence.*;
import lombok.*;
import org.bootstrap.moldev.common.BaseTimeEntity;
import org.bootstrap.moldev.dto.request.SubmitReportPostRequestDto;
import org.bootstrap.moldev.entity.converter.ReasonTypeConverter;
import org.bootstrap.moldev.util.EnumValueUtils;
import org.springframework.lang.NonNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "report_post")
@Entity
public class ReportPost extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;

    @NonNull
    @Column(name = "post_id")
    private Long postId;

    @NonNull
    @Column(name = "reporter_id")
    private Long reporterId;

    @NonNull
    @Convert(converter = ReasonTypeConverter.class)
    private ReasonType reason;

    @Column(name = "is_processed")
    @Builder.Default
    private boolean isProcessed = false;

    public static ReportPost of(SubmitReportPostRequestDto fileReportRequestDto) {
        return ReportPost.builder()
                .postId(fileReportRequestDto.postId())
                .reporterId(fileReportRequestDto.reporterId())
                .reason(EnumValueUtils.toEntityCode(ReasonType.class, fileReportRequestDto.reasonCode()))
                .build();
    }
}
