package org.bootstrap.moldev.repository;

import org.bootstrap.moldev.dto.response.ReportNotProcessedResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReportReplyQueryRepository {
    Page<ReportNotProcessedResponseDto> getReportReplyListForResponseByProcessed(Pageable pageable, boolean isProcessed);
}
