
// 透過 $ 來替代 document.getElementById() 方法
const $ = (id) => document.getElementById(id); 

// 定義一個非同步函數來加載 HTML 內容
const loadHTML = async(url, containerId) => {
	const fullUrl = 'http://localhost:8080/SpringMVC' + url;
	try {
		const response = await fetch(fullUrl); // 等待 fetch 請求完成
		const data = await response.text(); // 等待回應本文內容
		$(containerId).innerHTML = data; // 將所得到的本文內容加入到指定容器中
	} catch(e) {
		console.error(e);
	}
};

// 渲染 User 資料配置
const renderUser = ({id, name, gender, age, birth, education, interestNames, interests, resume}) => `
	<tr>
		<th>${id}</th><th>${name}</th><th>${gender.name}</th><th>${age}</th><th>${birth}</th>
		<th>${education.name}</th><th>${interestNames}</th><th>${resume}</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
`;

// 資料渲染
const fetchAndRenderData = async(url, containerId, renderFn) => {
	const fullUrl = 'http://localhost:8080/SpringMVC' + url;
	try {
		const response = await fetch(fullUrl); // 等待 fetch 請求完成
		const {state, message, data} = await response.json(); // 等待回應本文內容
		console.log(state, message, data);
		//console.log(renderFn(data[0]));
		//console.log(renderFn(data[1]));
		//console.log(renderFn(data[2]));
		//$(containerId).innerHTML = renderFn(data[0]) + '' + renderFn(data[1]) + '' + renderFn(data[2]) ...
		$(containerId).innerHTML = data.map(renderFn).join('');
		
	} catch(e) {
		console.error(e);
	} 
}; 

// 待 DOM 加載完成之後再執行
document.addEventListener("DOMContentLoaded", async() => {
	
	// 加上 await 關鍵字等待 loadHTML 函數完成才會進行下一個程序
	await loadHTML('/user/user-form.html', 'user-form-container');
	await loadHTML('/user/user-list.html', 'user-list-container');
	
	// 資料渲染(fetch取資料+渲染)
	fetchAndRenderData('/mvc/rest/user', 'user-list-body', renderUser);
	
});
