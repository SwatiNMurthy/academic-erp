function myFunction() {
    alert("I have been clicked");
    $.post("/webapi/facultylogin", function(data, status){
        alert("Data: " + data + "\nStatus: " + status);
    });
}