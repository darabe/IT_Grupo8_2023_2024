<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Portal de noticias</title>
        <link rel="stylesheet" type="text/css" href="<s:url value='/css/main.css'/>">
    </head>
    <body>
        <header>
            <div class="logo">Portal de noticias</div>
            <nav>
                <ul>
                    <li><a href="<s:url value='/index.jsp'/>">Portada</a></li>
                    <li><a href="#">Actualidad</a></li>
                    <li><a href="#">Política</a></li>
                    <li><a href="#">Deportes</a></li>
                    <li><a href="#">Tecnología</a></li>
                </ul>
            </nav>
            <section class="login">
                <s:form action="loginUsuario">
                    <s:submit value="Login"/>
                </s:form>
            </section>
        </header>
        <main>
            <div class="content">
                <section class="message">
                    <h2>Mensaje</h2>
                    <p>¡Enhorabuena, ha iniciado sesión como <span><s:property value="#session.usuario"/></span>!</p>
                </section>
            </div>
        </main>
        <footer>
            <p>&copy; 2024 Portal de noticias. Todos los derechos reservados.</p>
        </footer>
    </body>
</html>
