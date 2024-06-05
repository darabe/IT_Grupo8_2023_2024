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
                <section class="valoraciones">
                    <h1>Valoraciones</h1>
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Puntuación</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Itera sobre la lista de Valoraciones y muestra cada una de ellas -->
                            <s:iterator value="#session.valoraciones">
                                <tr>
                                    <td><s:property value="idValoracion"/></td>
                                    <td><s:property value="puntuacion"/></td>
                                    <td>
                                        <!-- Botón para borrar una Valoración -->
                                        <s:form action="deleteValoracion" cssClass="delete-form">
                                            <s:hidden name="id" value="%{idValoracion}"/>
                                            <button type="submit" class="delete-button">Borrar</button>
                                        </s:form>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                    <!-- Formulario para filtrar por ID -->
                    <s:form action="getListaValoracionesFiltrado" class="filtrar-form">
                        <s:textfield name="idFiltrado" label="Filtrar por ID"/>
                        <s:submit value="Filtrar"/>
                    </s:form>
                    <!-- Formulario para mostrar todos las Valoraciones -->
                    <s:form action="getListaValoraciones" class="filtrar-form">
                        <s:submit value="Mostrar todo"/>
                    </s:form>
                    <!-- Formulario para crear una nueva Valoración -->
                    <s:form action="addValoracion">
                        <h2>Registrar valoración</h2>
                        <s:textfield name="idComentario" label="ID Comentario"/>
                        <s:textfield name="puntuacion" label="Puntuación"/>
                        <s:submit value="Registrar"/>
                    </s:form>
                    <!-- Formulario para actualizar una Valoración existente -->
                    <s:form action="updateValoracion">
                        <h2>Actualizar valoración</h2>
                        <s:textfield name="id" label="ID"/>
                        <s:textfield name="idComentario" label="ID Comentario"/>
                        <s:textfield name="puntuacion" label="Puntuación"/>
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
