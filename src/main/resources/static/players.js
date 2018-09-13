function populateDropbox(dropdown) {
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


function saveAndShowSelectedTeam(dropdown, teamArray, displayElement) {
    return function () {
        var val = $(dropdown + " option:selected").text();
        teamArray.push(val);
        $(displayElement).html(teamArray.join('</br>'));
    };
}

var team1 = new Array();
$("#players-team1-dropdown").change(
    saveAndShowSelectedTeam("#players-team1-dropdown", team1, "#team1")
);


var team2 = new Array();
$("#players-team2-dropdown").change(
    saveAndShowSelectedTeam("#players-team2-dropdown", team2, "#team2")
);


var team1Result;
$("#result-team1-dropdown").change(function() {
    team1Result = $("#result-team1-dropdown option:selected").text()
});


var team2Result;
$("#result-team2-dropdown").change(function() {
    team2Result = $("#result-team2-dropdown option:selected").text()
});