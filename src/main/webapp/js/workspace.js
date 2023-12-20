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
