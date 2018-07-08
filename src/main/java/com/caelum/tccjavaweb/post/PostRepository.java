package com.caelum.tccjavaweb.post;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
	Post findOneByTitle(String title);
}