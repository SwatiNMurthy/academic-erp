var api = "webapi/domain";
$.get(api, function (domain, status) {
    if (status == "success") {
        var domainOptions = "";
        for (var i = 0; i < domain.length; i++) {
            domainOptions += '<option value="' + domain[i].id + '">' + domain[i].discipline + ' ' + domain[i].branch + '</option>';
        }
        $("#domainId").append(domainOptions);
    }
});
function checkEquality() {
    var p1 = document.getElementById("facultyPassword").value;
    var p2 = document.getElementById("facultyPasswordRepeat").value;

    if (p1 != p2) {
        alert("Passwords dont match.");
    }
}