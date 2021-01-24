document.addEventListener('DOMContentLoaded', () => {
    let checkAvailableRooms = document.querySelector("#check-available-rooms-btn");

    checkAvailableRooms.addEventListener('click', () => {
        sendAvailabilityForm($('#daterange').val(), $('#rooms-number').val(),
            $('#adults-number').val(), $('#child-number').val())
    });

    function sendAvailabilityForm(dateRange, roomsNumber, adultsNumber, childNumber) {
        // dateRange = "ДД.ММ.ГГГГ - ДД.ММ.ГГГГ"
        let dateRangeArray = dateRange.split(' - ');
        let dateFromString = dateRangeArray[0],
            dateToString = dateRangeArray[1]

        // форматируем дату ДД.ММ.ГГГГ в число миллисекунд, прошедших с 01.01.1970
        let dateFrom = parseDateToMilli(dateFromString);
        let dateTo = parseDateToMilli(dateToString);

        function parseDateToMilli(dateString) {
            const dateStringComponents = dateString.split('.'),
                day = parseInt(dateStringComponents[0]),
                month = parseInt(dateStringComponents[1]),
                year = parseInt(dateStringComponents[2]);
            return new Date(year, month, day).getTime();
        }

        let data = {
            'dateFrom': dateFrom,
            'dateTo': dateTo,
            'roomsNumber': roomsNumber,
            'adultsNumber': adultsNumber,
            'childNumber': childNumber
        };

        $.ajax({
            type: "POST",
            url: "/availability",
            data: JSON.stringify(data),
            success: response => {
                renderAvailableRoomsSection(response, $('#available-rooms'))
            },
            dataType: "json",
            contentType: "application/json"
        });
    }

    function renderAvailableRoomsSection(rooms, availableRooms) {
        let innerHtml = '';
        for (let item of rooms) {
            innerHtml += '<div class="rooms-page-item" style="padding: 10px;">';
            innerHtml += '    <div class="row">';
            innerHtml += '        <div class="col-lg-6">';
            innerHtml += '            <div class="single-room-pic">';
            innerHtml += `                <img src="${item['photo']}" alt="">`;
            innerHtml += '            </div>';
            innerHtml += '        </div>';
            innerHtml += '        <div class="col-lg-6">';
            innerHtml += '            <div class="room-text">';
            innerHtml += '                <div class="room-title">';
            innerHtml += `                    <h2>${item['name']}</h2>`;
            innerHtml += '                    <div class="room-price">';
            innerHtml += `                        <h2>Price: ${item['price']}</h2>`;
            innerHtml += '                    </div>';
            innerHtml += '                </div>';
            innerHtml += '            </div>';
            innerHtml += '            <div class="room-desc">';
            innerHtml += `                <p>${item['roomsNumber']} places</p>`;
            innerHtml += '            </div>';
            innerHtml += '            <a href="/booking?id=' + item['id'] + '" class="primary-btn">Book</a>';
            innerHtml += '        </div>';
            innerHtml += '    </div>';
            innerHtml += '</div>';
        }
        availableRooms.html(innerHtml);
    }
})
