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
            <nav>
                <ul>
                    <s:iterator value="categorias" var="categoria">
                        <li>
                            <s:url action="cargaInicial" var="categoriaUrl">
                                <s:param name="categoriaNombre"><s:property value="#categoria.nombre"/></s:param>
                            </s:url>
                            <a href="<s:property value="#categoriaUrl"/>"><s:property value="#categoria.nombre"/></a>
                        </li>
                    </s:iterator>
                </ul>
            </nav>
            <section class="login">
                <s:form action="loginUsuario">
                    <s:submit value="Login"/>
                </s:form>
            </section>
        </header>
        <main>
            <div class="ads-container">
                <section class="ads">
                    <aside class="ads">
                        <div class="ad"><s:property value="anuncio.contenido"/></div>
                    </aside>
                </section>
            </div>
            <div class="content">
                <section class="news">
                    <article class="noticia noticia-expandida">
                        <h4><s:property value="noticia.titulo"/></h4>
                        <h5><s:property value="noticia.autor"/></h5>
                        <p><s:property value="noticia.contenido"/></p>
                        <p><strong>Fecha de publicación: </strong><s:property value="noticia.fechaCreacion"/></p>
                    </article>
                </section>
                <section class="noticia-etiquetas">
                    <s:iterator value="etiquetas" var="etiqueta">
                        <div class="noticia-etiqueta"><s:property value="#etiqueta.nombre"/></div>
                    </s:iterator>
                </section>
                <section class="comments">
                    <h2>Comentarios</h2>
                    <s:if test="comentarios.size() > 0">
                        <s:iterator value="comentarios" var="comentario">
                            <div class="noticia-comentario">
                                <h4><s:property value="#comentario.usuario.nombre"/></h4>
                                <h5><s:property value="#comentario.fechaCreacion"/></h5>
                                <p><s:property value="#comentario.contenido"/></p>
                            </div>
                        </s:iterator>
                    </s:if>
                    <s:else>
                        <p class="no-comments">No hay comentarios aún. ¡Sé el primero en comentar!</p>
                    </s:else>
                    <s:form action="addComentarioNoticia">
                        <s:textarea name="contenido" rows="10" cols="50"/>
                        <s:hidden name="idFiltrado" value="%{idFiltrado}"/>
                        <s:submit value="Nuevo comentario"/>
                    </s:form>
                </section>
            </div>
        </main>
        <footer>
            <p>&copy; 2024 UPO News. Todos los derechos reservados.</p>
        </footer>
    </body>
</html>
