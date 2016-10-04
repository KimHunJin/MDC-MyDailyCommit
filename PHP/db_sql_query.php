<?php
	$doc_root = $_SERVER ['DOCUMENT_ROOT'];
	require_once ($doc_root.'/°æ·Î/db_connect.php');


	class test{
		public function query_insert($table, $values) {
			$query = "insert into ".$table." values ".$values.";";
			$this -> sql_query($query);
		}

		public function query_print($query) {
			echo $query;
		}

		public function query_select($table, $items) {
			$query = "select ".$items. " from ".$table.";";
			$result = $this->sql_query($query);

			return $result;
		}

		public function query_select_where($table, $items, $option) {
			$query = "select ".$items. " from ".$table." where ".$option.";";
			$result = $this->sql_query($query);

			return $result;
		}

		private function sql_query($query) {
			$conn = db_connect();
			$cursor = mysqli_query($conn, $query);
			mysqli_close($conn);
			return $cursor;
			// $ret = db_result_to_array($cursor);
			// $result['err']=0;
		}
	}
?>