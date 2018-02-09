$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/dataload"
    }).then(function(data, status, jqxhr) {
       $('.dataload-id').append(data.id);
       $('.dataload-content').append(data.content);
       console.log(jqxhr);
    });
});
