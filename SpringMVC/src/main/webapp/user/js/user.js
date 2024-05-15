
// 透過 $ 來替代 document.getElementById() 方法
const $ = (id) => document.getElementById(id); 

// 定義一個非同步函數來加載 HTML 內容
const loadHTML = async(url, containerId) => {
	const fullUrl = 'http://localhost:8080/SpringMVC/user' + url;
	try {
		const response = await fetch(fullUrl); // 等待 fetch 請求完成
		const data = await response.text(); // 等待回應本文內容
		$(containerId).innerHTML = data; // 將所得到的本文內容加入到指定容器中
	} catch(e) {
		console.error(e);
	}
};

// 待 DOM 加載完成之後再執行
document.addEventListener("DOMContentLoaded", async() => {
	
	// 加上 await 關鍵字等待 loadHTML 函數完成才會進行下一個程序
	await loadHTML('/user-form.html', 'user-form-container');
	await loadHTML('/user-list.html', 'user-list-container');
	
});
