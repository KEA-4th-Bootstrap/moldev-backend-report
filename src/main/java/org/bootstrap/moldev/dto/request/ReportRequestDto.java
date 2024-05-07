package org.bootstrap.moldev.dto.request;

public record ReportRequestDto(
    Long reporterId,
    Integer reasonCode
) {
}
