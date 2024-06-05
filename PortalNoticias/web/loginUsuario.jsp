<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>UPO News</title>
        <link rel="stylesheet" type="text/css" href="<s:url value='/css/main.css'/>">
    </head>
    <body>
        <header>
            <div class="logo">
                <s:url var="paginaPrincipalURL" action="cargaInicial"/>
                <a href="<s:property value='#paginaPrincipalURL'/>">UPO News</a>
            </div>
            <section class="login">
                <s:form action="loginUsuario">
                    <s:submit value="Login"/>
                </s:form>
            </section>
        </header>
        <main>
            <div class="content">
                <section class="login-form">
                    <h2>Inicio de sesión</h2>
                    <s:if test="hasActionErrors()">
                        <div class="error-messages">
                            <s:actionerror/>
                        </div>
                    </s:if>
                    <s:form action="loginUsuarioAction" method="post">
                        <label for="correo">Correo electrónico:</label>
                        <input type="text" id="correo" name="correo" required>
                        <label for="contrasenya">Contraseña:</label>
                        <input type="password" id="contrasenya" name="contrasenya" required>
                        <input type="submit" value="Iniciar sesión">
                    </s:form>
                </section>
            </div>
        </main>
        <footer>
            <p>&copy; 2024 UPO News. Todos los derechos reservados.</p>
        </footer>
    </body>
</html>
