<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Login Usuario</h2>
	<form method="post" action="ControllerLogin?cmd=logar">
		login<br /> <input type="email" id="email" name="email" value=""
			size="" title="Padrao email" /> <br />Senha<br /> <input
			type="password" id="senha" name="senha" value="" size=""
			pattern="[ a-zA-Z0-9]{6,20}" title="minimo 6" />
		<button type="submit">Logar</button>
	</form>
	<br /> ${msg}
</body>
</html>