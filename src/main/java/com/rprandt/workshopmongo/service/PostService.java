package com.rprandt.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rprandt.workshopmongo.domain.Post;
import com.rprandt.workshopmongo.repository.PostRepository;
import com.rprandt.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.findByTitle(text);
	}
	
}
