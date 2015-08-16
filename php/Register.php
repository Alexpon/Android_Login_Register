<?php
	$con = mysqli_connect("Address", "Username", "Password", "Database");

	$name = $_POST["name"];
	$age = $_POST["age"];
	$password = $_POST["password"];
	$username = $_POST["username"];

	$statement = mysqli_prepare($con, "INSERT INTO User (name, age, username, password) VALUES (?, ?, ?, ?)");
	mysqli_stmt_bind_param($statement, "siss", $name, $age, $username, $password);
	mysqli_stmt_execute($statement);

	mysqli_stmt_close($statement);

	mysqli_close($con);

?>