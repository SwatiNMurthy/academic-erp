function checkEquality() {
    var p1 = document.getElementById("facultyPassword").value;
    var p2 = document.getElementById("facultyPasswordRepeat").value;

    if (p1 != p2) {
        alert("Passwords dont match.");
    }
}