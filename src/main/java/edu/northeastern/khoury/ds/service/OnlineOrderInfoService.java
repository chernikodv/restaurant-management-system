package edu.northeastern.khoury.ds.service;

import edu.northeastern.khoury.ds.domain.model.OnlineOrderInfo;
import edu.northeastern.khoury.ds.repository.OnlineOrderInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OnlineOrderInfoService {

    private final OnlineOrderInfoRepository onlineOrderInfoRepository;

    public List<OnlineOrderInfo> save(List<OnlineOrderInfo> orderInfo) {
        return onlineOrderInfoRepository.saveAll(orderInfo);
    }
}
