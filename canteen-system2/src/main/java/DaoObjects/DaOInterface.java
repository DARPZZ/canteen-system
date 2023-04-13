package DaoObjects;

public interface DaOInterface<T>
{
 public abstract void Create(T t);
 public abstract void Remove(T t);
 public abstract void Update(T t);
 public abstract void Delete(T t);



}
