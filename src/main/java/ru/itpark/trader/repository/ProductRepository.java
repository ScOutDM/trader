package ru.itpark.trader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itpark.trader.entity.ProductEntity;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findAllByNameStartsWithIgnoreCase(String name);
}
//@Repository
//public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, Integer> {
//    List<ProductEntity> findAllByNameStartsWithIgnoreCase(String name);
//}