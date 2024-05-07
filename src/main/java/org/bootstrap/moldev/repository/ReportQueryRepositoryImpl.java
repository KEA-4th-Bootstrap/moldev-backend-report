package org.bootstrap.moldev.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.dto.response.ReportResponseDto;
import org.bootstrap.moldev.entity.ReportPost;
import org.bootstrap.moldev.entity.ReportReply;
import org.bootstrap.moldev.entity.ReportType;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.bootstrap.moldev.entity.QReport.report;
import static org.bootstrap.moldev.entity.QReportPost.reportPost;
import static org.bootstrap.moldev.entity.QReportReply.reportReply;


@Repository
@RequiredArgsConstructor
public class ReportQueryRepositoryImpl implements ReportQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ReportResponseDto> getReportListForResponse(Pageable pageable) {
        List<Long> reportIdList = jpaQueryFactory.select(report.id)
                .from(report)
                .orderBy(report.id.desc())
                .offset((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .fetch();

        List<ReportPost> reportPostList = jpaQueryFactory.selectFrom(reportPost)
                .where(reportPost.id.in(reportIdList))
                .fetch();

        List<ReportReply> reportReplyList = jpaQueryFactory.selectFrom(reportReply)
                .where(reportReply.id.in(reportIdList))
                .fetch();

        return Stream.concat(
                reportPostList.stream()
                        .map(reportPost -> ReportResponseDto.of(reportPost, ReportType.POST, reportPost.getPostId()))
                        .toList().stream(),
                reportReplyList.stream()
                        .map(reportReply -> ReportResponseDto.of(reportReply, ReportType.REPLY, reportReply.getReplyId()))
                        .toList().stream()
        ).sorted(Comparator.comparing(ReportResponseDto::reportId).reversed()).toList();

    }
}
