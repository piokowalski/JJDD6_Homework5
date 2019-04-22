<!DOCTYPE html>
<html>
<head>
    <title>Servlet</title>
</head>
<body>
<h1><strong>${name}</strong></h1>
<h1><strong>${surname}</strong></h1>
<h2><strong>${group}</strong></h2>
<br>
<h2>${time}</h2>
<br>

<form action="/infoShareAcademy" method="post">
    Parameter 1:
    <input type="text" name="param1"><br>
    Parameter 2:
    <input type="text" name="param2"><br>
    Parameter 3:
    <input type="text" name="param3"><br>
    Parameter 3:
    <input type="text" name="param3"><br>
    <input type="submit" value="Send it!">
</form>
</body>
</html>