package com.example.movies.api;

import com.example.movies.dao.entities.VideoCassete;
import com.example.movies.manager.VideoCasseteManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@RestController
@RequestMapping("/api/video-cassetes")
public class VideoCasseteApi {

    private final VideoCasseteManager videoCassetes;

    @Autowired
    public VideoCasseteApi(VideoCasseteManager videoCassetes) {
        this.videoCassetes = videoCassetes;
    }

    @GetMapping
    public Iterable<VideoCassete> getAll() {
        return videoCassetes.findAll();
    }

    @GetMapping("/id")
    public Optional<VideoCassete> getById(@RequestParam long index) {
        return videoCassetes.findAllById(index);
    }

    @PostMapping
    public VideoCassete addVideo(@RequestBody VideoCassete videoCassete) {
        return videoCassetes.save(videoCassete);
    }

    @PutMapping
    public VideoCassete updateVideo(@RequestBody VideoCassete videoCassete) {
        return videoCassetes.save(videoCassete);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam long index) {
        videoCassetes.delete(index);
    }
}

