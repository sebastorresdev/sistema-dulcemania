package com.api.dulcemaria.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permite CORS para todos los endpoints ("/api/**")
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200") // URL de tu frontend (en este caso, Angular corriendo en el puerto 4200)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
                .allowedHeaders("*") // Permite todos los encabezados
                .allowCredentials(true); // Permite enviar credenciales (si las necesitas)
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Configura la ruta para servir archivos desde uploads
        registry.addResourceHandler("/uploads/products/**")
                .addResourceLocations("file:D:/Proyectos/sistema-ventas-almacen-dulcemania/src/dulcemaria/src/main/resources/static/uploads/productos/");
    }
}
