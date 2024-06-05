package org.bootstrap.moldev.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.dto.request.BaseReportRequestDto;
import org.bootstrap.moldev.dto.response.ReportResponseDto;
import org.bootstrap.moldev.entity.ReportReply;
import org.bootstrap.moldev.repository.ReportReplyRepository;
import org.bootstrap.moldev.vo.ReportResponseVo;
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
    public ReportResponseDto getReportListIsProcessed(String search, Pageable pageable) {
        Page<ReportResponseVo> reportReplyListForResponseByProcessed = reportReplyRepository.getReportReplyListForResponseByProcessed(search, pageable, true);
        return ReportResponseDto.of(reportReplyListForResponseByProcessed);
    }

    @Override
    public ReportResponseDto getReportListIsNotProcessed(String search, Pageable pageable) {
        Page<ReportResponseVo> reportReplyListForResponseByProcessed = reportReplyRepository.getReportReplyListForResponseByProcessed(search, pageable, false);
        return ReportResponseDto.of(reportReplyListForResponseByProcessed);
    }
}
