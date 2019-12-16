var api = "webapi/admin/listFaculty";
$.get(api, function (faculty, status) {
    if (status == "success") {
        debugger;
        var facultyOptions = "";
        for (var i = 0; i < faculty.length; i++) {
            facultyOptions += '<option value="' + faculty[i][0] + '">' + faculty[i][1] + '</option>';
        }
        $("#facultyId").append(facultyOptions);
    }
});