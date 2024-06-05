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
                <section class="usuarios">
                    <h1>Usuarios</h1>
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Correo</th>
                                <th>Contraseña</th>
                                <th>Rol</th>
                                <th>Registro</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Itera sobre la lista de Usuarios y muestra cada uno de ellos -->
                            <s:iterator value="#session.usuarios">
                                <tr>
                                    <td><s:property value="idUsuario"/></td>
                                    <td><s:property value="nombre"/></td>
                                    <td><s:property value="correo"/></td>
                                    <td><s:property value="contrasenya"/></td>
                                    <td><s:property value="rol"/></td>
                                    <td><s:property value="fechaRegistro"/></td>
                                    <td>
                                        <!-- Botón para borrar un Anuncio -->
                                        <s:form action="deleteUsuario" cssClass="delete-form">
                                            <s:hidden name="id" value="%{idUsuario}"/>
                                            <button type="submit" class="delete-button">Borrar</button>
                                        </s:form>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                    <!-- Formulario para filtrar por ID -->
                    <s:form action="getListaUsuariosFiltrado" class="filtrar-form">
                        <s:textfield name="idFiltrado" label="Filtrar por ID"/>
                        <s:submit value="Filtrar"/>
                    </s:form>
                    <!-- Formulario para mostrar todos los Usuarios -->
                    <s:form action="getListaUsuarios" class="filtrar-form">
                        <s:submit value="Mostrar todo"/>
                    </s:form>
                    <!-- Formulario para crear un nuevo Usuario -->
                    <s:form action="addUsuario">
                        <h2>Registrar usuario</h2>
                        <s:textfield name="nombre" label="Nombre"/>
                        <s:textfield name="correo" label="Correo electrónico"/>
                        <s:textfield name="contrasenya" label="Contraseña" type="password"/>
                        <s:textfield name="rol" label="Rol"/>
                        <s:submit value="Registrar"/>
                    </s:form>
                    <!-- Formulario para actualizar un Usuario existente -->
                    <s:form action="updateUsuario">
                        <h2>Actualizar anuncio</h2>
                        <s:textfield name="id" label="ID"/>
                        <s:textfield name="nombre" label="Nombre"/>
                        <s:textfield name="correo" label="Correo electrónico"/>
                        <s:textfield name="contrasenya" label="Contraseña" type="password"/>
                        <s:textfield name="rol" label="Rol"/>
                        <s:submit value="Actualizar"/>
                    </s:form>
                </section>
            </div>
        </main>
        <footer>
            <p>&copy; 2024 UPO News. Todos los derechos reservados.</p>
        </footer>
    </body>
</html>
