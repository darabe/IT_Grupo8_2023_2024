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
                <section class="news">
                    <s:iterator value="#session.noticias">
                        <article class="noticia">
                            <h4><s:property value="titulo"/></h4>
                            <h5><s:property value="autor"/></h5>
                        </article>
                    </s:iterator>
                </section>
                <aside class="ads">
                    <h2>Anuncios</h2>
                    <div class="ad">Espacio para anuncios</div>
                    <div class="ad">Espacio para anuncios</div>
                    <div class="ad">Espacio para anuncios</div>
                </aside>
            </div>
            <section class="comments">
                <h2>Comentarios</h2>
                <s:form action="#">
                    <s:submit value="Nuevo comentario"/>
                </s:form>
            </section>
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
            <p>&copy; 2024 Portal de noticias. Todos los derechos reservados.</p>
        </footer>
    </body>
</html>
