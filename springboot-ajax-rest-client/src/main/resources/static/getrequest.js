$(document).ready(
	function() {

		// GET REQUEST
		$("#getAllEmployees").click(function(event) {
			event.preventDefault();
			ajaxGet();
		});

		// DO GET
		function ajaxGet() {
			$.ajax({
				type: "GET",
				url: "/api/employees",
				success: function(result) {
					//if (result.status == "success") {
						$('#getResultDiv ul').empty();
						var custList = "";
						$.each(result,
							function(i, employee) {
								var user = "Employee ID  "
									+ employee.id
									+ ", Employee Name  = " + employee.firstName + " " + employee.lastName
									+ "<br>";
								$('#getResultDiv .list-group').append(
									user)
							});
						console.log("Success: ", result);
					/*} else {
						$("#getResultDiv").html("<strong>Error</strong>");
						console.log("Fail: ", result);
					}*/
				},
				error: function(e) {
					$("#getResultDiv").html("<strong>Error</strong>");
					console.log("ERROR: ", e);
				}
			});
		}
	})