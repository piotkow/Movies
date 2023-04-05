package com.example.movies.dao;

import com.example.movies.dao.entities.VideoCassete;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoCasseteRepo extends CrudRepository<VideoCassete, Long> {

}
