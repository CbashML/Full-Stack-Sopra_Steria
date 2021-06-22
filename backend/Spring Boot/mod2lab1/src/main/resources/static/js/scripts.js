$( document ).ready(function() {

    $('#show').on('click', function () {
        $('#alert').removeClass('invisible');
        setTimeout(
            function() {
                $('#alert').addClass('invisible');
            //  $('#navbar').show();
                $('#navbar').css('visibility', 'visible');
            }
        , 1000);
        $('#navbar').show();
    });

    $('#close').on('click', function () {
        $('#alert').addClass('invisible');
    });

    $("#ViewAll").click(function (){
        $.getJSON( "http://localhost:8080/students", function( data ) {
            
            $.each( data, function( key, val ) {
                console.log("Key [" + key + "]. Value [" + val + "].");

                var markup = "<tr><td>" + val.id + "</td><td>" + val.name + "</td></tr>";
                $("table tbody").append(markup);
            });

            $('#starter').hide();
            $('#students').show();
            $('#students').css('display', 'flex');
        });
    });

});     