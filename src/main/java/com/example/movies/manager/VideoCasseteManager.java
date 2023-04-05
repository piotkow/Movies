package com.example.movies.manager;

import com.example.movies.dao.VideoCasseteRepo;
import com.example.movies.dao.entities.VideoCassete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
@Service
public class VideoCasseteManager {

    private VideoCasseteRepo videoCasseteRepo;

    @Autowired
    public VideoCasseteManager(VideoCasseteRepo videoCasseteRepo) {

        this.videoCasseteRepo = videoCasseteRepo;
    }

    public Optional<VideoCassete> findAllById(Long id) {
        return videoCasseteRepo.findById(id);
    }

    public Iterable<VideoCassete> findAll() {
        return videoCasseteRepo.findAll();
    }

    public VideoCassete save(VideoCassete videoCassete){
        return videoCasseteRepo.save(videoCassete);
    }

    public void delete(Long id) {
        videoCasseteRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new VideoCassete(1L, "The Godfather", LocalDate.of(1972, 3, 24)));
        save(new VideoCassete(2L, "Star Wars: Episode IV - A New Hope", LocalDate.of(1977, 5, 25)));
        save(new VideoCassete(3L, "Jurassic Park", LocalDate.of(1993, 6, 11)));
    }
}