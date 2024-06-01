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
                    <h1>Anunciantes</h1>
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Correo</th>
                                <th>Teléfono</th>
                                <th>Dirección</th>
                                <th>País</th>
                                <th>Registro</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Itera sobre la lista de Anunciantes y muestra cada uno de ellos -->
                            <s:iterator value="#session.anunciantes">
                                <tr>
                                    <td><s:property value="idAnunciante"/></td>
                                    <td><s:property value="nombre"/></td>
                                    <td><s:property value="correo"/></td>
                                    <td><s:property value="telefono"/></td>
                                    <td><s:property value="direccion"/></td>
                                    <td><s:property value="pais"/></td>
                                    <td><s:property value="fechaRegistro"/></td>
                                    <td>
                                        <!-- Botón para borrar un Anunciante -->
                                        <s:form action="deleteAnunciante" cssClass="delete-form">
                                            <s:hidden name="id" value="%{idAnunciante}"/>
                                            <button type="submit" class="delete-button">Borrar</button>
                                        </s:form>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                    <!-- Formulario para filtrar por ID -->
                    <s:form action="getListaAnunciantesFiltrado" class="filtrar-form">
                        <s:textfield name="idFiltrado" label="Filtrar por ID"/>
                        <s:submit value="Filtrar"/>
                    </s:form>
                    <!-- Formulario para mostrar todos los Anunciantes -->
                    <s:form action="getListaAnunciantes" class="filtrar-form">
                        <s:submit value="Mostrar todo"/>
                    </s:form>
                    <!-- Formulario para crear un nuevo Anunciante -->
                    <s:form action="addAnunciante">
                        <h2>Registrar anunciante</h2>
                        <s:textfield name="nombre" label="Nombre"/>
                        <s:textfield name="correo" label="Correo"/>
                        <s:textfield name="telefono" label="Teléfono"/>
                        <s:textfield name="direccion" label="Dirección"/>
                        <s:textfield name="pais" label="País"/>
                        <s:submit value="Registrar"/>
                    </s:form>
                    <!-- Formulario para actualizar un Anunciante existente -->
                    <s:form action="updateAnunciante">
                        <h2>Actualizar anunciante</h2>
                        <s:textfield name="id" label="ID"/>
                        <s:textfield name="nombre" label="Nombre"/>
                        <s:textfield name="correo" label="Correo"/>
                        <s:textfield name="telefono" label="Teléfono"/>
                        <s:textfield name="direccion" label="Dirección"/>
                        <s:textfield name="pais" label="País"/>
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
