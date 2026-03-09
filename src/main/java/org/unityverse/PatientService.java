package org.unityverse;

import java.util.List;

public interface PatientService {
    Patient register(Patient patient);
    List<Patient> findAll();
}