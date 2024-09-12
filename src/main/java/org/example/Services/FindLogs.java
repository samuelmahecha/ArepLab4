package org.example.Services;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.example.Services.LogEntry;

public interface FindLogs extends MongoRepository<LogEntry, String>  {
    List<LogEntry> findTop10ByOrderByTimestampDesc();
}
