package org.bootstrap.moldev.repository;

import org.bootstrap.moldev.dto.response.ReportNotProcessedResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReportQueryRepository {
    List<ReportNotProcessedResponseDto> getReportListForResponseByProcessed(String search, Pageable pageable, boolean isProcessed);
}
