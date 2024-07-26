package dao.jdbc;

import dao.GenericDao;

import java.sql.Connection;
import java.util.List;

public abstract class GenericJdbcDao<T, ID> implements GenericDao<T, ID> {
    protected Connection connection;

    public GenericJdbcDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public abstract void create(T entity);

    @Override
    public abstract T read(ID id);

    @Override
    public abstract void update(T entity);

    @Override
    public abstract void deleteById(ID id);

    @Override
    public abstract List<T> findAll();
}
