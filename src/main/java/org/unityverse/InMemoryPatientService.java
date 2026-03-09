package org.unityverse;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class InMemoryPatientService implements PatientService {

    private final AtomicInteger counter = new AtomicInteger(1000);
    private final CopyOnWriteArrayList<Patient> patients = new CopyOnWriteArrayList<>();

    @Override
    public Patient register(Patient patient) {
        patient.setPatientNo(counter.getAndIncrement());
        patients.add(patient);
        return patient;
    }

    @Override
    public List<Patient> findAll() {
        return List.copyOf(patients);
    }
}