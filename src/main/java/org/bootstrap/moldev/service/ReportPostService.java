package org.bootstrap.moldev.service;

import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.dto.request.BaseReportRequestDto;
import org.bootstrap.moldev.dto.response.ReportResponseDto;
import org.bootstrap.moldev.entity.ReportPost;
import org.bootstrap.moldev.repository.ReportPostRepository;
import org.bootstrap.moldev.vo.ReportResponseVo;
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
    public ReportResponseDto getReportListIsProcessed(String search, Pageable pageable) {
        Page<ReportResponseVo> reportPostListForResponseByProcessed = reportPostRepository.getReportPostListForResponseByProcessed(search, pageable, true);
        return ReportResponseDto.of(reportPostListForResponseByProcessed);
    }

    @Override
    public ReportResponseDto getReportListIsNotProcessed(String search, Pageable pageable) {
        Page<ReportResponseVo> reportPostListForResponseByProcessed = reportPostRepository.getReportPostListForResponseByProcessed(search, pageable, false);
        return ReportResponseDto.of(reportPostListForResponseByProcessed);
    }
}
