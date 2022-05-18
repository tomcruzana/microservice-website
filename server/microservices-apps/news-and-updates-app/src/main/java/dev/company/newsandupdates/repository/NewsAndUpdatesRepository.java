package dev.company.newsandupdates.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import dev.company.newsandupdates.entity.NewsAndUpdates;

@RepositoryRestResource(path="newsAndUpdates")
public interface NewsAndUpdatesRepository extends CrudRepository<NewsAndUpdates, Integer> {

}
