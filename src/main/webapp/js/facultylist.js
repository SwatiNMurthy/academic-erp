var api = "webapi/faculty/getFaculty";
$.get(api, function (faculty, status) {
    var username = sessionStorage.getItem("username");
    if (status == "success") {
        var faculty_data_body = "";
        if (username=="admin") {
            for (var i = 0; i < faculty.length; i++) {
                faculty_data_body += '<tr class="data">'
                    + '<td>' + faculty[i][0] + '</td>'
                    + '<td>' + faculty[i][1] + '</td>'
                    + '</tr>';
            }
        }
        $('#faculty_data tbody').html(faculty_data_body);
    }
    $('#faculty_data').DataTable();
});