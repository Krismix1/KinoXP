package logic;

import java.util.List;

/**
 * Created by Chris on 18-Sep-17.
 */
public interface CRUDRepository<K, E> {

    public E save(E entity);

    public E get(K id);

    public List<E> getAll();

    public void delete(K id);
}
