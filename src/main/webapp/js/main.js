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
