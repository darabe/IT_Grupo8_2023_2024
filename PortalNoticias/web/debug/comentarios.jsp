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
            <div class="content">
                <section class="anunciantes">
                    <h1>Comentarios</h1>
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Contenido</th>
                                <th>Registro</th>
                                <th>Usuario</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Itera sobre la lista de Comentarios y muestra cada uno de ellos -->
                            <s:iterator value="#session.comentarios">
                                <tr>
                                    <td><s:property value="idComentario"/></td>
                                    <td><s:property value="contenido"/></td>
                                    <td><s:property value="fechaCreacion"/></td>
                                    <td><s:property value="usuario.idUsuario"/></td>
                                    <td>
                                        <!-- Botón para borrar un Comentario -->
                                        <s:form action="deleteComentario" cssClass="delete-form">
                                            <s:hidden name="id" value="%{idComentario}"/>
                                            <button type="submit" class="delete-button">Borrar</button>
                                        </s:form>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                    <!-- Formulario para filtrar por ID -->
                    <s:form action="getListaComentariosFiltrado" class="filtrar-form">
                        <s:textfield name="idFiltrado" label="Filtrar por ID"/>
                        <s:submit value="Filtrar"/>
                    </s:form>
                    <!-- Formulario para mostrar todos los Comentarios -->
                    <s:form action="getListaComentarios" class="filtrar-form">
                        <s:submit value="Mostrar todo"/>
                    </s:form>
                    <!-- Formulario para crear un nuevo Comentario -->
                    <s:form action="addComentario">
                        <h2>Registrar comentario</h2>
                        <s:textfield name="contenido" label="Contenido"/>
                        <s:submit value="Registrar"/>
                    </s:form>
                    <!-- Formulario para actualizar un Comentario existente -->
                    <s:form action="updateComentario">
                        <h2>Actualizar comentario</h2>
                        <s:textfield name="id" label="ID"/>
                        <s:textfield name="contenido" label="Contenido"/>
                        <s:submit value="Actualizar"/>
                    </s:form>
                </section>
            </div>
        </main>
        <footer>
            <p>&copy; 2024 Portal de noticias. Todos los derechos reservados.</p>
        </footer>
    </body>
</html>
