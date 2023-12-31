package com.instrumentation.system.assumptions.config;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;
import com.instrumentation.system.entity.Post;
import jakarta.persistence.EntityManager;

//Enabling Repository for REPLAY mode only
@Profile("REPLAY")
@Repository
public class CustomSimpleJpaRepository<T, ID> extends SimpleJpaRepository<T, ID> {

	public CustomSimpleJpaRepository(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
	}

	@Override
	public <S extends T> List<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public List<T> findAll() {
		return null;
	}

	@Override
	public List<T> findAllById(Iterable<ID> ids) {
		return null;
	}

	@Override
	public <S extends T> S save(S entity) {
		return (S) Post.builder().id(24).name("Karan Raina").contents("Hyper Test").build();
	}

	@Override
	public Optional<T> findById(ID id) {
		return Optional.empty();
	}

	@Override
	public boolean existsById(ID id) {
		return false;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(ID id) {
	}

	@Override
	public void delete(T entity) {
	}

	@Override
	public void deleteAllById(Iterable<? extends ID> ids) {
	}

	@Override
	public void deleteAll(Iterable<? extends T> entities) {
	}

	@Override
	public void deleteAll() {
	}

	@Override
	public List<T> findAll(Sort sort) {
		return null;
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public <S extends T> Optional<S> findOne(Example<S> example) {
		return Optional.empty();
	}

	@Override
	public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}

	@Override
	public <S extends T> long count(Example<S> example) {
		return 0;
	}

	@Override
	public <S extends T> boolean exists(Example<S> example) {
		return false;
	}

	@Override
	public <S extends T, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return null;
	}

	@Override
	public void flush() {
	}

	@Override
	public <S extends T> S saveAndFlush(S entity) {
		return null;
	}

	@Override
	public <S extends T> List<S> saveAllAndFlush(Iterable<S> entities) {
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<T> entities) {
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<ID> ids) {
	}

	@Override
	public void deleteAllInBatch() {
	}

	@Override
	public T getOne(ID id) {
		return null;
	}

	@Override
	public T getById(ID id) {
		return null;
	}

	@Override
	public T getReferenceById(ID id) {
		return null;
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example) {
		return null;
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
		return null;
	}

}
