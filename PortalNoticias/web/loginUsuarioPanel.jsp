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
        </header>
        <main>
            <div class="login-form">
                <section class="message">
                    <p>¡Enhorabuena, ha iniciado sesión como <span><s:property value="#session.usuario"/></span>!</p>
                    <section class="buttons">
                        <s:if test="%{#session.rol == 'US'}">
                            <s:form action="gestionUsuarioUser">
                                <s:submit value="Panel de usuario"/>
                            </s:form>
                        </s:if>
                        <s:if test="%{#session.rol == 'AD'}">
                            <s:form action="gestionAdmin">
                                <s:submit value="Panel de administración"/>
                            </s:form>
                        </s:if>
                        <s:form action="cargaInicial">
                            <s:submit value="Volver al inicio"/>
                        </s:form>
                    </section>
                </section>
            </div>
        </main>
        <footer>
            <p>&copy; 2024 UPO News. Todos los derechos reservados.</p>
        </footer>
    </body>
</html>
