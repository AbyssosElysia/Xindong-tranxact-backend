package neu.xindong.xact.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@Data
@TableName("commission")
@ToString
public class Commission {
    @TableId
    private Integer id;
    private Integer cuacctCls;
    private Integer market;
    private String stkCls;
    private Double rate;
}
