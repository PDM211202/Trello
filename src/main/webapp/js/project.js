function enableDragAndDrop() {
  const items = document.querySelectorAll('.list-group-item');
  const lists = document.querySelectorAll('.list-group');

  const placeholder = createPlaceholder();

  items.forEach(item => {
    item.addEventListener('dragstart', e => {
      if (e.target.classList.contains('list-group-item')) {
        e.dataTransfer.effectAllowed = 'move';
        draggedItem = item;
        setTimeout(() => item.classList.add('hidden'), 0);
      }
    });
    item.addEventListener('dragend', () => {
      if (e.target.classList.contains('list-group-item')) {
        item.classList.remove('hidden'); // Hiện lại item
        draggedItem = null; // Reset biến draggedItem
        if (placeholder) {
          placeholder.remove(); // Loại bỏ placeholder
        }
      }
    });
  });

  lists.forEach(list => {
    list.addEventListener('dragover', e => {
      e.preventDefault();
      const afterElement = getDragAfterElement(list, e.clientY);
      if (afterElement) {
        list.insertBefore(placeholder, afterElement);
      } else {
        list.appendChild(placeholder);
      }
    });

    list.addEventListener('drop', e => {
      e.preventDefault();
      if (draggedItem && draggedItem.classList.contains('list-group-item')) {
        list.insertBefore(draggedItem, placeholder); // Thêm draggedItem trở lại DOM
        draggedItem.classList.remove('hidden'); // Hiện lại item
        draggedItem = null; // Reset biến draggedItem
        placeholder.remove(); // Loại bỏ placeholder
        updateTaskPositions(list); // Cập nhật vị trí
      }
    });

    list.addEventListener('dragleave', e => {
      // Loại bỏ placeholder khi rời khỏi list-group
      if (e.target === list && !list.contains(e.relatedTarget)) {
        placeholder.remove();
      }
    });
  });
}

let draggedItem = null;

function updateTaskPositions(list) {
  const items = list.querySelectorAll('.list-group-item:not(.placeholder)');
  items.forEach((item, index) => {
    item.setAttribute('task-position', index + 1);
  });
}

function createPlaceholder() {
  const placeholder = document.createElement('div');
  placeholder.classList.add('list-group-item', 'placeholder');
  return placeholder;
}

function getDragAfterElement(list, y) {
  const draggableElements = [...list.querySelectorAll('.list-group-item:not(.placeholder):not(.hidden)')];

  return draggableElements.reduce((closest, child) => {
    const box = child.getBoundingClientRect();
    const offset = y - box.top - box.height / 2;
    if (offset < 0 && offset > closest.offset) {
      return { offset: offset, element: child };
    } else {
      return closest;
    }
  }, { offset: Number.NEGATIVE_INFINITY }).element;
}

enableDragAndDrop();


let placeholderCard = null;

function enableDragAndDropForCards() {
  const cards = document.querySelectorAll('.card');
  const cardContainer = document.querySelector('.content__main');
  placeholderCard = createPlaceholderCard();

  cards.forEach(card => {
    card.setAttribute('draggable', true);
    card.addEventListener('dragstart', handleDragStartCard);
    card.addEventListener('dragend', handleDragEndCard);
  });

  cardContainer.addEventListener('dragover', handleDragOverContainer);
  cardContainer.addEventListener('drop', handleDropOnContainer);
}

let draggedCard = null;


function handleDragStartCard(e) {
  if (e.target.classList.contains('card')) {
    e.dataTransfer.effectAllowed = 'move';
    draggedCard = this;
    setTimeout(() => this.style.opacity = '0.5', 0);
  }
}


function handleDragEndCard() {
  if (draggedCard && this.classList.contains('card')) {
    draggedCard.style.opacity = ''; // Khôi phục lại độ trong suốt
    draggedCard = null; // Reset draggedCard
    if (document.querySelector('.placeholder-card')) {
      document.querySelector('.placeholder-card').remove();
    }
  }
}

function handleDragOverContainer(e) {
  if (draggedCard) {
    e.preventDefault();
    const container = e.currentTarget;
    const afterElement = getDragAfterElementForCards(container, e.clientX);

    if (afterElement) {
      container.insertBefore(placeholderCard, afterElement);
    } else {
      container.appendChild(placeholderCard);
    }
  }
}

function handleDropOnContainer(e) {
  if (draggedCard) {
    e.preventDefault();
    const container = e.currentTarget;
    const afterElement = getDragAfterElementForCards(container, e.clientX);

    if (afterElement) {
      container.insertBefore(draggedCard, afterElement);
    } else {
      container.appendChild(draggedCard);
    }
    placeholderCard.remove();
    draggedCard.style.opacity = '';
    draggedCard = null;

    updateWorkPositions(container); // Cập nhật work-position sau khi thả card
  }
}

function createPlaceholderCard() {
  const placeholder = document.createElement('div');
  placeholder.classList.add('card', 'placeholder-card');
  return placeholder;
}

function updateWorkPositions(container) {
  const cards = container.querySelectorAll('.card');
  cards.forEach((card, index) => {
    card.setAttribute('work-position', index + 1);
  });
}

function getDragAfterElementForCards(container, x) {
  const draggableElements = [...container.querySelectorAll('.card:not(.hidden)')];

  return draggableElements.reduce((closest, child) => {
    const box = child.getBoundingClientRect();
    const offset = x - box.left - box.width / 2;

    if (offset < 0 && offset > closest.offset) {
      return { offset: offset, element: child };
    } else {
      return closest;
    }
  }, { offset: Number.NEGATIVE_INFINITY }).element;
}

enableDragAndDropForCards();


document.addEventListener('DOMContentLoaded', function() {
  // Lấy tất cả các list-group-item
  const items = document.querySelectorAll('.list-group-item-p');

  // Thêm sự kiện hover
  items.forEach(item => {
    item.addEventListener('mouseover', function() {
      // Thêm class 'hover-active' khi chuột di chuyển vào phần tử
      this.classList.add('hover-active');
    });
    
    item.addEventListener('mouseout', function() {
      // Loại bỏ class 'hover-active' khi chuột di chuyển ra khỏi phần tử
      this.classList.remove('hover-active');
    });

    // Thêm sự kiện click để kích hoạt item
    item.addEventListener('click', function() {
      // Loại bỏ class 'active' từ tất cả các item
      items.forEach(i => i.classList.remove('active'));
      
      // Thêm class 'active' vào item được click
      this.classList.add('active');
    });
  });
});


document.addEventListener('DOMContentLoaded', function () {
    const showButtons = document.querySelectorAll('.card__bottom .btn_show'); // Chọn tất cả các nút hiển thị form

    showButtons.forEach(function (button) {
        const cardBottom = button.closest('.card__bottom'); // Tìm thẻ card__bottom gần nhất
        const addTaskDiv = cardBottom.querySelector('.add_task'); // Tìm thẻ add_task trong cùng card__bottom
        const closeButton = cardBottom.querySelector('.btn_close'); // Tìm nút đóng trong cùng card__bottom

        // Sự kiện khi nhấn nút hiển thị form
        button.addEventListener('click', function () {
            addTaskDiv.classList.remove('hidden');
            button.classList.add('hidden');
        });

        // Sự kiện khi nhấn nút đóng form
        closeButton.addEventListener('click', function () {
            addTaskDiv.classList.add('hidden');
            button.classList.remove('hidden');
        });
    });
});



document.addEventListener('DOMContentLoaded', function () {
  var addButton = document.querySelector('.description__add');
  var form = document.querySelector('.description__content form');
  var cancelButton = form.querySelector('button[type="reset"]');

  addButton.addEventListener('click', function () {
      addButton.classList.add('hide');
      form.classList.remove('hide');
  });

  cancelButton.addEventListener('click', function (event) {
      event.preventDefault(); // Ngăn chặn hành động mặc định của nút reset
      addButton.classList.remove('hide');
      form.classList.add('hide');
  });
});

document.addEventListener('DOMContentLoaded', function () {
  var formChecks = document.querySelectorAll('.form-check');

  formChecks.forEach(function (formCheck) {
      var updateButton = formCheck.querySelector('.btn-update-todo');
      var cancelButton = formCheck.querySelector('.update_todo button[type="reset"]');
      var updateTodo = formCheck.querySelector('.update_todo');
      var formCheckLabel = formCheck.querySelector('.form-check-label');

      updateButton.addEventListener('click', function () {
          formCheckLabel.classList.add('hide');
          updateButton.classList.add('hide');
          updateTodo.classList.remove('hide');
      });

      cancelButton.addEventListener('click', function (event) {
          event.preventDefault(); // Ngăn chặn hành động mặc định của nút reset
          formCheckLabel.classList.remove('hide');
          updateButton.classList.remove('hide');
          updateTodo.classList.add('hide');
      });
  });
});

document.addEventListener('DOMContentLoaded', function () {
  // Hàm tính toán và cập nhật phần trăm hoàn thành
  function updateProgress() {
      var checkboxes = document.querySelectorAll('.form-check-input');
      var checked = document.querySelectorAll('.form-check-input:checked');
      var percentage = (checked.length / checkboxes.length) * 100;

      var progressSpan = document.querySelector('.progress_per span');
      var progressBar = document.querySelector('.progress_per .persen');

      progressSpan.textContent = percentage.toFixed(0) + '%';
      progressBar.style.width = percentage.toFixed(0) + '%';
  }

  // Gọi hàm khi trang tải xong
  updateProgress();

  // Cập nhật tiến trình mỗi khi một checkbox được click
  document.querySelectorAll('.form-check-input').forEach(function (checkbox) {
      checkbox.addEventListener('change', updateProgress);
  });
});


document.addEventListener('DOMContentLoaded', function () {
  var toggleHideButton = document.querySelector('.hide_todo');
  var formChecks = document.querySelectorAll('.form-check');

  toggleHideButton.addEventListener('click', function () {
      var isHiding = toggleHideButton.textContent.includes('Ẩn');
      
      formChecks.forEach(function (formCheck) {
          if (formCheck.querySelector('.form-check-input').checked) {
              formCheck.style.display = isHiding ? 'none' : 'block';
          }
      });

      toggleHideButton.textContent = isHiding ? 'Hiển thị các mục đã chọn' : 'Ẩn các mục đã chọn';
  });
});

document.addEventListener('DOMContentLoaded', function () {
  var addButton = document.querySelector('.btn_addtodo');
  var todoInfo = document.querySelector('.todo_info');
  var cancelButton = document.querySelector('.todo_info .btn[type="reset"]');

  addButton.addEventListener('click', function () {
      todoInfo.style.display = 'block';
      addButton.style.display = 'none';
  });

  cancelButton.addEventListener('click', function () {
      todoInfo.style.display = 'none';
      addButton.style.display = 'block';
  });
});

document.addEventListener('DOMContentLoaded', function () {
  var commentContents = document.querySelectorAll('.comment_content');

  commentContents.forEach(function (comment) {
      var editButton = comment.querySelector('.btn_update_comment');
      var cancelButton = comment.querySelector('.update_comment .btn[type="reset"]');
      var itemBody = comment.querySelector('.item_body');
      var updateCommentSection = comment.querySelector('.update_comment');

      editButton.addEventListener('click', function () {
          itemBody.style.display = 'none';
          updateCommentSection.style.display = 'block';
      });

      cancelButton.addEventListener('click', function () {
          itemBody.style.display = 'block';
          updateCommentSection.style.display = 'none';
      });
  });
});

document.addEventListener('DOMContentLoaded', function () {
  var bodyItems = document.querySelectorAll('.body_item');

  bodyItems.forEach(function (item) {
      var showAdd = item.querySelector('.show_add');

      // Hiển thị show_add khi click vào body_item
      item.addEventListener('click', function (event) {
          showAdd.style.display = 'block';
          event.stopPropagation(); // Ngăn chặn sự kiện nổi bọt lên document
      });
  });

  // Ẩn tất cả show_add khi click ra ngoài
  document.addEventListener('click', function () {
      document.querySelectorAll('.show_add').forEach(function (showAdd) {
          showAdd.style.display = 'none';
      });
  });
});

