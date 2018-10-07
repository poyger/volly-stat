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
        var player = {};
        player.name = val;
        teamArray.push(player);
        $(displayElement).html(teamArray.map(e => e.name).join('</br>'));
    };
}

var result = {};

// team1 
var team1 = {};
var players1 = [];
team1.name = "team1";
team1.players = players1;
result.team1 = team1;
// team 2
var team2 = {};
var players2 = [];
team2.name = "team2";
team2.players = players2;
result.team2 = team2;

$("#players-team1-dropdown").change(
    saveAndShowSelectedTeam("#players-team1-dropdown", players1, "#team1")
);


$("#players-team2-dropdown").change(
    saveAndShowSelectedTeam("#players-team2-dropdown", players2, "#team2")
);


var team1Result;
$("#result-team1-dropdown").change(function() {
    team1Result = $("#result-team1-dropdown option:selected").text()
});


var team2Result;
$("#result-team2-dropdown").change(function() {
    team2Result = $("#result-team2-dropdown option:selected").text()
});


function submitResult() {
  $.ajax({
    url: '/submitGameResult',
    type: 'POST',
    contentType:'application/json',
    data: JSON.stringify(result),
    dataType:'json'
  });
}