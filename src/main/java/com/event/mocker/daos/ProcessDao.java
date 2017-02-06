package com.event.mocker.daos;

import com.event.mocker.entities.Process;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by leapfrog on 2/5/17.
 */
public interface ProcessDao {

    void save(Process process);

    Process update(Process process);

    JSONObject getProcessCount();

    List<Process> getAll();
}
