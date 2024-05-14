package mvc.user.model.po;

import java.util.Date;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.context.annotation.PropertySource;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Integer id; // 序號
	
	@NotEmpty (message = "{user.name.notempty}")
	@Size(min = 2, max = 50, message = "{user.name.size}")
	private String name; // 姓名
	
	@NotNull(message = "{user.age.notenull}")
	@Range(min = 18, max = 150, message = "{user.age.range}")
	private Integer age; // 年齡
	
	@NotNull(message = "{user.birth.notnull}")
	@Past(message = "{user.birth.past}")
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 日期格式
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date birth; // 生日
	
	@Size(max = 1000, message = "{user.resume.size}")
	private String resume; // 履歷
	
	@NotNull(message = "{user.educationId.notnull}")
	private Integer educationId; // 教育程度 id
	
	@NotNull(message = "{user.sexId.notnull}")
	private Integer genderId; // 性別 id
	
	@Size(min = 1, message = "{user.interestIds.size}")
	private Integer[] interestIds; // 興趣 ids
	
}
