package org.bootstrap.moldev.service;

import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.dto.response.ReportNotProcessedResponseDto;
import org.bootstrap.moldev.repository.ReportRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ReportIntegrationService {

    private final ReportRepository reportRepository;

    public Page<ReportNotProcessedResponseDto> getReportListIsProcessed(String search, Pageable pageable) {
        return reportRepository.getReportListForResponseByProcessed(search, pageable, true);
    }

    public Page<ReportNotProcessedResponseDto> getReportListIsNotProcessed(String search, Pageable pageable) {
        return reportRepository.getReportListForResponseByProcessed(search, pageable, false);
    }
}
