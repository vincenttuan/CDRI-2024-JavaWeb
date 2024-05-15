package mvc.user.model.response;

public class ApiResponse<T> {
	private Boolean state; // 狀態
	private String message; // 訊息
	private T data; // 資料
}
