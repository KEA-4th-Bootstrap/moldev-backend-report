package org.bootstrap.moldev.service;

import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.common.error.GlobalErrorCode;
import org.bootstrap.moldev.dto.response.ReportResponseDto;
import org.bootstrap.moldev.entity.Report;
import org.bootstrap.moldev.exception.EntityNotFoundException;
import org.bootstrap.moldev.repository.ReportRepository;
import org.bootstrap.moldev.vo.ReportResponseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ReportIntegrationService {

    private final ReportRepository reportRepository;

    public ReportResponseDto getReportListIsProcessed(String search, Pageable pageable) {
        Page<ReportResponseVo> reportListForResponseByProcessed = reportRepository.getReportListForResponseByProcessed(search, pageable, true);
        return ReportResponseDto.of(reportListForResponseByProcessed);
    }

    public ReportResponseDto getReportListIsNotProcessed(String search, Pageable pageable) {
        Page<ReportResponseVo> reportListForResponseByProcessed = reportRepository.getReportListForResponseByProcessed(search, pageable, false);
        return ReportResponseDto.of(reportListForResponseByProcessed);

    }

    public void updateReportProcessed(Long reportId) {
        Report report = getReport(reportId);
        report.updateProcess(true);
    }

    private Report getReport(Long reportId) {
        return reportRepository.findById(reportId)
                .orElseThrow(() -> new EntityNotFoundException(GlobalErrorCode.ENTITY_NOT_FOUND));
    }
}
