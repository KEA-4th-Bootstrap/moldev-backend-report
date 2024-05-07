package org.bootstrap.moldev.service;

import org.bootstrap.moldev.entity.ReportRequestType;

public interface ReportServiceFactory {

    ReportService getReportService(ReportRequestType reportRequestType);
}
