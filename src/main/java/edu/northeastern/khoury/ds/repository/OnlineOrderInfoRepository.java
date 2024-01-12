package edu.northeastern.khoury.ds.repository;

import edu.northeastern.khoury.ds.domain.model.OnlineOrderInfo;
import edu.northeastern.khoury.ds.domain.model.OnlineOrderInfoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnlineOrderInfoRepository extends JpaRepository<OnlineOrderInfo, OnlineOrderInfoId> {
}
