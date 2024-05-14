package org.bootstrap.moldev.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.moldev.entity.Report;
import org.bootstrap.moldev.entity.ReportType;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder(access = AccessLevel.PRIVATE)
public record ReportProcessedResponseDto(
    Long reportId,
    ReportType reportType,
    Long reporterId,
    Long contentId,
    String reason,
    LocalDate reportDate,
    LocalDate processDate
) {
    public static ReportProcessedResponseDto of(Report report, ReportType reportType, Long contentId) {
        return ReportProcessedResponseDto.builder()
                .reportId(report.getId())
                .reportType(reportType)
                .reporterId(report.getReporterId())
                .contentId(contentId)
                .reason(report.getReason().getDesc())
                .reportDate(report.getCreateDate().toLocalDate())
                .processDate(report.getLastModifiedDate().toLocalDate())
                .build();
    }
}
