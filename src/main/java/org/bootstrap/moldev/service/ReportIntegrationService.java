package org.bootstrap.moldev.service;

import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.dto.response.ReportResponseDto;
import org.bootstrap.moldev.repository.ReportPostRepository;
import org.bootstrap.moldev.repository.ReportReplyRepository;
import org.bootstrap.moldev.repository.ReportRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Transactional
@Service
public class ReportIntegrationService {

    private final ReportRepository reportRepository;
    private final ReportPostRepository reportPostRepository;
    private final ReportReplyRepository reportReplyRepository;

    public List<ReportResponseDto> getReportList(Pageable pageable) {
        return reportRepository.getReportListForResponse(pageable);
    }
}
