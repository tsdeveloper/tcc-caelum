package com.caelum.tccjavaweb.event;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EventRepository extends PagingAndSortingRepository<Event, Long> {

}
