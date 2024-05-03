package org.bootstrap.moldev.entity;

import jakarta.persistence.*;
import lombok.*;
import org.bootstrap.moldev.common.BaseTimeEntity;
import org.bootstrap.moldev.dto.request.SubmitReportReplyRequestDto;
import org.bootstrap.moldev.entity.converter.ReasonTypeConverter;
import org.bootstrap.moldev.util.EnumValueUtils;
import org.springframework.lang.NonNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "report_reply")
@Entity
public class ReportReply extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;

    @NonNull
    @Column(name = "reply_id")
    private Long replyId;

    @NonNull
    @Column(name = "reporter_id")
    private Long reporterId;

    @NonNull
    @Convert(converter = ReasonTypeConverter.class)
    private ReasonType reason;

    @Column(name = "is_processed")
    @Builder.Default
    private boolean isProcessed = false;

    public static ReportReply of(SubmitReportReplyRequestDto submitReportReplyRequestDto) {
        return ReportReply.builder()
                .replyId(submitReportReplyRequestDto.replyId())
                .reporterId(submitReportReplyRequestDto.reporterId())
                .reason(EnumValueUtils.toEntityCode(ReasonType.class, submitReportReplyRequestDto.reasonCode()))
                .build();
    }
}
