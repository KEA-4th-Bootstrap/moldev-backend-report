package org.bootstrap.moldev.vo;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.moldev.entity.Report;
import org.bootstrap.moldev.entity.ReportType;

import java.time.LocalDate;

@Builder(access = AccessLevel.PRIVATE)
public record ReportResponseVo(
    Long reportId,
    ReportType reportType,
    String reporterId,
    String reporteeId,
    Object contentId,
    String reason,
    LocalDate reportDate,
    LocalDate processDate
) {
    public static ReportResponseVo of(Report report, ReportType reportType, Object contentId) {
        return ReportResponseVo.builder()
                .reportId(report.getId())
                .reportType(reportType)
                .reporterId(report.getReporterId())
                .reporteeId(report.getReporteeId())
                .contentId(contentId)
                .reason(report.getReason().getDesc())
                .reportDate(report.getCreateDate().toLocalDate())
                .processDate(report.getLastModifiedDate().toLocalDate())
                .build();
    }
}
