<%-- 
    Document   : gestionPerfilUsuario
    Created on : 03-jun-2024, 16:47:35
    Author     : Victor
--%>

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
                <section class="anunciantes">
                    <h1>Comentarios</h1>
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

                <section class="valoraciones">
                    <h1>Valoraciones</h1>
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

                <section class="infoUser">
                    <h1>Perfil de Usuario</h1>
                    <s:form action="updatePerfilUsuario">
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
                                    <td>
                                        <s:textfield name="nombre" value="%{usuario.nombre}" label="Nombre"/>
                                    </td>
                                    <td>
                                        <s:textfield name="correo" value="%{usuario.correo}" label="Correo"/>
                                    </td>
                                    <td>
                                        <s:textfield name="rol" value="%{usuario.rol}" label="Rol" readonly="true" disabled="true"/>
                                    </td>
                                    <td>
                                        <s:password name="contrasenya" value="%{usuario.contrasenya}" label="Contraseña"/>
                                    </td>
                                    <td>
                                        <s:textfield name="fechaRegistro" value="%{usuario.fechaRegistro}" label="Fecha de Registro" readonly="true" disabled="true"/>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <s:submit value="Actualizar Perfil"/>
                    </s:form>
                </section>
            </div>
        </main>
        <footer>
            <p>&copy; 2024 Portal de noticias. Todos los derechos reservados.</p>
        </footer>
    </body>
</html>
