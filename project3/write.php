<?php
    $con = mysqli_connect("A", "B", "C", "D");
    mysqli_set_charset($con, 'utf8');
 
    $id=$_POST['id'];
	$name=$_POST['name'];
	$context=$_POST['context'];
	$replyid=$_POST['replyid'];
    $statement = mysqli_prepare($con,"INSERT INTO reply VALUES (?,?,?,?)");
	

    mysqli_stmt_bind_param($statement, "ssss", $id, $name, $context,$replyid);
    mysqli_stmt_execute($statement);
    mysqli_stmt_bind_result($statement);
 
    $response = array();
    $response["success"] = true;
 
    
 
    echo json_encode($response);
	
	
	
 
?>


