
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
		<th title="修改">
			<span class="button-update pure-button update-user-button" data-id="${id}">修改</span>
		</th>
		<th title="刪除">
			<span class="button-delete pure-button delete-user-button" data-id="${id}">刪除</span>
		</th>
	</tr>
`;

// 資料渲染
const fetchAndRenderData = async(url, containerId, renderFn) => {
	const fullUrl = 'http://localhost:8080/SpringMVC' + url;
	try {
		const response = await fetch(fullUrl); // 等待 fetch 請求完成
		const {state, message, data} = await response.json(); // 等待回應本文內容
		console.log(state, message, data);
		console.log(renderFn(data[0]));
		//console.log(renderFn(data[1]));
		//console.log(renderFn(data[2]));
		//$(containerId).innerHTML = renderFn(data[0]) + '' + renderFn(data[1]) + '' + renderFn(data[2]) ...
		/*
		if(Array.isArray(data)) {
			$(containerId).innerHTML = data.map(renderFn).join(''); // 多筆渲染
		} else {
			$(containerId).innerHTML = renderFn(data); // 單筆渲染
		}
		*/
		$(containerId).innerHTML = Array.isArray(data) ? data.map(renderFn).join('') : renderFn(data);
		
	} catch(e) {
		console.error(e);
	} 
}; 

const handleUpdateUser = (id) => { console.log('按下修改:' + id); };

const handleDeleteUser = async(id) => { 
	console.log('按下刪除:' + id); 
	// 確認是否要刪除 ?
	/*
	if(!confirm('是否要刪除?')) {
		return;
	}
	*/
	const result = await Swal.fire({
		title: '確定要刪除嗎?',
		text: '刪除後將無法恢復',
		icon: 'warning',
		showCancelButton: true,
		confirmButtonText: '是的, 刪除它!',
		cancelButtonText: '取消'
	});
	
	if(!result.ifConfirmed) {
		return;
	}
	
	// 進行刪除程序
	const fullUrl = 'http://localhost:8080/SpringMVC/mvc/rest/user/' + id;
	const response = await fetch(fullUrl, {method: 'DELETE'}); // 等待 fetch 請求完成
	const {state, message, data} = await response.json(); // 等待回應本文內容
	console.log(state, message, data);
	// 更新 user list
	fetchAndRenderData('/mvc/rest/user', 'user-list-body', renderUser);
};

const handleEvent = async(event, className, callback) => {
	if(!event.target.classList.contains(className)) {
		return;
	}
	const id = event.target.getAttribute('data-id');
	callback(id);
};
// 待 DOM 加載完成之後再執行
document.addEventListener("DOMContentLoaded", async() => {
	
	// 加上 await 關鍵字等待 loadHTML 函數完成才會進行下一個程序
	await loadHTML('/user/user-form.html', 'user-form-container');
	await loadHTML('/user/user-list.html', 'user-list-container');
	
	// 資料渲染(fetch取資料+渲染)
	fetchAndRenderData('/mvc/rest/user', 'user-list-body', renderUser);
	
	// 監聽 User List 是否有被點擊?
	$('user-list-table').addEventListener("click", async(event) => {
		//console.log(event);
		// 處理事件
		await handleEvent(event, 'update-user-button', handleUpdateUser);
		await handleEvent(event, 'delete-user-button', handleDeleteUser);
	});
});
