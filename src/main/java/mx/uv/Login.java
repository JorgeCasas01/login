package mx.uv;

import static spark.Spark.*;

import com.google.gson.Gson;

public class Login {
    public static Gson gson = new Gson();

    public static void main(String[] args) {

        port(80); // 80

        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            System.out.println(accessControlRequestHeaders);
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            System.out.println(accessControlRequestMethod);
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";

        });

        before((req, res) -> res.header("Access-Control-Allow-Origin", "*"));

        post("loging", (request, response) -> {
            Gson gsonRespuesta = new Gson();
            Gson gson = new Gson();
            String obtencion = request.body();
            Usuario u1 = gson.fromJson(obtencion, Usuario.class);

            RespuestaUsuario respuesta = DAO.logingUs(u1.getCorreo(), u1.getPassword());

            if (respuesta.getEstado() != 200) {
                // response.status(401);

                // return gsonRespuesta.toJson(respuesta);
            } else {
                response.status(200);
                // return gsonRespuesta.toJson(respuesta);

            }

            return gsonRespuesta.toJson(respuesta);
        });
        get("/facebook", (request, response) -> {
            response.redirect("https://www.facebook.com");
            return null;
        });
    }
}