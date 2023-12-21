document.addEventListener('DOMContentLoaded', function() {
	// Tìm phần tử có class 'edit_workspace' và gắn sự kiện click
	const editButton = document.querySelector('.edit_workspace');
	editButton.addEventListener('click', function() {
		// Ẩn phần tử có class 'workspace_name'
		const workspaceName = document.querySelector('.workspace_name');
		workspaceName.classList.add('hide');

		// Hiển thị phần tử có class 'workspace_update'
		const workspaceUpdate = document.querySelector('.workspace_update');
		workspaceUpdate.classList.remove('hide');
	});

	// Tìm nút 'Hủy' và gắn sự kiện click
	const cancelButton = document.querySelector('.workspace_update .close');
	cancelButton.addEventListener('click', function() {
		// Ẩn phần tử có class 'workspace_update'
		const workspaceUpdate = document.querySelector('.workspace_update');
		workspaceUpdate.classList.add('hide');

		// Hiển thị phần tử có class 'workspace_name'
		const workspaceName = document.querySelector('.workspace_name');
		workspaceName.classList.remove('hide');
	});
});

document.addEventListener('DOMContentLoaded', function() {
	var inputs = document.getElementsByClassName('deleteWorkspace'); // This returns a collection of elements
	var deleteButtons = document.getElementsByClassName('deleteBtn');

	// Iterate over each input and corresponding delete button
	for (let i = 0; i < inputs.length; i++) {
		let input = inputs[i];
		let deleteButton = deleteButtons[i];

		// Initially, disable the button
		deleteButton.disabled = true;

		// Add 'input' event listener to each input field
		input.addEventListener('input', function() {
			// Enable the button if the input value matches the input's ID
			if (deleteButton.disabled = input.value !== input.id) {
				for (var i = 0; i < deleteButtons.length; i++) {
					deleteButtons[i].classList.remove('btn-danger');
					deleteButtons[i].classList.add('btn-secondary');
				}
			} else {
				for (var i = 0; i < deleteButtons.length; i++) {
					deleteButtons[i].classList.remove('btn-secondary');
					deleteButtons[i].classList.add('btn-danger');
				}
			}
			
		});
	}
});


