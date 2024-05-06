package org.bootstrap.moldev.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.bootstrap.moldev.dto.request.SubmitReportReplyRequestDto;
import org.bootstrap.moldev.util.EnumValueUtils;
import org.springframework.lang.NonNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
@Getter
@Table(name = "report_reply")
@Entity
public class ReportReply extends Report {

    @NonNull
    @Column(name = "reply_id")
    private Long replyId;

    public static ReportReply of(SubmitReportReplyRequestDto submitReportReplyRequestDto) {
        return ReportReply.builder()
                .replyId(submitReportReplyRequestDto.replyId())
                .reporterId(submitReportReplyRequestDto.reporterId())
                .reason(EnumValueUtils.toEntityCode(ReasonType.class, submitReportReplyRequestDto.reasonCode()))
                .build();
    }
}
