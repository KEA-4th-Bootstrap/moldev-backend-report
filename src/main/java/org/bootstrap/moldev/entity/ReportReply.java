package org.bootstrap.moldev.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.bootstrap.moldev.dto.request.BaseReportRequestDto;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "report_reply")
@Entity
public class ReportReply extends Report {

    @Column(name = "reply_id", nullable = false)
    private Long replyId;

    @Builder(access = AccessLevel.PRIVATE)
    public ReportReply(BaseReportRequestDto baseReportRequestDto) {
        super(baseReportRequestDto.reportRequestDto());
        this.replyId = baseReportRequestDto.reportReplyRequestDto().replyId();
    }

    public static ReportReply of(BaseReportRequestDto baseReportRequestDto) {
        return ReportReply.builder()
                .baseReportRequestDto(baseReportRequestDto)
                .build();
    }
}
