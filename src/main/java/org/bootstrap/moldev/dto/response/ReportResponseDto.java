package org.bootstrap.moldev.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.moldev.common.PageInfo;
import org.bootstrap.moldev.vo.ReportResponseVo;
import org.springframework.data.domain.Page;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record ReportResponseDto(
        List<ReportResponseVo> reportResponseVo,
        PageInfo pageInfo
) {
    public static ReportResponseDto of(Page<ReportResponseVo> reportList) {
        return ReportResponseDto.builder()
                .reportResponseVo(reportList.getContent())
                .pageInfo(PageInfo.of(reportList))
                .build();
    }
}
