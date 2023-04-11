package peaksoft.service.impl;

import org.springframework.stereotype.Service;
import peaksoft.dto.request.ScheduleRequest;
import peaksoft.dto.request.response.SimpleResponse;
import peaksoft.entity.Doctors;
import peaksoft.entity.Schedule;
import peaksoft.repository.DoctorsRepository;
import peaksoft.repository.ScheduleRepository;
import peaksoft.repository.ServiceRepository;
import peaksoft.service.AccountService;
import java.util.NoSuchElementException;

@Service
public class AccountServiceImpl implements AccountService {
    private final ScheduleRepository repository;
    private final DoctorsRepository doctorsRepository;
    private final ServiceRepository serviceRepository;

    public AccountServiceImpl(ScheduleRepository repository, DoctorsRepository doctorsRepository, ServiceRepository serviceRepository) {
        this.repository = repository;
        this.doctorsRepository = doctorsRepository;
        this.serviceRepository = serviceRepository;
    }

    @Override
    public SimpleResponse createSchedule(ScheduleRequest request){
        Schedule schedule = new Schedule();
        Doctors doctor = doctorsRepository.findById(request.doctorId())
                .orElseThrow(NoSuchElementException::new);
        schedule.setDoctors(doctor);
        peaksoft.entity.Service service = serviceRepository.findById(request.serviceId())
                .orElseThrow(NoSuchElementException::new);
        schedule.setService(service);
        schedule.setDateOfStart(request.dateOfStart());
        schedule.setDateOfFinish(request.dateOfFinish());
        schedule.setStartTime(request.timeStart());
        schedule.setFinishTime(request.timeFinish());
        schedule.setLunchTo(request.breakTimeStart());
        schedule.setLunchTo(request.breakTimeFinish());
        schedule.setIntervalOfHours(request.interval());
        schedule.setTypeOfRepetition(request.repetition());
        schedule.setRepeatDays(request.repeatDay());
        repository.save(schedule);
        return new SimpleResponse("OK","Create");
    }
}
