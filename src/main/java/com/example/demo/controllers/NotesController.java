package com.example.demo.controllers;

import com.example.demo.payload.ApiRes;
import com.example.demo.payload.NotesDto;
import com.example.demo.services.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin
public class NotesController {

    @Autowired
    private NotesService notesService;

    //create
    @PostMapping("/{userId}")
    public ResponseEntity<NotesDto> createNote(@RequestBody NotesDto notes,@PathVariable String userId){
        NotesDto note =  this.notesService.createNote(notes, userId);
        return new ResponseEntity<NotesDto>(note,HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{notesId}")
    public ResponseEntity<NotesDto> updateNote(@RequestBody NotesDto notes,@PathVariable Integer notesId){
        NotesDto updatedNote =  this.notesService.updateNote(notes, notesId);
        return new ResponseEntity<NotesDto>(updatedNote,HttpStatus.OK);
    }
    //delete
    @DeleteMapping("/{notesId}")
    public ResponseEntity<ApiRes> deleteNote(@PathVariable Integer notesId){
        this.notesService.deleteNote(notesId);
        return new ResponseEntity<ApiRes>(new ApiRes("Note deleted",true),HttpStatus.OK);
    }
    //get by user
    @GetMapping("/{userId}")
    public ResponseEntity<List<NotesDto>> getNotesByUser(@PathVariable String userId){
        List<NotesDto> Note=this.notesService.getNoteByUser(userId);
        return new ResponseEntity<List<NotesDto>>(Note,HttpStatus.OK);
    }

    //get
    // @GetMapping("/{notesId}")
    // public ResponseEntity<NotesDto> getNotes(@PathVariable Integer notesId){
    //     NotesDto Note=this.notesService.getNote(notesId);
    //     return new ResponseEntity<NotesDto>(Note,HttpStatus.OK);
    // }

    //getAll
    @GetMapping("/")
   @CrossOrigin
    public ResponseEntity<List<NotesDto>> getNotes(){
        List<NotesDto> Note=this.notesService.getAllNote();
        return new ResponseEntity<List<NotesDto>>(Note,HttpStatus.OK);
    }
}
