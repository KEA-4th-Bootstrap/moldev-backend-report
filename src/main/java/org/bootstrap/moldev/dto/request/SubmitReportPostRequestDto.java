package org.bootstrap.moldev.dto.request;

public record SubmitReportPostRequestDto(
    Long postId,
    Long reporterId,
    Integer reasonCode
) {
}
