package com.api.store.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.api.store.model.Store;

@Repository
public interface StoreRepository  extends PagingAndSortingRepository<Store, Integer>{

	Optional<Store> findByUrl(String url);

}
