package org.bootstrap.moldev.dto.request;

public record BaseReportRequestDto<T>(
    ReportRequestDto reportRequestDto,
    T contentId
) {
}
