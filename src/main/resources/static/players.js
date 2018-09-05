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

var team1 = new Array();
function addPlayerTeam1() {
    team1.push($("#players-team1-dropdown").find(":selected").text());
    $("#team1").html(team1.toString());
}

var team2 = new Array();
function addPlayerTeam2() {
    team2.push($("#players-team2-dropdown").find(":selected").text());
    $("#team2").html(team2.toString());
}
