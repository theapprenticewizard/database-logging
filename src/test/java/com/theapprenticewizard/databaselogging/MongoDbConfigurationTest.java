package com.theapprenticewizard.databaselogging;

import com.theapprenticewizard.databaselogging.model.BookRepository;
import com.theapprenticewizard.databaselogging.model.BookService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
@Ignore
public class MongoDbConfigurationTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    @Before
    public void setUp() {
        bookRepository.save(bookService.generateRandom());
    }

    @Test
    public void testConnection() {
        assertThat(bookRepository.count(), is(1L));
    }

    @After
    public void tearDown() {
        bookRepository.deleteAll();
    }
}
