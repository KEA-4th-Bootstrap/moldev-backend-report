package org.bootstrap.moldev.dto.response;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record SubmitReportReplyResponseDto(
    Long id
) {
    public static SubmitReportReplyResponseDto of(Long id) {
        return SubmitReportReplyResponseDto.builder()
                .id(id)
                .build();
    }
}
