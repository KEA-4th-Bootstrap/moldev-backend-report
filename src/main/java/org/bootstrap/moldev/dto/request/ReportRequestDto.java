package org.bootstrap.moldev.dto.request;

public record ReportRequestDto(
    String reporterId,
    String reporteeId,
    Integer reasonCode
) {
}
