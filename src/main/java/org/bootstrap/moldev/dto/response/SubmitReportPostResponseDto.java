package org.bootstrap.moldev.dto.response;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record SubmitReportPostResponseDto(
    Long id
) {
    public static SubmitReportPostResponseDto of(Long id) {
        return SubmitReportPostResponseDto.builder()
                .id(id)
                .build();
    }
}
