package neu.xindong.xact.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import neu.xindong.xact.entity.Transaction;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransactionDao extends BaseMapper<Transaction> {
}
