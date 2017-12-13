package com.theapprenticewizard.databaselogging.application;

import org.springframework.data.repository.CrudRepository;

public interface LoggableRepository extends CrudRepository<Log, String> {
}
