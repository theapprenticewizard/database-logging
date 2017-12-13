package com.theapprenticewizard.databaselogging.application;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MongoDbLogger extends Logger {

    private LoggableRepository loggableRepository;

    protected MongoDbLogger(@Value("${logger.name}") String name) {
        super(name);
    }

    @Autowired
    public void setLoggableRepository(LoggableRepository loggableRepository) {
        this.loggableRepository = loggableRepository;
    }

    @Override
    public void info(Object message) {
        super.info(message);
        Log log = new Log();
        log.setLoggable(message);
        loggableRepository.save(log);
    }
}
