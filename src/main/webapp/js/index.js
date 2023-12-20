document.addEventListener('DOMContentLoaded', (event) => {
	const listItems = document.querySelectorAll('.list-group .list-group-item');

	listItems.forEach(item => {
		item.addEventListener('click', () => {
			// Remove the 'active' class from all list items
			listItems.forEach(innerItem => {
				innerItem.classList.remove('active');
			});

			// Add the 'active' class to the clicked item
			item.classList.add('active');
		});
	});
});

document.addEventListener('DOMContentLoaded', function() {
	var bgItems = document.querySelectorAll('.bg_item');

	bgItems.forEach(function(bgItem) {
		bgItem.addEventListener('click', function() {
			var style = window.getComputedStyle(bgItem);
			var backgroundImageUrl = style.backgroundImage;

			var modalImg = document.querySelector('.modal-img');
			if (modalImg) {
				modalImg.style.backgroundImage = backgroundImageUrl;
			}
		});
	});
});

document.addEventListener('DOMContentLoaded', function() {
	var bgItems = document.querySelectorAll('.bg_item');
	bgItems.forEach(function(bgItem) {
		bgItem.addEventListener('click', function() {
			var style = window.getComputedStyle(bgItem);
			var backgroundImageUrl = style.backgroundImage;

			// Lấy URL từ giá trị backgroundImage, loại bỏ "url(" và ")".
			var imageUrl = backgroundImageUrl.slice(5, -2);

			var backgroundImageInput = document.getElementById('backgroundImageInput');
			if (backgroundImageInput) {
				backgroundImageInput.value = imageUrl;
			}

			var modalImg = document.querySelector('.modal-img');
			if (modalImg) {
				modalImg.style.backgroundImage = backgroundImageUrl;
			}
		});
	});
});

// Đảm bảo DOM đã tải xong trước khi thực hiện các hành động
document.addEventListener('DOMContentLoaded', function() {
    // Lắng nghe sự kiện click trên thẻ span
    document.querySelectorAll('span[data-bs-toggle="modal"]').forEach(function(span) {
        span.addEventListener('click', function() {
            // Lấy giá trị id của thẻ span
            var wsId = this.id;

            // Gán giá trị id vào thẻ input có name là 'workspace_id'
            var input = document.querySelector('input[name="workspace_id"]');
            if(input) {
                input.value = wsId;
            }
        });
    });
});
