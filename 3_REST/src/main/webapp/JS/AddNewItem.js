function createNewItem() {
    //$("#insert-item").toggle();
    var body = {};
    $("#insert-item input").each(function () {
         body[$(this).attr("name")] = $(this).val();
    });

    $.ajax({
        method: 'POST',
        async: false,
        url: '/api/shop/items',
        headers: {"Content-Type" : "application/json"},
        data: JSON.stringify(body),
        success: function (data) {
            console.log("Response ok");
        }
    });
}