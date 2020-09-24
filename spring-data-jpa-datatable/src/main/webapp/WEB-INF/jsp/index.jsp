<html>
<head>
<title>Data JPA Table Example</title>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css" />
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>

</head>
<body>
	<table id="users" class="display" style="width: 100%">
		<thead>
			<tr>
				<th>ID</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Email</th>
				<th>MobileNo</th>
			</tr>
		</thead>
	</table>

    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.spring-friendly.js"></script>
	<script>
      $(document).ready(function () {
        $("#users").DataTable({
        	ajax : '/user/datalist',
        	serverSide : true,
        	columns :[
        		{
        			data : 'userId'
        		},{
        			data : 'firstName'
        		},{
        			data : 'lastName'
        		},{
        			data : 'email'
        		},{
        			data : 'mobileNo'
        		} 
        	]
        })
      });
    </script>
</body>
</html>
