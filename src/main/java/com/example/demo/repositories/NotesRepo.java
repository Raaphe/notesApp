package com.example.demo.repositories;

import com.example.demo.entities.Notes;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotesRepo extends JpaRepository<Notes, Integer>{
    List<Notes> findByUser(User user);
}
