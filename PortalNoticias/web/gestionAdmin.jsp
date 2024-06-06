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
        <main class="admin-page">
            <div class="panel">
                <h2 class="panel-title">Panel de administración</h2>
                <div class="container container-infoUser">
                    <button class="toggleButton">Anunciante</button>
                    <div class="container-content">
                        <section class="anunciantes">
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
                                    <s:iterator value="anunciantes">
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
                                                <s:form action="deleteAnuncianteAdmin" cssClass="delete-form">
                                                    <s:hidden name="id" value="%{idAnunciante}"/>
                                                    <button type="submit" class="delete-button">Borrar</button>
                                                </s:form>
                                            </td>
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                            <!-- Formulario para crear un nuevo Anunciante -->
                            <s:form action="addAnuncianteAdmin">
                                <h2>Registrar anunciante</h2>
                                <s:textfield name="nombre" label="Nombre"/>
                                <s:textfield name="correo" label="Correo"/>
                                <s:textfield name="telefono" label="Teléfono"/>
                                <s:textfield name="direccion" label="Dirección"/>
                                <s:textfield name="pais" label="País"/>
                                <s:submit value="Registrar"/>
                            </s:form>
                            <!-- Formulario para actualizar un Anunciante existente -->
                            <s:form action="updateAnuncianteAdmin">
                                <h2>Actualizar anunciante</h2>
                                <s:select name="id" label="ID" list="anunciantes" listKey="idAnunciante" listValue="idAnunciante"/>
                                <s:textfield name="nombre" label="Nombre"/>
                                <s:textfield name="correo" label="Correo"/>
                                <s:textfield name="telefono" label="Teléfono"/>
                                <s:textfield name="direccion" label="Dirección"/>
                                <s:textfield name="pais" label="País"/>
                                <s:submit value="Actualizar"/>
                            </s:form>
                        </section>
                    </div>
                </div>
                <div class="container container-infoUser">
                    <button class="toggleButton">Anuncio</button>
                    <div class="container-content">
                        <section class="anuncios">
                            <table>
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Título</th>
                                        <th>Contenido</th>
                                        <th>Tipo</th>
                                        <th>Registro</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Itera sobre la lista de Anuncios y muestra cada uno de ellos -->
                                    <s:iterator value="anuncios">
                                        <tr>
                                            <td><s:property value="idAnuncio"/></td>
                                            <td><s:property value="titulo"/></td>
                                            <td><s:property value="contenido"/></td>
                                            <td><s:property value="tipo"/></td>
                                            <td><s:property value="fechaCreacion"/></td>
                                            <td>
                                                <!-- Botón para borrar un Anuncio -->
                                                <s:form action="deleteAnuncioAdmin" cssClass="delete-form">
                                                    <s:hidden name="id" value="%{idAnuncio}"/>
                                                    <button type="submit" class="delete-button">Borrar</button>
                                                </s:form>
                                            </td>
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                            <!-- Formulario para crear un nuevo Anuncio -->
                            <s:form action="addAnuncioAdmin">
                                <h2>Registrar anuncio</h2>
                                <s:select name="idAnunciante" label="ID Anunciantes" list="anunciantes" listKey="idAnunciante" listValue="idAnunciante"/>
                                <s:textfield name="titulo" label="Título"/>
                                <s:textfield name="contenido" label="Contenido"/>
                                <s:textfield name="tipo" label="Tipo"/>
                                <s:submit value="Registrar"/>
                            </s:form>
                            <!-- Formulario para actualizar un Anuncio existente -->
                            <s:form action="updateAnuncioAdmin">
                                <h2>Actualizar anuncio</h2>
                                <s:select name="id" label="ID" list="anuncios" listKey="idAnuncio" listValue="idAnuncio"/>
                                <s:textfield name="titulo" label="Título"/>
                                <s:textfield name="contenido" label="Contenido"/>
                                <s:textfield name="tipo" label="Tipo"/>
                                <s:submit value="Actualizar"/>
                            </s:form>
                        </section>
                    </div>
                </div>
                <div class="container container-infoUser">
                    <button class="toggleButton">Categoría</button>
                    <div class="container-content">
                        <section class="categorias">
                            <table>
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nombre</th>
                                        <th>Descripción</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Itera sobre la lista de Categorías y muestra cada uno de ellas -->
                                    <s:iterator value="categorias">
                                        <tr>
                                            <td><s:property value="idCategoria"/></td>
                                            <td><s:property value="nombre"/></td>
                                            <td><s:property value="descripcion"/></td>
                                            <td>
                                                <!-- Botón para borrar una Categoría -->
                                                <s:form action="deleteCategoriaAdmin" cssClass="delete-form">
                                                    <s:hidden name="id" value="%{idCategoria}"/>
                                                    <button type="submit" class="delete-button">Borrar</button>
                                                </s:form>
                                            </td>
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                            <!-- Formulario para crear una nueva Categoría -->
                            <s:form action="addCategoriaAdmin">
                                <h2>Registrar categoría</h2>
                                <s:textfield name="nombre" label="Nombre"/>
                                <s:textfield name="descripcion" label="Descripción"/>
                                <s:submit value="Registrar"/>
                            </s:form>
                            <!-- Formulario para actualizar una Categoría existente -->
                            <s:form action="updateCategoriaAdmin">
                                <h2>Actualizar categoría</h2>
                                <s:select name="id" label="ID" list="categorias" listKey="idCategoria" listValue="idCategoria"/>
                                <s:textfield name="nombre" label="Nombre"/>
                                <s:textfield name="descripcion" label="Descripción"/>
                                <s:submit value="Actualizar"/>
                            </s:form>
                        </section>
                    </div>
                </div>
                <div class="container container-infoUser">
                    <button class="toggleButton">Comentario</button>
                    <div class="container-content">
                        <section class="anunciantes">
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
                                    <s:iterator value="comentarios">
                                        <tr>
                                            <td><s:property value="idComentario"/></td>
                                            <td><s:property value="contenido"/></td>
                                            <td><s:property value="fechaCreacion"/></td>
                                            <td><s:property value="usuario.idUsuario"/></td>
                                            <td>
                                                <!-- Botón para borrar un Comentario -->
                                                <s:form action="deleteComentarioAdmin" cssClass="delete-form">
                                                    <s:hidden name="id" value="%{idComentario}"/>
                                                    <button type="submit" class="delete-button">Borrar</button>
                                                </s:form>
                                            </td>
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                            <!-- Formulario para crear un nuevo Comentario -->
                            <s:form action="addComentarioAdmin">
                                <h2>Registrar comentario</h2>
                                <s:select name="idFiltrado" label="ID Noticia" list="noticias" listKey="idNoticia" listValue="idNoticia"/>
                                <s:textfield name="contenido" label="Contenido"/>
                                <s:submit value="Registrar"/>
                            </s:form>
                            <!-- Formulario para actualizar un Comentario existente -->
                            <s:form action="updateComentarioAdmin">
                                <h2>Actualizar comentario</h2>
                                <s:select name="id" label="ID" list="comentarios" listKey="idComentario" listValue="idComentario"/>
                                <s:textfield name="contenido" label="Contenido"/>
                                <s:submit value="Actualizar"/>
                            </s:form>
                        </section>
                    </div>
                </div>
                <div class="container container-infoUser">
                    <button class="toggleButton">Etiqueta</button>
                    <div class="container-content">
                        <section class="etiquetas">
                            <table>
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nombre</th>
                                        <th>Descripción</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Itera sobre la lista de Etiquetas y muestra cada uno de ellas -->
                                    <s:iterator value="etiquetas">
                                        <tr>
                                            <td><s:property value="idEtiqueta"/></td>
                                            <td><s:property value="nombre"/></td>
                                            <td><s:property value="descripcion"/></td>
                                            <td>
                                                <!-- Botón para borrar una Etiqueta -->
                                                <s:form action="deleteEtiquetaAdmin" cssClass="delete-form">
                                                    <s:hidden name="id" value="%{idEtiqueta}"/>
                                                    <button type="submit" class="delete-button">Borrar</button>
                                                </s:form>
                                            </td>
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                            <!-- Formulario para crear una nueva Etiqueta -->
                            <s:form action="addEtiquetaAdmin">
                                <h2>Registrar etiqueta</h2>
                                <s:textfield name="nombre" label="Nombre"/>
                                <s:textfield name="descripcion" label="Descripción"/>
                                <s:submit value="Registrar"/>
                            </s:form>
                            <!-- Formulario para actualizar una Etiqueta existente -->
                            <s:form action="updateEtiquetaAdmin">
                                <h2>Actualizar etiqueta</h2>
                                <s:select name="id" label="ID" list="etiquetas" listKey="idEtiqueta" listValue="idEtiqueta"/>
                                <s:textfield name="nombre" label="Nombre"/>
                                <s:textfield name="descripcion" label="Descripción"/>
                                <s:submit value="Actualizar"/>
                            </s:form>
                        </section>
                    </div>
                </div>
                <div class="container container-infoUser">
                    <button class="toggleButton">Noticia</button>
                    <div class="container-content">
                        <section class="noticias">
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
                                    <s:iterator value="noticias">
                                        <tr>
                                            <td><s:property value="idNoticia"/></td>
                                            <td><s:property value="autor"/></td>
                                            <td><s:property value="titulo"/></td>
                                            <td><s:property value="imagen"/></td>
                                            <td><s:property value="contenido"/></td>
                                            <td><s:property value="fechaCreacion"/></td>
                                            <td>
                                                <!-- Botón para borrar una Noticia -->
                                                <s:form action="deleteNoticiaAdmin" cssClass="delete-form">
                                                    <s:hidden name="id" value="%{idNoticia}"/>
                                                    <button type="submit" class="delete-button">Borrar</button>
                                                </s:form>
                                            </td>
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                            <!-- Formulario para crear una nuevo Noticia -->
                            <s:form action="addNoticiaAdmin">
                                <h2>Registrar noticia</h2>
                                <h2>Registrar noticia</h2>
                                <s:select name="idCategoria" label="ID Categoria" list="categorias" listKey="idCategoria" listValue="idCategoria"/>
                                <s:select name="idAnuncio" label="ID Anuncio" list="anuncios" listKey="idAnuncio" listValue="idAnuncio"/>
                                <s:textfield name="autor" label="Autor"/>
                                <s:textfield name="titulo" label="Título"/>
                                <s:textfield name="contenido" label="Contenido"/>
                                <s:submit value="Registrar"/>
                            </s:form>
                            <!-- Formulario para actualizar una Noticia existente -->
                            <s:form action="updateNoticiaAdmin">
                                <h2>Actualizar noticia</h2>
                                <s:select name="id" label="ID" list="noticias" listKey="idNoticia" listValue="idNoticia"/>
                                <s:textfield name="autor" label="Autor"/>
                                <s:textfield name="titulo" label="Título"/>
                                <s:textfield name="contenido" label="Contenido"/>
                                <s:submit value="Actualizar"/>
                            </s:form>
                        </section>
                    </div>
                </div>
                <div class="container container-infoUser">
                    <button class="toggleButton">Usuario</button>
                    <div class="container-content">
                        <section class="usuarios">
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
                                    <s:iterator value="usuarios">
                                        <tr>
                                            <td><s:property value="idUsuario"/></td>
                                            <td><s:property value="nombre"/></td>
                                            <td><s:property value="correo"/></td>
                                            <td><s:property value="contrasenya"/></td>
                                            <td><s:property value="rol"/></td>
                                            <td><s:property value="fechaRegistro"/></td>
                                            <td>
                                                <!-- Botón para borrar un Anuncio -->
                                                <s:form action="deleteUsuarioAdmin" cssClass="delete-form">
                                                    <s:hidden name="id" value="%{idUsuario}"/>
                                                    <button type="submit" class="delete-button">Borrar</button>
                                                </s:form>
                                            </td>
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                            <!-- Formulario para crear un nuevo Usuario -->
                            <s:form action="addUsuarioAdmin">
                                <h2>Registrar usuario</h2>
                                <s:textfield name="nombre" label="Nombre"/>
                                <s:textfield name="correo" label="Correo electrónico"/>
                                <s:textfield name="contrasenya" label="Contraseña" type="password"/>
                                <s:textfield name="rol" label="Rol"/>
                                <s:submit value="Registrar"/>
                            </s:form>
                            <!-- Formulario para actualizar un Usuario existente -->
                            <s:form action="updateUsuarioAdmin">
                                <h2>Actualizar anuncio</h2>
                                <s:select name="id" label="ID" list="usuarios" listKey="idUsuario" listValue="idUsuario"/>
                                <s:textfield name="nombre" label="Nombre"/>
                                <s:textfield name="correo" label="Correo electrónico"/>
                                <s:textfield name="contrasenya" label="Contraseña" type="password"/>
                                <s:textfield name="rol" label="Rol"/>
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
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Itera sobre la lista de Valoraciones y muestra cada una de ellas -->
                                    <s:iterator value="valoraciones">
                                        <tr>
                                            <td><s:property value="idValoracion"/></td>
                                            <td><s:property value="puntuacion"/></td>
                                            <td>
                                                <!-- Botón para borrar una Valoración -->
                                                <s:form action="deleteValoracionAdmin" cssClass="delete-form">
                                                    <s:hidden name="id" value="%{idValoracion}"/>
                                                    <button type="submit" class="delete-button">Borrar</button>
                                                </s:form>
                                            </td>
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                            <!-- Formulario para crear una nueva Valoración -->
                            <s:form action="addValoracionAdmin">
                                <h2>Registrar valoración</h2>
                                <s:select name="idComentario" label="ID Comentario" list="comentarios" listKey="idComentario" listValue="idComentario"/>
                                <s:textfield name="puntuacion" label="Puntuación"/>
                                <s:submit value="Registrar"/>
                            </s:form>
                            <!-- Formulario para actualizar una Valoración existente -->
                            <s:form action="updateValoracionAdmin">
                                <h2>Actualizar valoración</h2>
                                <s:select name="id" label="ID" list="valoraciones" listKey="idValoracion" listValue="idValoracion"/>
                                <s:select name="idComentario" label="ID Comentario" list="comentarios" listKey="idComentario" listValue="idComentario"/>
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
                            <s:form action="updateUsuarioAdmin" class="infoUser-form">
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
