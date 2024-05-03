package org.bootstrap.moldev.dto.request;

public record SubmitReportReplyRequestDto(
    Long replyId,
    Long reporterId,
    Integer reasonCode
) {
}
