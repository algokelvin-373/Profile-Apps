package com.example.profile;

import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<People, Integer> {
}