package dev.company.customer.service;

import java.util.List;

import dev.company.customer.exception.CustomerException;

public interface CustomerService<T> {

	public T findOne(final int id) throws CustomerException;

	public List<T> findAll() throws CustomerException;

	public T create(final T entity) throws CustomerException;

	public T update(final T entity) throws CustomerException;

	public boolean deleteById(final int entityId) throws CustomerException;
}
