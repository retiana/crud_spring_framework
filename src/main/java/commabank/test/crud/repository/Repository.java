package commabank.test.crud.repository;

import java.util.List;
import java.util.Optional;

import commabank.test.crud.model.ModelEmployee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public interface Repository extends CrudRepository<ModelEmployee, Integer> {
List <ModelEmployee> findById(int id);
List <ModelEmployee> findByName(String name);

@Modifying
@Transactional
@Query(value = "UPDATE employee set name = :name, phone = :phone where id = :id", nativeQuery = true)
    public void updateById(@Param("name") String name, @Param("phone") String phone, @Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "Delete from employee where name = :name", nativeQuery = true)
    public void deleteByName(@Param("name") String name);


}
