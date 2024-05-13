package org.bootstrap.moldev.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.moldev.entity.Report;
import org.bootstrap.moldev.entity.ReportType;

import java.time.LocalDateTime;

@Builder(access = AccessLevel.PRIVATE)
public record ReportResponseDto(
    Long reportId,
    ReportType reportType,
    Long reporterId,
    Long contentId,
    String reason,
    LocalDateTime reportTime
//    boolean isProcessed
) {
    public static ReportResponseDto of(Report report, ReportType reportType, Long contentId) {
        return ReportResponseDto.builder()
                .reportId(report.getId())
                .reportType(reportType)
                .reporterId(report.getReporterId())
                .contentId(contentId)
                .reason(report.getReason().getDesc())
                .reportTime(report.getCreateDate())
//                .isProcessed(report.isProcessed())
                .build();
    }
}
