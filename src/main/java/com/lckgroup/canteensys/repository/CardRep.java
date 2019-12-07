package com.lckgroup.canteensys.repository;

import com.lckgroup.canteensys.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRep extends JpaRepository<Card,Integer> {

}
