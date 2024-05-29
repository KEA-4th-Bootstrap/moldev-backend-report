package org.bootstrap.moldev.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.bootstrap.moldev.dto.request.BaseReportRequestDto;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "report_reply")
@Entity
@OnDelete(action = OnDeleteAction.CASCADE)
public class ReportReply extends Report {

    @Column(name = "reply_id", nullable = false)
    private String replyId;

    @Builder(access = AccessLevel.PRIVATE)
    public ReportReply(BaseReportRequestDto baseReportRequestDto) {
        super(baseReportRequestDto.reportRequestDto());
        this.replyId = (String)baseReportRequestDto.contentId();
    }

    public static ReportReply of(BaseReportRequestDto baseReportRequestDto) {
        return ReportReply.builder()
                .baseReportRequestDto(baseReportRequestDto)
                .build();
    }
}
