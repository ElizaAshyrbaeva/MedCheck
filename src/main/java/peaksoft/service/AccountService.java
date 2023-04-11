package peaksoft.service;

import peaksoft.dto.request.ScheduleRequest;
import peaksoft.dto.request.response.SimpleResponse;

public interface AccountService {
    SimpleResponse createSchedule(ScheduleRequest request);
}
