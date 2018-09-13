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
            <th>Set Team1</th>
            <th>Set Team2</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <select class="dropdown-header" id="players-team1-dropdown"></select>
                <div id = "team1"/>
            </td>
            <td>
                <select class="dropdown-header" id="players-team2-dropdown"></select>
                <div id = "team2"/>
            </td>
            <td>
                <select class="dropdown-header" id="result-team1-dropdown">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>
            </td>
            <td>
                <select class="dropdown-header" id="result-team2-dropdown">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>
            </td>
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
