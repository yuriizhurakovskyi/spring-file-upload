let registerForm = document.querySelector('#registerForm');
let singleFileUploadInput = document.querySelector('#singleFileUploadInput');
let studentUploadError = document.querySelector('#studentUploadError');
let studentUploadSuccess = document.querySelector('#studentUploadSuccess');

function uploadSingleFile(file) {
	let firstName = document.getElementById('fname').value;
	let lastName = document.getElementById('lname').value;
	let age = document.getElementById('age').value;

	let formData = new FormData();
	formData.append("file", file);
	formData.append("firstName", firstName);
	formData.append("lastName", lastName);
	formData.append("age", age);

	let xhr = new XMLHttpRequest();
	xhr.open("POST", "/uploadStudent");

	xhr.onload = function() {
		console.log(xhr.responseText);
		let response = JSON.parse(xhr.responseText);
		if (xhr.status == 200) {
			studentUploadError.style.display = "none";
			studentUploadSuccess.innerHTML = "<br><img src="
					+ response.fileDownloadUri
					+ " alt='Student' height='180' width='150'></p><br>"
					+ "<h1>Student registered successfully. </h1>"
					+ "<h3>Firstname: " + response.firstName + " </h3>"
					+ "<h3>Lastname: " + response.lastName + " </h3>"
					+ "<h3>Age: " + response.age + " </h3>";

			studentUploadSuccess.style.display = "block";
		} else {
			studentUploadSuccess.style.display = "none";
			studentUploadError.innerHTML = (response && response.message)
					|| "Some Error Occurred";
		}
	}

	xhr.send(formData);
}

registerForm.addEventListener('submit', function(event) {
	var files = singleFileUploadInput.files;
	if (files.length === 0) {
		studentUploadError.innerHTML = "Please select a file";
		studentUploadError.style.display = "block";
	}
	uploadSingleFile(files[0]);
	event.preventDefault();
}, true);
