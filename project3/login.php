<?php
    $con = mysqli_connect("A", "B", "C", "D");
    mysqli_query($con, 'SET NAMES utf8');
 
    $id = $_POST["id"];
    $passwd = $_POST["passwd"];
    
    $statement = mysqli_prepare($con, "SELECT id, passwd, name,gerne,spicy, salty, sea, mush, cucum, gosu, gut FROM Member WHERE id = ? AND passwd = ?");
    mysqli_stmt_bind_param($statement, "ss", $id, $passwd);
    mysqli_stmt_execute($statement);
 
    mysqli_stmt_bind_result($statement, $id, $passwd,$name,$gerne,$spicy,$salty,$sea,$mush,$cucum,$gosu,$gut);
 
    $response = array();
    $response["success"] = false;
 
    while(mysqli_stmt_fetch($statement)) {
        $response["success"] = true;
		$response["gerne"] = $gerne;
		$response["spicy"] = $spicy;
		$response["salty"] = $salty;
		$response["sea"] = $sea;
		$response["mush"] = $mush;
		$response["cucum"] = $cucum;
		$response["gosu"] = $gosu;
		$response["gut"] = $gut;
       
    }
 
    echo json_encode($response);
	
	
 
?>

