<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Página de Categoría</title>
        <link rel="stylesheet" type="text/css" href="<s:url value='/css/main.css'/>">
    </head>
    <body>
        <header>
            <div class="logo">Portal de noticias</div>
            <nav>
                <ul>
                    <li><a href="<s:url value='/index.jsp'/>">Portada</a></li>
                    <li><a href="<s:url action='categoriaNoticia'><s:param name='categoria'>Actualidad</s:param></s:url>">Actualidad</a></li>
                    <li><a href="<s:url action='categoriaNoticia'><s:param name='categoria'>Politica</s:param></s:url>">Política</a></li>
                    <li><a href="<s:url action='categoriaNoticia'><s:param name='categoria'>Deportes</s:param></s:url>">Deportes</a></li>
                    <li><a href="<s:url action='categoriaNoticia'><s:param name='categoria'>Tecnologia</s:param></s:url>">Tecnología</a></li>
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
                    <h2>Bienvenido a la página de <s:property value="categoria"/></h2>
                    <s:iterator value="#session.noticias">
                        <article class="noticia">
                            <h4><s:property value="titulo"/></h4>
                            
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

        </main>
        <footer>
            <p>&copy; 2024 Portal de noticias. Todos los derechos reservados.</p>
        </footer>
    </body>
</html>

