package com.devskiller.dao;

import com.devskiller.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query(value =
            "SELECT  * " +
                    "FROM ( " +
                    " SELECT ITEM.*, " +
                    " (CASE WHEN ITEM_ID  IS NULL THEN 0 ELSE AVG(rating) END) RATE" +
                    " FROM ITEMS ITEM " +
                    " LEFT JOIN REVIEWS REVIEW " +
                    " ON (ITEM.ID = REVIEW.ITEM_ID) " +
                    " GROUP BY ITEM.ID  " +
                    " ) " +
                    " WHERE RATE < ?1 "
            ,nativeQuery = true
    )
    List<Item> findItemsWithAverageRatingLowerThan(Double rating);
}
