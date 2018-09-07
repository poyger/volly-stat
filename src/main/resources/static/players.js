function populateDropbox(dropdown) {
    //let dropdown = $('#players-team1-dropdown');
    dropdown.empty();
    dropdown.append('<option selected="true" disabled>Choose Player</option>');
    dropdown.prop('selectedIndex', 0);
    const url = '/getPlayers';
    $.getJSON(url, function (data) {
        $.each(data, function (key, entry) {
            dropdown.append($('<option></option>').attr('value', entry.id).text(entry.name));
        })
    });
}

populateDropbox($('#players-team1-dropdown'));
populateDropbox($('#players-team2-dropdown'));


var team2 = new Array();
$("#players-team2-dropdown").change(
    function() {
        var val = $("#players-team2-dropdown option:selected").text();
        team2.push(val);
        $("#team2").html(team2.toString());
    }
);

var team1 = new Array();
$("#players-team1-dropdown").change(
    function() {
        var val1 = $("#players-team1-dropdown option:selected").text();
        team1.push(val1);
        $("#team1").html(team1.toString());
    }
);
