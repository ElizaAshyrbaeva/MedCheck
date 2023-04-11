package peaksoft.dto.request;

import lombok.Builder;
import peaksoft.enums.Repeat;
import peaksoft.enums.Repetition;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

@Builder
public record ScheduleRequest(LocalDate dateOfStart,
                              LocalDate dateOfFinish,
                              LocalTime timeStart,
                              LocalTime timeFinish,
                              LocalTime breakTimeStart,
                              LocalTime breakTimeFinish,
                              int interval,
                              Repetition repetition,
                              Map<Repeat, Boolean> repeatDay,
                              Long doctorId,
                              Long serviceId) {
}
