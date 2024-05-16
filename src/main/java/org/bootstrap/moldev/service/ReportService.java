package org.bootstrap.moldev.service;

import org.bootstrap.moldev.dto.request.BaseReportRequestDto;
import org.bootstrap.moldev.dto.response.ReportNotProcessedResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ReportService {
    void submitReport(BaseReportRequestDto baseReportRequestDto);
    Page<ReportNotProcessedResponseDto> getReportListIsProcessed(String search, Pageable pageable);
    Page<ReportNotProcessedResponseDto> getReportListIsNotProcessed(String search, Pageable pageable);
}
