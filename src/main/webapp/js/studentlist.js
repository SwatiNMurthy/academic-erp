/*window.onload = function () {
    var formData = new FormData();
    formData.append("cid", sessionStorage.getItem("cid"));
    $.ajax({
        type: 'POST',
        processData: false,
        contentType: false,
        url: "http://localhost:8080/academic_erp_war/webapi/faculty/getStudents",
        data: formData,
        success: function (student) {
            alert(sessionStorage.getItem("cid"));
            var student_data_body = "";
            for (var i = 0; i < student[0].length; i++) {
                if (student[0][i].name != undefined) {
                    //sessionStorage.setItem("cid", student[0][i].id);
                    //var domainName = student[i].domain.discipline + " " + student[i].domain.branch;
                    //var photograph = '<img src="' + student[i].photograph + '" height="80" alt="' + student[i].rollNumber + '">'
                    student_data_body += '<tr>'
                        + '<td>' + student[0][i].student_id + '</a></td>'
                        + '<td>' + student[0][i].grade + '</a></td>'
                        + '</tr>';
                }
            }
            $('#student_data tbody').html(student_data_body);
        },
        error: function (data) {
            $('#failure_p').show();
        }
    });
};

*/

var api = "webapi/course/getCourseStudents";
$.get(api, function (course, status) {
    //debugger;
    var courseId = sessionStorage.getItem("courseId");
    if (status == "success") {

        var student_data_body = "";
        for (var i=0; i<course.length; i++) {
            if(course[i].course.courseId == courseId) {
                student_data_body += '<tr class="data">'
                    + '<td>' + course[i].student.studentId + '</td>'
                    + '<td>' + course[i].student.name + '</td>'
                    + '<td contenteditable="true">'+ course[i].grade+'</td>'
                    + '</tr>';
            }
        }
        $('#student_data tbody').html(student_data_body);
    }
    $('#student_data').DataTable();
});

function showTableData() {
    var myTab = document.getElementById('student_data');
    var jsonObj = [];
    var item = {};
    // LOOP THROUGH EACH ROW OF THE TABLE AFTER HEADER.
    for (var i = 1; i < myTab.rows.length; i++) {

        // GET THE CELLS COLLECTION OF THE CURRENT ROW.
        var objCells = myTab.rows.item(i).cells;

        item = {};
        item["course"] = parseInt(sessionStorage.getItem("courseId"));
        for (var j = 0; j < objCells.length; j++) {
            console.log(objCells.item(j).innerHTML);
            if (j==0) item["student"] = parseInt(objCells.item(j).innerHTML);
            if (j==2) item["grade"] = parseInt(objCells.item(j).innerHTML);
        }
        jsonObj.push(item);
    }
    alert(JSON.stringify(jsonObj));
    var jsonText = JSON.stringify(jsonObj);

    $.post('webapi/faculty/updateGrade', jsonText);
}