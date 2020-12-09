$(document).ready(
		function() {

			// SUBMIT FORM
			$("#employeeForm").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					id : $("#id").val(),
					firstName : $("#firstName").val(),
					lastName : $("#lastName").val(),
					email : $("#email").val()
				}

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/api/employees",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
					//	if (result.status == "success") {
							$("#postResultDiv").html(
									"" + result.email
											+ "Post Successfully! <br>"
											+ "---> Congrats !!" + "</p>");
					//	} else {
					//		$("#postResultDiv").html("<strong>Error</strong>");
					//	}
						console.log(result);
					},
					error : function(e) {
						alert("Error!")
						console.log("ERROR: ", e);
					}
				});

			}

		})