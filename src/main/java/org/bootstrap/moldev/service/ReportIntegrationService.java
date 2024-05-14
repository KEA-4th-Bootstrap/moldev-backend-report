package org.bootstrap.moldev.service;

import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.dto.response.ReportNotProcessedResponseDto;
import org.bootstrap.moldev.repository.ReportRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ReportIntegrationService {

    private final ReportRepository reportRepository;

    public List<ReportNotProcessedResponseDto> getReportListIsProcessed(Pageable pageable) {
        return reportRepository.getReportListForResponseByProcessed(pageable, true);
    }

    public List<ReportNotProcessedResponseDto> getReportListIsNotProcessed(Pageable pageable) {
        return reportRepository.getReportListForResponseByProcessed(pageable, false);
    }
}
