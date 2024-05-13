package org.bootstrap.moldev.repository;

import org.bootstrap.moldev.dto.response.ReportResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReportReplyQueryRepository {
    Page<ReportResponseDto> getReportReplyListForResponseByProcessed(Pageable pageable, boolean isProcessed);
}
