<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Gravar Usuario</h2>
	<form method="post" action="ControllerLogin?cmd=gravar">
		login<br /> <input type="email" id="email" name="email" value=""
			size="" title="Padrao email" /> <br />Senha<br /> <input
			type="password" id="senha" name="senha" value="" size=""
			pattern="[ a-z A-Z0-9]{4,20}" title="minimo 4" />
		<button type="submit">Gravar Usuario</button>
	</form>
	<br /> ${msg}
</body>
</html>