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
                <section class="noticias">
                    <h1>Noticias</h1>
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Autor</th>
                                <th>Título</th>
                                <th>Imagen</th>
                                <th>Contenido</th>
                                <th>Registro</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Itera sobre la lista de Noticias y muestra cada uno de ellas -->
                            <s:iterator value="#session.noticias">
                                <tr>
                                    <td><s:property value="idNoticia"/></td>
                                    <td><s:property value="autor"/></td>
                                    <td><s:property value="titulo"/></td>
                                    <td><s:property value="imagen"/></td>
                                    <td><s:property value="contenido"/></td>
                                    <td><s:property value="fechaCreacion"/></td>
                                    <td>
                                        <!-- Botón para borrar una Noticia -->
                                        <s:form action="deleteNoticia" cssClass="delete-form">
                                            <s:hidden name="id" value="%{idNoticia}"/>
                                            <button type="submit" class="delete-button">Borrar</button>
                                        </s:form>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                    <!-- Formulario para filtrar por ID -->
                    <s:form action="getListaNoticiasFiltrado" class="filtrar-form">
                        <s:textfield name="idFiltrado" label="Filtrar por ID"/>
                        <s:submit value="Filtrar"/>
                    </s:form>
                    <!-- Formulario para mostrar todas las Noticias -->
                    <s:form action="getListaNoticias" class="filtrar-form">
                        <s:submit value="Mostrar todo"/>
                    </s:form>
                    <!-- Formulario para crear una nuevo Noticia -->
                    <s:form action="addNoticia">
                        <h2>Registrar noticia</h2>
                        <s:textfield name="autor" label="Autor"/>
                        <s:textfield name="titulo" label="Título"/>
                        <s:textfield name="contenido" label="Contenido"/>
                        <s:submit value="Registrar"/>
                    </s:form>
                    <!-- Formulario para actualizar una Noticia existente -->
                    <s:form action="updateNoticia">
                        <h2>Actualizar anuncio</h2>
                        <s:textfield name="id" label="ID"/>
                        <s:textfield name="autor" label="Autor"/>
                        <s:textfield name="titulo" label="Título"/>
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
