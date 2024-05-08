package org.bootstrap.moldev.service;

import org.bootstrap.moldev.entity.ReportType;

public interface ReportServiceFactory {

    ReportService getReportService(ReportType reportType);
}
