package com.lckgroup.canteensys.repository;

import com.lckgroup.canteensys.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRep extends JpaRepository<Worker,Integer> {
}
