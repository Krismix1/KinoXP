package controllers;

import java.util.List;

/**
 * Created by Chris on 18-Sep-17.
 */
public interface CRUDController<K, E> {

    public void save(E entity);

    public E get(K id);

    public List<E> getAll();

    public void delete(K id);
}
