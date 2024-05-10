package mvc.user.model.po;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Integer id; // 序號
	private String name; // 姓名
	private Integer age; // 年齡
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 日期格式
	private Date birth; // 生日
	private String resume; // 履歷
	private Integer educationId; // 教育程度 id
	private Integer genderId; // 性別 id
	private Integer[] interestIds; // 興趣 ids
	
}
