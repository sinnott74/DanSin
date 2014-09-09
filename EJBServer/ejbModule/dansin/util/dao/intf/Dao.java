package dansin.util.dao.intf;

public interface Dao<E> {
	void save(E entity);
	void update(E entity);
	void delete(E entity);
	E get(Long id);
}
