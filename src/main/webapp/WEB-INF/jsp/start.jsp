<html>
<head>
    <title>Vollyboll</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Team1</th>
            <th>Team2</th>
            <th>Result</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <select class="dropdown-header" name="players" id="players-team1-dropdown"></select><button class="btn-primary" onclick="addPlayerTeam1()">Add player team1</button>
                <div id = "team1"/>
            </td>
            <td>
                <select class="dropdown-header" name="players" id="players-team2-dropdown"></select><button class="btn-primary" onclick="addPlayerTeam2()">Add player team2</button>
                <div id = "team2"/>
            </td>
            <td>No</td>
        </tr>
        </tbody>
    </table>
    <div>
        <a class="btn btn-default" href="/submit-result">Submit</a>
    </div>

    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="players.js"></script>
</div>
</body>
</html>
