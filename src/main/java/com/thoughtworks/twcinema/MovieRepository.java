package com.thoughtworks.twcinema;

import org.springframework.data.repository.CrudRepository;

// 数据访问层
public interface MovieRepository extends CrudRepository<Movie, String> {
}
