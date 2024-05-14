package org.bootstrap.moldev.service;

import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.dto.request.BaseReportRequestDto;
import org.bootstrap.moldev.dto.response.ReportNotProcessedResponseDto;
import org.bootstrap.moldev.entity.ReportPost;
import org.bootstrap.moldev.repository.ReportPostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service("POST")
public class ReportPostService implements ReportService {

    private final ReportPostRepository reportPostRepository;

    @Override
    public void submitReport(BaseReportRequestDto baseReportRequestDto) {
        ReportPost reportPost = ReportPost.of(baseReportRequestDto);
        reportPostRepository.save(reportPost);
    }

    @Override
    public Page<ReportNotProcessedResponseDto> getReportListIsProcessed(Pageable pageable) {
        return reportPostRepository.getReportPostListForResponseByProcessed(pageable, true);
    }

    @Override
    public Page<ReportNotProcessedResponseDto> getReportListIsNotProcessed(Pageable pageable) {
        return reportPostRepository.getReportPostListForResponseByProcessed(pageable, false);
    }
}
