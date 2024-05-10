package mvc.user.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseData {
	private Integer id; // 指的是 item_id
	private String name; // 指的是 item_name
}
