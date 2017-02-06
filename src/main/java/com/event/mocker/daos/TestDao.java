package com.event.mocker.daos;


import com.event.mocker.entities.Book;

import java.util.List;

public interface TestDao {
    void print();

    List<Book> getAll();
}
