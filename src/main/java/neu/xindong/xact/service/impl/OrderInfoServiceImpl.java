package neu.xindong.xact.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.xindong.xact.dao.OrderInfoDao;
import neu.xindong.xact.entity.OrderInfo;
import neu.xindong.xact.entity.Transaction;
import neu.xindong.xact.service.OrderInfoService;
import neu.xindong.xact.util.RegisterUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoDao, OrderInfo>
        implements OrderInfoService {
    @Override
    public List<OrderInfo> findOrderInfoByPrimeAccountId(Integer primeAccountId) {
        return query().eq("prime_account_id",primeAccountId).list();
    }

    @Override
    public boolean doOrder(OrderInfo orderInfo) {
        orderInfo.setId(RegisterUtil.createOrderId());
        orderInfo.setOrderTime(new Date());
        orderInfo.setDealAmount(0);
        orderInfo.setDealPrice(0.0);
        orderInfo.setOrderStatus("2");//已报
        orderInfo.setIsWithdraw(0);
        return save(orderInfo);
    }

    @Override
    public boolean withdrawOrder(OrderInfo orderInfo) {
        orderInfo.setIsWithdraw(1);
        orderInfo.setOrderStatus("6");
        orderInfo.setWithdrawAmount(orderInfo.getOrderAmount());
        return updateById(orderInfo);
    }

    @Override
    public boolean updateOrderInfoByDeal(OrderInfo orderInfo, Transaction transaction) {
        orderInfo.setDealAmount(transaction.getAmount());
        orderInfo.setDealPrice(transaction.getPrice());
        if(orderInfo.getOrderAmount()==orderInfo.getDealAmount())orderInfo.setOrderStatus("8");
        return updateById(orderInfo);
    }
}
