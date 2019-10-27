<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet"
		href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
	<title>P�melding</title>
</head>
<body>
	<h2>P�melding</h2>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input type="text"
					name="fornavn" id="fornavn" value="${Skjema.fornavn}" /> 
					<font color="red">${Skjema.fornavnError}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input type="text"
					name="etternavn" id="etternavn" value="${Skjema.etternavn}" /> 
					<font color="red">${Skjema.etternavnError}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input type="text"
					name="mobil" id="mobil" value="${Skjema.mobil}" /> 
					<font color="red">${Skjema.mobilError}</font>
			</div>
			<div class="pure-control-group">
				<label for="password">Passord:</label> <input type="password"
					name="passord" id="passord" value="${Skjema.passord}" /> 
					<font color="red">${Skjema.passordError}</font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input
					type="password" id="passordRepetert" name="passordRepetert"
					value="${Skjema.passordRepetert}" /> 
					<font color="red">${Skjema.passordRepetertError}</font>
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kj�nn:</label> <input type="radio" name="kjonn" id="mann"
					value="M" checked/>mann
				<input type="radio" name="kjonn" id="kvinne" value="K"/>kvinne
				<font color="red">${Skjema.kjonnError}</font>
			</div>
			<div class="pure-controls">
				<button type="submit" id="button" class="pure-button pure-button-primary">Meld
					meg p�</button>
			</div>
		</fieldset>
	</form>
	<script type="text/javascript" src="js/Validator.js" defer></script>
</body>
</html>