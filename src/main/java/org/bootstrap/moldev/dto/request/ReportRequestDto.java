package org.bootstrap.moldev.dto.request;

import org.bootstrap.moldev.entity.ReasonType;

public record ReportRequestDto(
    String reporterId,
    String reporteeId,
    ReasonType reason
) {
}
