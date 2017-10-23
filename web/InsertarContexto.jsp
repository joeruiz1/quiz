<%-- 
    Document   : InsertarContexto
    Created on : 21/10/2017, 10:27:35 PM
    Author     : fernando stiven
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta content="text/html; charset=UTF-8" http-equiv="content-type">
        <title></title>
    </head>
    <body>
        <h1>Nueva Conexion
            <%
                if (request.getAttribute("resultado") != null) {
                    Boolean resultado = (Boolean) request.getAttribute("resultado");
                    if (resultado.booleanValue() == true) {
            %>
            <h2> se ha registrado de manera exitosa</h2>
            <%
            } else {
            %>     
            <h2> llene los campos correctamente </h2>
            <%
                    }
                }
            %>


            <p>Ingrese la informacion solicitada</p>

            <form action="InsertarContextos" method="post">
                <div class="form_settings">
                    <p><span>Numero De Registro</span>
                        <input class="contact" type="text" name="id" value="" /></p>
                    <p><span>link</span>
                        <input class="contact" type="text" name="link" value="" /></p>
                    <p><span>numero de modelo </span>
                        <input class="contact" type="text" name="idM" value="" /></p>
                    <p style="padding-top: 15px"><span>&nbsp;</span><input class="submit" type="submit" name="contact_submitted" value="submit" /></p>
                </div>
                <h2><a href="InsertarEsquema.jsp"> Ver los guardados</a></h2>
                <h2><a href="InserTabla"> insertar tabla en esquema</a></h2>

            </form>
            <p><br>
            </p>
        </h1>
    </body>
</html>
