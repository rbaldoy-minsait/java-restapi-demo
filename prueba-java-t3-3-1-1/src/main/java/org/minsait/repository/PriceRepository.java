package org.minsait.repository;

import org.minsait.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {

    @Query(value = "select * from prices " +
            "where :date between start_date and end_date " +
            "and product_id = :product " +
            "and brand_id = :brand", nativeQuery = true)
    List<Price> findTariffs(@Param("date") Date applicationDate,
                            @Param("product") Integer productId,
                            @Param("brand") Integer brandId);

}
