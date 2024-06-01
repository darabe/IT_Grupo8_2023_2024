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
                    <article>
                        <h1>Título de la noticia</h1>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam in venenatis enim. Nulla facilisi.</p>
                    </article>
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
            <section class="extra-buttons">
                <s:form action="getListaAnuncios">
                    <s:submit value="Anuncios"/>
                </s:form>
                <s:form action="getListaAnunciantes">
                    <s:submit value="Anunciantes"/>
                </s:form>
            </section>
        </main>
        <footer>
            <p>&copy; 2024 Portal de noticias. Todos los derechos reservados.</p>
        </footer>
    </body>
</html>
