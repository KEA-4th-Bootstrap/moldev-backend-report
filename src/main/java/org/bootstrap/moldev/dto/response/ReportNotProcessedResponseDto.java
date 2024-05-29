package org.bootstrap.moldev.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.moldev.entity.Report;
import org.bootstrap.moldev.entity.ReportType;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder(access = AccessLevel.PRIVATE)
public record ReportNotProcessedResponseDto(
    Long reportId,
    ReportType reportType,
    String reporterId,
    String reporteeId,
    Object contentId,
    String reason,
    LocalDate reportDate
) {
    public static ReportNotProcessedResponseDto of(Report report, ReportType reportType, Object contentId) {
        return ReportNotProcessedResponseDto.builder()
                .reportId(report.getId())
                .reportType(reportType)
                .reporterId(report.getReporterId())
                .reporteeId(report.getReporteeId())
                .contentId(contentId)
                .reason(report.getReason().getDesc())
                .reportDate(report.getCreateDate().toLocalDate())
                .build();
    }
}
