/*********************************************************************************************************
 * 共用函式
 *********************************************************************************************************/
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

// 監聽事件處理
const handleEvent = async(event, className, callback) => {
	if(!event.target.classList.contains(className)) {
		return;
	}
	const id = event.target.getAttribute('data-id');
	callback(id);
};


/*********************************************************************************************************
 * 資料渲染
 *********************************************************************************************************/
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

// 資料渲染:加載表單選項(學歷, 興趣)
const loadFormOptions = async() => {
	// 加載學歷選項
	const educationOptions = await fetch('http://localhost:8080/SpringMVC/mvc/rest/user/educations');
	var {state, message, data} = await educationOptions.json(); 
	console.log(data);
	// 將 data 逐筆放到下單選項(option)中 (動態建立下拉選單選項)
	data.forEach(education => {
		const opt = document.createElement('option');
		opt.value = education.id;
		opt.textContent = education.name;
		$('educationId').appendChild(opt);
	});
	
	// 加載興趣選項
	const interestOptions = await fetch('http://localhost:8080/SpringMVC/mvc/rest/user/interests');
	var {state, message, data} = await interestOptions.json(); 
	console.log(data);
	// 將 data 逐筆放到下單選項(option)中 (動態建立下拉選單選項)
	data.forEach(interest => {
		const opt = document.createElement('option');
		opt.value = interest.id;
		opt.textContent = interest.name;
		$('interestIds').appendChild(opt);
	});
};

/*********************************************************************************************************
 * User CRUD 操作
 *********************************************************************************************************/
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
	
	if (!result.isConfirmed) {
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

// 表單提交事件處理
const handleFormSubmit = async(event) => {
	event.preventDefault(); // 停止表單的預設傳送行為, 改成自訂行為, 以下是自訂行為的邏輯
	
	const formData = {
		name: $('name').value,
        age: parseInt($('age').value),
        birth: $('birth').value,
        educationId: parseInt($('educationId').value),
        genderId: parseInt(document.querySelector('input[name="genderId"]:checked').value),
        interestIds: Array.from($('interestIds').selectedOptions).map(option => parseInt(option.value)),
        resume: $('resume').value
	};

	const submitButtonText = $('form-submit-button').textContent;
	if (submitButtonText === '新增') {
		// 新增使用者
		addUser(formData);
	} else if (submitButtonText === '修改') {
		const id = $('user-form').getAttribute('data-id');
		// 更新使用者
		updateUser(id, formData);
	}
};

// 新增使用者
const addUser = async(formData) => {
	const response = await fetch('http://localhost:8080/SpringMVC/mvc/rest/user', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(formData)
	});
	const {state, message, data} = await response.json();
	console.log(message);
	 
	fetchAndRenderData('/mvc/rest/user', 'user-list-body', renderUser);
	// 清除表單
	clearForm();
};

// 取得並顯示使用者資料到表單上
const getUserData = async(id) => {
	const fullUrl = `http://localhost:8080/SpringMVC/mvc/rest/user/${id}`;
	try {
		const response = await fetch(fullUrl);
		const {state, message, data} = await response.json();
		const user = data;
		console.log(user);
		// 將得到的 user 資料配置在表單中
		$('name').value = user.name;
		$('age').value = user.age;
		$('birth').value = user.birth;
		$('educationId').value = user.educationId;
		document.querySelector(`input[name="genderId"][value="${user.genderId}"]`).checked = true;
		
		// 設置興趣多選框的選中狀態
		const interestSelect = $('interestIds');
		Array.from(interestSelect.options).forEach(option => {
			option.selected = user.interestIds.includes(parseInt(option.value));
		});
		
		$('resume').value = user.resume;
		// **在表單中加入一個屬性 data-id 用來記錄修改的 id 為何
		$('user-form').setAttribute('data-id', user.id);
		$('form-submit-button').textContent = '修改';
	} catch(e) {
		console.error(e);
	}
};

// 更新使用者資料
const updateUser = async(id, formData) => {
	const fullUrl = `http://localhost:8080/SpringMVC/mvc/rest/user/${id}`;
	try {
		const response = await fetch(fullUrl, {
			method: 'PUT',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(formData)
		});
		const {state, message, data} = await response.json();
		console.log(message);
		
		// 重新資料渲染(fetch取資料+渲染)
		fetchAndRenderData('/mvc/rest/user', 'user-list-body', renderUser);
		// 清除表單
		clearForm();
	} catch(e) {
		console.error(e);
	}
};

// 按下修改鍵
const handleUpdateUser = (id) => { 
	console.log('按下修改:' + id); 
	getUserData(id);
};

// 表單重製/清除表單
const clearForm = () => {
	$('name').value = '';
	$('age').value = '';
	$('birth').value = '';
	$('educationId').value = '';
	document.querySelector('input[name="genderId"]:checked').checked = false;
	Array.from($('interestIds').options).forEach(option => option.selected = false);
	$('resume').value = '';
	$('user-form').removeAttribute('data-id');
	$('form-submit-button').textContent = '新增';
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
	
	// 加載表單選項(學歷, 興趣)
	loadFormOptions();
	
	// 監聽 user-form
	$('user-form').addEventListener("submit", handleFormSubmit);
});
