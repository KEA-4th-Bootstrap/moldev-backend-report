package org.bootstrap.moldev.service;

import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.dto.request.BaseReportRequestDto;
import org.bootstrap.moldev.dto.response.ReportResponseDto;
import org.bootstrap.moldev.entity.ReportPost;
import org.bootstrap.moldev.repository.ReportPostRepository;
import org.bootstrap.moldev.repository.ReportRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Page<ReportResponseDto> getReportListIsProcessed(Pageable pageable) {
        return reportPostRepository.getReportPostListForResponseByProcessed(pageable, true);
    }

    @Override
    public Page<ReportResponseDto> getReportListIsNotProcessed(Pageable pageable) {
        return reportPostRepository.getReportPostListForResponseByProcessed(pageable, false);
    }
}
