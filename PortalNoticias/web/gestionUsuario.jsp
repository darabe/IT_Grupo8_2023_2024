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
        <main class="user-page">
            <div class="panel">
                <h2 class="panel-title">Panel de usuario</h2>
                <div class="container container-infoUser">
                    <button class="toggleButton">Comentarios</button>
                    <div class="container-content">
                        <section class="comentarios">
                            <table>
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Contenido</th>
                                        <th>Registro</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Itera sobre la lista de Comentarios y muestra cada uno de ellos -->
                                    <s:iterator value="listComentarios">
                                        <tr>
                                            <td><s:property value="idComentario"/></td>
                                            <td><s:property value="contenido"/></td>
                                            <td><s:property value="fechaCreacion"/></td>
                                            <td>
                                                <!-- Botón para borrar un Comentario -->
                                                <s:form action="deleteComentarioUser" cssClass="delete-form">
                                                    <s:hidden name="id" value="%{idComentario}"/>
                                                    <button type="submit" class="delete-button">Borrar</button>
                                                </s:form>
                                            </td>
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                            <!-- Formulario para actualizar un Comentario existente -->
                            <s:form action="updateComentarioUser">
                                <h2>Actualizar comentario</h2>
                                <s:textfield name="id" label="ID"/>
                                <s:textfield name="contenido" label="Contenido"/>
                                <s:submit value="Actualizar"/>
                            </s:form>
                        </section>
                    </div>
                </div>
                <div class="container container-infoUser">
                    <button class="toggleButton">Valoración</button>
                    <div class="container-content">
                        <section class="valoraciones">
                            <table>
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Puntuación</th>
                                        <th>ID Comentario</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Itera sobre la lista de Valoraciones y muestra cada una de ellas -->
                                    <s:iterator value="listValoraciones">
                                        <tr>
                                            <td><s:property value="idValoracion"/></td>
                                            <td><s:property value="puntuacion"/></td>
                                            <td><s:property value="comentario.idComentario"/></td>
                                            <td>
                                                <!-- Botón para borrar una Valoración -->
                                                <s:form action="deleteValoracionUser" cssClass="delete-form">
                                                    <s:hidden name="id" value="%{idValoracion}"/>
                                                    <button type="submit" class="delete-button">Borrar</button>
                                                </s:form>
                                            </td>
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                            <!-- Formulario para crear una nueva Valoración -->
                            <s:form action="addValoracionUser">
                                <h2>Registrar valoración</h2>
                                <s:textfield name="idComentario" label="ID Comentario"/>
                                <s:textfield name="puntuacion" label="Puntuación"/>
                                <s:submit value="Registrar"/>
                            </s:form>
                            <!-- Formulario para actualizar una Valoración existente -->
                            <s:form action="updateValoracionUser">
                                <h2>Actualizar valoración</h2>
                                <s:textfield name="id" label="ID"/>
                                <s:textfield name="idComentario" label="ID Comentario"/>
                                <s:textfield name="puntuacion" label="Puntuación"/>
                                <s:submit value="Actualizar"/>
                            </s:form>
                        </section>
                    </div>
                </div>
                <div class="container container-infoUser">
                    <button class="toggleButton">Datos del perfil</button>
                    <div class="container-content">
                        <section class="infoUser">
                            <s:form action="updateUsuario" class="infoUser-form">
                                <s:hidden name="id" value="%{usuario.idUsuario}"/>
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Datos</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><s:textfield name="nombre" value="%{usuario.nombre}" label="Nombre"/></td>
                                            <td><s:textfield name="correo" value="%{usuario.correo}" label="Correo"/></td>
                                            <td><s:textfield name="rol" value="%{usuario.rol}" label="Rol" readonly="true" disabled="true"/></td>
                                            <td><s:password name="contrasenya" value="%{usuario.contrasenya}" label="Contraseña"/></td>
                                            <td><s:textfield name="fechaRegistro" value="%{usuario.fechaRegistro}" label="Fecha de Registro" readonly="true" disabled="true"/></td>
                                        </tr>
                                    </tbody>
                                </table>
                                <s:submit value="Actualizar"/>
                            </s:form>
                        </section>
                    </div>
                </div>
            </div>
        </main>
        <footer>
            <p>&copy; 2024 UPO News. Todos los derechos reservados.</p>
        </footer>
        <script src="<s:url value='/js/toggleButton.js'/>"></script>
    </body>
</html>
