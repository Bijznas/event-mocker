package com.event.mocker.services;

import com.event.mocker.entities.Process;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by sanjib on 2/5/17.
 */
public interface ProcessService {
    void save(Process process);

    Process update(Process process);

    List<Process> getAll();

    JSONObject getProcessCount();
}
