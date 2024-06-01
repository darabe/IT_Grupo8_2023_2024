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
                <section class="anuncios">
                    <h1>Anuncios</h1>
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Título</th>
                                <th>Contenido</th>
                                <th>Tipo</th>
                                <th>Fecha</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Itera sobre la lista de Anuncios y muestra cada uno de ellos -->
                            <s:iterator value="#session.anuncios">
                                <tr>
                                    <td><s:property value="idAnuncio"/></td>
                                    <td><s:property value="titulo"/></td>
                                    <td><s:property value="contenido"/></td>
                                    <td><s:property value="tipo"/></td>
                                    <td><s:property value="fechaCreacion"/></td>
                                    <td>
                                        <!-- Botón para borrar un Anuncio -->
                                        <s:form action="deleteAnuncio" cssClass="delete-form">
                                            <s:hidden name="id" value="%{idAnuncio}"/>
                                            <button type="submit" class="delete-button">Borrar</button>
                                        </s:form>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                    <!-- Formulario para filtrar por ID -->
                    <s:form action="getListaAnunciosFiltrado" class="filtrar-form">
                        <s:textfield name="idFiltrado" label="Filtrar por ID"/>
                        <s:submit value="Filtrar"/>
                    </s:form>
                    <!-- Formulario para mostrar todos los Anuncios -->
                    <s:form action="getListaAnuncios" class="filtrar-form">
                        <s:submit value="Mostrar todo"/>
                    </s:form>
                    <!-- Formulario para crear un nuevo Anuncio -->
                    <s:form action="addAnuncio">
                        <h2>Registrar anuncio</h2>
                        <s:textfield name="titulo" label="Título"/>
                        <s:textfield name="contenido" label="Contenido"/>
                        <s:textfield name="tipo" label="Tipo"/>
                        <s:submit value="Registrar"/>
                    </s:form>
                    <!-- Formulario para actualizar un Anuncio existente -->
                    <s:form action="updateAnuncio">
                        <h2>Actualizar anuncio</h2>
                        <s:textfield name="id" label="ID"/>
                        <s:textfield name="titulo" label="Título"/>
                        <s:textfield name="contenido" label="Contenido"/>
                        <s:textfield name="tipo" label="Tipo"/>
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
