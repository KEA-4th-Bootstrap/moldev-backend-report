package org.bootstrap.moldev.service;

import org.bootstrap.moldev.dto.request.BaseReportRequestDto;
import org.bootstrap.moldev.dto.response.ReportResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ReportService {
    void submitReport(BaseReportRequestDto baseReportRequestDto);
    Page<ReportResponseDto> getReportListIsProcessed(Pageable pageable);
    Page<ReportResponseDto> getReportListIsNotProcessed(Pageable pageable);
}
