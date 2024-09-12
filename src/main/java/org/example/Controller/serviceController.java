package org.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.example.Services.LogEntry;
import org.example.Services.FindLogs;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class serviceController {
    @Autowired
    private FindLogs findLogs;

    @PostMapping("/log")
    public List<LogEntry> logMessage(@RequestBody String message) {
        LogEntry logEntry = new LogEntry();
        logEntry.setMessage(message);
        logEntry.setTimestamp(LocalDateTime.now());
        findLogs.save(logEntry);

        return findLogs.findTop10ByOrderByTimestampDesc();
    }
}
