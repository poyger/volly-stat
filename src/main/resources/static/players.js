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
        var player = {};
        player.id = $(dropdown + " option:selected").val();
        player.name = $(dropdown + " option:selected").text();
        teamArray.push(player);
        $(displayElement).html(teamArray.map(e => e.name).join('</br>'));
    };
}

var result = {
    game: {
        date: ''
    },
    team1: {
        name: 'team1',
        players: []
    },
    team2: {
        name: 'team2',
        players: []
    },
    team1SetWin: '',
    team2SetWin: ''
};

$("#players-team1-dropdown").change(
    saveAndShowSelectedTeam("#players-team1-dropdown", result.team1.players, "#team1")
);

$("#players-team2-dropdown").change(
    saveAndShowSelectedTeam("#players-team2-dropdown", result.team2.players, "#team2")
);

$(document).ready(function () {
    var date_input = $('input[name="date"]');
    var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
    date_input.datepicker({
        format: 'yyyy-mm-dd',
        container: container,
        todayHighlight: true,
        autoclose: true,
    })
})

function submitResult() {
    result.team1SetWin = $("#result-team1-dropdown option:selected").text();
    result.team2SetWin = $("#result-team2-dropdown option:selected").text();
    result.game.date = $("#date").val()
    $.ajax({
        url: '/submitGameResult',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(result),
        dataType: 'json'
    });
}

