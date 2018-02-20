package com.caelum.tccjavaweb.task;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

}
