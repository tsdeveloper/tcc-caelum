package com.caelum.tccjavaweb.post;

import com.caelum.tccjavaweb.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
public class PostService {
	
	@Autowired
	private final PostRepository accountRepository;

	public PostService(PostRepository accountRepository) {
		this.accountRepository = accountRepository;
	}


	@PostConstruct
	protected void initialize() {
		save(new Post("Popularização do VueJS", "Popularização do VueJS"));
		save(new Post("Popularização do AngularJS", "Popularização do AngularJS"));
	}

	@Transactional
	public Post save(Post account) {
		accountRepository.save(account);
		return account;
	}


	Iterable<Post> findAll() {
		return accountRepository.findAll();
	}

	public Post findOne(Long id) {
		return accountRepository.findOne(id);
	}
	

}
