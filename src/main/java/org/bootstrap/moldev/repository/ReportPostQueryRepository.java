package org.bootstrap.moldev.repository;

import org.bootstrap.moldev.dto.response.ReportNotProcessedResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReportPostQueryRepository {
    Page<ReportNotProcessedResponseDto> getReportPostListForResponseByProcessed(String search, Pageable pageable, boolean isProcessed);
}
