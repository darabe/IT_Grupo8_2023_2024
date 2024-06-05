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
                <section class="etiquetas">
                    <h1>Etiquetas</h1>
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
                            <s:iterator value="#session.etiquetas">
                                <tr>
                                    <td><s:property value="idEtiqueta"/></td>
                                    <td><s:property value="nombre"/></td>
                                    <td><s:property value="descripcion"/></td>
                                    <td>
                                        <!-- Botón para borrar una Etiqueta -->
                                        <s:form action="deleteEtiqueta" cssClass="delete-form">
                                            <s:hidden name="id" value="%{idEtiqueta}"/>
                                            <button type="submit" class="delete-button">Borrar</button>
                                        </s:form>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                    <!-- Formulario para filtrar por ID -->
                    <s:form action="getListaEtiquetasFiltrado" class="filtrar-form">
                        <s:textfield name="idFiltrado" label="Filtrar por ID"/>
                        <s:submit value="Filtrar"/>
                    </s:form>
                    <!-- Formulario para mostrar todas las Etiquetas -->
                    <s:form action="getListaEtiquetas" class="filtrar-form">
                        <s:submit value="Mostrar todo"/>
                    </s:form>
                    <!-- Formulario para crear una nueva Etiqueta -->
                    <s:form action="addEtiqueta">
                        <h2>Registrar etiqueta</h2>
                        <s:textfield name="nombre" label="Nombre"/>
                        <s:textfield name="descripcion" label="Descripción"/>
                        <s:submit value="Registrar"/>
                    </s:form>
                    <!-- Formulario para actualizar una Etiqueta existente -->
                    <s:form action="updateEtiqueta">
                        <h2>Actualizar etiqueta</h2>
                        <s:textfield name="id" label="ID"/>
                        <s:textfield name="nombre" label="Nombre"/>
                        <s:textfield name="descripcion" label="Descripción"/>
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
