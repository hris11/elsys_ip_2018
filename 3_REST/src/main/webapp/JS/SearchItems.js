$(function () {
    getTable();
});

let currentUpdate = 0;

function getTable() {
    let result;

    $.ajax({
        method: 'GET',
        async: false,
        url: '/api/shop/items',
        success: function (data) {
            result = data
        }
    });

    update(result);
}

function searchItem() {
    let url = "/api/shop/items?";
    $("#search-item input").each(function () {
        if ($(this).val() !== '') {
            url += $(this).attr("name") + "=" + $(this).val();
        }
    });

    $.ajax({
        method: 'GET',
        async: false,
        url: url,
        success: function (data) {
            update(data);
        }
    });
}

function deleteById(id) {
    console.log("neshtooooo");
    let url = `/api/shop/items/${id}`;
    $.ajax({
        method: 'DELETE',
        async: false,
        url: url,
        success: function (data) {
            getTable();
        }
    });
}

function update(data) {
    let result = data;
    let content = "";
    for (let item in result) {
        // language=HTML
        var tr = `<tr>
            <td>${result[item].id}</td>
            <td>${result[item].name}</td>
            <td>${result[item].price}</td>
            <td>${result[item].description}</td>
            <td>${result[item].color}</td>
            <td>${result[item].discount}</td>
            <td>${result[item].brand}</td>
            <td>${result[item].publishDate}</td>
            <td>${result[item].score}</td>
            <td>${result[item].tags}</td>
            <td>${result[item].availability}</td>
            <td>${result[item].city}</td>
            <td><button onClick='handleUpdate(${result[item].id})'>EDIT</button> </td>
            <td><button onClick='deleteById(${result[item].id})'>DELETE</button> </td>
            </tr>`;
        content += tr;
    }

    $("#response-table").html(content);
}

function handleUpdate(id) {
    currentUpdate = id;
    $("#update-item").toggle();
}

function updateItem() {

    var body = {};
    $("#update-item input").each(function () {
        body[$(this).attr("name")] = $(this).val();
    });

    $.ajax({
        method: 'PUT',
        async: false,
        url: `/api/shop/items/${currentUpdate}`,
        headers: {"Content-Type" : "application/json"},
        data: JSON.stringify(body),
        success: function (data) {
            $("#update-item").toggle();
            getTable();
        }
    });

}