<?php
    $con = mysqli_connect("Endpoint", "db_id", "db_password", "new_schema");
    mysqli_query($con, 'SET NAMES utf8');
 
    $id = $_POST["id"];
    $passwd = $_POST["passwd"];
    
    $statement = mysqli_prepare($con, "SELECT id, passwd FROM Member WHERE id = ? AND passwd = ?");
    mysqli_stmt_bind_param($statement, "ss", $id, $passwd);
    mysqli_stmt_execute($statement);
 
    mysqli_stmt_bind_result($statement, $id, $passwd);
 
    $response = array();
    $response["success"] = false;
 
    while(mysqli_stmt_fetch($statement)) {
        $response["success"] = true;
        $response["id"] = $id;
        $response["passwd"] = $passwd;       
    }
 
    echo json_encode($response);
	
	
 
?>

