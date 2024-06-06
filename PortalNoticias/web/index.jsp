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
                <s:if test="%{#session.usuario == null}">
                    <s:form action="loginUsuario">
                        <s:submit value="Login"/>
                    </s:form>
                </s:if>
                <s:else>
                    <a href="loginUsuarioPanel.jsp"><s:property value="#session.usuario"/></a>
                    <s:form action="logoutUsuarioAction">
                        <s:submit value="Logout"/>
                    </s:form>
                </s:else>
            </section>
        </header>
        <main>
            <div class="ads-container">
                <section class="ads">
                    <aside class="ads">
                        <s:iterator value="anuncios" var="anuncio">
                            <div class="ad"><s:property value="#anuncio.contenido"/></div>
                        </s:iterator>
                    </aside>
                </section>
            </div>
            <div class="content">
                <section class="news">
                    <s:if test="noticias.isEmpty()">
                        <div class="no-news-message">
                            <p>¡No existen noticias en esta categoría!</p>
                        </div>
                    </s:if>
                    <s:else>
                        <s:iterator value="noticias" var="noticia">
                            <s:url var="paginaNoticiaURL" action="paginaNoticia">
                                <s:param name="idFiltrado"><s:property value="#noticia.idNoticia"/></s:param>
                            </s:url>
                            <a href="<s:property value='#paginaNoticiaURL'/>" class="noticia-link">
                                <article class="noticia">
                                    <h4><s:property value="#noticia.titulo"/></h4>
                                    <h5><s:property value="#noticia.autor"/></h5>
                                </article>
                            </a>
                        </s:iterator>
                    </s:else>
                </section>
            </div>
            <section class="debug">
                <h2>debug</h2>
                <section class="extra-buttons">
                    <s:form action="getListaAnunciantes">
                        <s:submit value="Anunciantes"/>
                    </s:form>
                    <s:form action="getListaAnuncios">
                        <s:submit value="Anuncios"/>
                    </s:form>
                    <s:form action="getListaCategorias">
                        <s:submit value="Categorías"/>
                    </s:form>
                    <s:form action="getListaComentarios">
                        <s:submit value="Comentarios"/>
                    </s:form>
                    <s:form action="getListaEtiquetas">
                        <s:submit value="Etiquetas"/>
                    </s:form>
                    <s:form action="getListaNoticias">
                        <s:submit value="Noticias"/>
                    </s:form>
                    <s:form action="getListaUsuarios">
                        <s:submit value="Usuarios"/>
                    </s:form>
                    <s:form action="getListaValoraciones">
                        <s:submit value="Valoraciones"/>
                    </s:form>
                </section>
            </section>
        </main>
        <footer>
            <p>&copy; 2024 UPO News. Todos los derechos reservados.</p>
        </footer>
    </body>
</html>
