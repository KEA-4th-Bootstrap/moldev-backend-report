package org.bootstrap.moldev.dto.request;

public record BaseReportRequestDto(
    ReportRequestDto reportRequestDto,
    ReportPostRequestDto reportPostRequestDto,
    ReportReplyRequestDto reportReplyRequestDto
) {
}
