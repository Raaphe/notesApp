package com.example.demo.services;

import com.example.demo.payload.NotesDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface NotesService {
	
	//create
	NotesDto createNote(NotesDto notesDto,String userId);
	
	
	//update
	NotesDto updateNote(NotesDto notesDto,Integer notesId);
	
	//delete
	void deleteNote(Integer notesId);
	
	//get
	NotesDto getNote(Integer notesId);
	
	//getAll
	List<NotesDto> getAllNote();

	//getByUser
    List<NotesDto> getNoteByUser(String userId);
}
