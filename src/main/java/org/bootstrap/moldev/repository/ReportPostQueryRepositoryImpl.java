package org.bootstrap.moldev.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.bootstrap.moldev.dto.response.ReportResponseDto;
import org.bootstrap.moldev.entity.ReportPost;
import org.bootstrap.moldev.entity.ReportType;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.bootstrap.moldev.entity.QReportPost.reportPost;

@Repository
@RequiredArgsConstructor
public class ReportPostQueryRepositoryImpl implements ReportPostQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ReportResponseDto> getReportPostListForResponse(Pageable pageable) {
        List<ReportPost> reportPostList = jpaQueryFactory.selectFrom(reportPost)
                .orderBy(reportPost.id.desc())
                .offset((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .fetch();

        return reportPostList.stream()
                .map(reportPost -> ReportResponseDto.of(reportPost, ReportType.POST, reportPost.getPostId()))
                .toList();
    }
}
