package mvc.user.model.po;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Integer id; // 序號
	
	@NotEmpty(message = "姓名不可以是空白")
	@Size(min = 2, max = 50, message = "姓名必須介於 {min} ~ {max} 字之間")
	private String name; // 姓名
	
	@NotNull(message = "年齡不可以是空白")
	@Range(min = 18, max = 150, message = "年齡需介於 {min} ~ {max} 歲之間")
	private Integer age; // 年齡
	
	@NotNull(message = "日期不可以是空白")
	@Past(message = "生日不可以大於今日日期")
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 日期格式
	private Date birth; // 生日
	
	@Size(max = 1000, message = "履歷不可以超過 {max} 個字")
	private String resume; // 履歷
	
	@NotNull(message = "請選擇教育程度")
	private Integer educationId; // 教育程度 id
	
	@NotNull(message = "請選擇性別")
	private Integer genderId; // 性別 id
	
	@Size(min = 1, message = "興趣至少要選 {min} 個")
	private Integer[] interestIds; // 興趣 ids
	
}
