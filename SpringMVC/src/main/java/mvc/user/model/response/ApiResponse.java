package mvc.user.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
	private Boolean state; // 狀態
	private String message; // 訊息
	private T data; // 資料
}
