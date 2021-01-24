document.addEventListener('DOMContentLoaded', () => {
    document.querySelector(".tag-links").addEventListener("click", event => {
        if (event.target.className === 'tag-buttons') {
            sendTag(event.target.value);
        }
    });

    function sendTag(tagName) {
        let data = {
            'id': null,
            'tagName': tagName
        };

        $.ajax({
            type: "POST",
            url: "/news",
            data: JSON.stringify(data),
            success: response => {
                renderNewsByTagName(response, $('#blog-post'))
            },
            dataType: "json",
            contentType: "application/json"
        });
    }

    function renderNewsByTagName(news, blogPost) {
        let innerHtml = '';
        for (let item of news) {
            innerHtml += '<div class="single-blog-post">';
            innerHtml += '    <div class="blog-pic">';
            innerHtml += `        <img src="${item['photo']}" alt="">`;
            innerHtml += '    </div>'
            innerHtml += '    <div class="blog-text">';
            innerHtml += `        <h4>${item['title']}</h4>`;
            innerHtml += `        <p>${item['description']}</p>`;
            innerHtml += '    </div>';
            innerHtml += '</div>';
        }
        blogPost.html(innerHtml);
    }
})
