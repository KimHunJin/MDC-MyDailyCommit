<?php

	function db_connect() {
		$result = mysqli_connect('IP ADDRESS','ID','PASSWORD', 'DB NAME');
		if(!$result) {
			throw new Exception('Could not connect to database server');
		} else {
			mysqli_query($result, 'set names utf8');
			$result->set_charset('utf8');
			return $result;
		}
	}


	function db_result_to_array($result){
		$res_array = array();

		for($count = 0; $row = $result->fetch_assoc(); $count++){
			$res_array[$count] = $row;
		}
		return $res_array;
	}
?>