package org.bootstrap.moldev.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.entity.ReportPost;
import org.bootstrap.moldev.entity.ReportReply;
import org.bootstrap.moldev.entity.ReportType;
import org.bootstrap.moldev.vo.ReportResponseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
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
    public Page<ReportResponseVo> getReportListForResponseByProcessed(String search, Pageable pageable, boolean isProcessed) {
        List<Long> reportIdList = jpaQueryFactory.select(report.id)
                .from(report)
                .where(
                        eqIsProcessed(isProcessed),
                        containsReporteeId(search)
                )
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

        List<ReportResponseVo> mergeList = Stream.concat(
                reportPostList.stream()
                        .map(reportPost -> ReportResponseVo.of(reportPost, ReportType.POST, reportPost.getPostId()))
                        .toList().stream(),
                reportReplyList.stream()
                        .map(reportReply -> ReportResponseVo.of(reportReply, ReportType.REPLY, reportReply.getReplyId()))
                        .toList().stream()
        ).sorted(Comparator.comparing(ReportResponseVo::reportId).reversed()).toList();

        return PageableExecutionUtils.getPage(mergeList, pageable, reportIdList::size);
    }

    private BooleanExpression eqIsProcessed(Boolean isProcessed) {
        return isProcessed == null ? null : report.isProcessed.eq(isProcessed);
    }

    private BooleanExpression containsReporteeId(String search) {
        return search == null ? null : report.reporteeId.contains(search);
    }
}
