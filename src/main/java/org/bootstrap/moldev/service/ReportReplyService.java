package org.bootstrap.moldev.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.dto.request.BaseReportRequestDto;
import org.bootstrap.moldev.dto.response.ReportResponseDto;
import org.bootstrap.moldev.entity.ReportReply;
import org.bootstrap.moldev.repository.ReportReplyRepository;
import org.bootstrap.moldev.repository.ReportRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Transactional
@Service("REPLY")
public class ReportReplyService implements ReportService {

    private final ReportReplyRepository reportReplyRepository;

    @Override
    public void submitReport(BaseReportRequestDto baseReportRequestDto) {
        ReportReply reportReply = ReportReply.of(baseReportRequestDto);
        reportReplyRepository.save(reportReply);
    }

    @Override
    public Page<ReportResponseDto> getReportListIsProcessed(Pageable pageable) {
        return reportReplyRepository.getReportReplyListForResponseByProcessed(pageable, true);
    }

    @Override
    public Page<ReportResponseDto> getReportListIsNotProcessed(Pageable pageable) {
        return reportReplyRepository.getReportReplyListForResponseByProcessed(pageable, false);
    }
}
