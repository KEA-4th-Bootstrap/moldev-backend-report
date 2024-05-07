package org.bootstrap.moldev.service;

import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.dto.request.BaseReportRequestDto;
import org.bootstrap.moldev.entity.ReportPost;
import org.bootstrap.moldev.repository.ReportPostRepository;
import org.bootstrap.moldev.repository.ReportRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service("POST")
public class ReportPostService implements ReportService {

    private final ReportRepository reportRepository;
    private final ReportPostRepository reportPostRepository;

    @Override
    public void submitReport(BaseReportRequestDto baseReportRequestDto) {
        ReportPost reportPost = ReportPost.of(baseReportRequestDto);
        reportPostRepository.save(reportPost);
    }
}
