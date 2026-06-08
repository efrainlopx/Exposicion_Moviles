package com.example.exposicion_moviles.data

import com.example.exposicion_moviles.R

object TopicRepository {
    const val ARG_TOPIC_ID = "topicId"

    private val topics = listOf(
        Topic(
            id = "overview",
            number = 1,
            buttonLabel = "Graficos Android",
            title = "Graficos en Android",
            summary = "Resume las clases base que permiten dibujar, dar estilo y mostrar recursos visuales dentro de una app Android.",
            keyPoints = listOf(
                "Canvas dibuja sobre una superficie.",
                "Paint define color, grosor y estilo.",
                "Path describe rutas y figuras complejas.",
                "Drawable encapsula imagenes, fondos y animaciones reutilizables.",
            ),
            logicFiles = listOf(
                "data/TopicRepository.kt",
                "ui/home/HomeFragment.kt",
                "ui/topic/TopicDetailFragment.kt",
            ),
            xmlFiles = listOf(
                "res/layout/fragment_home.xml",
                "res/layout/topic_demo_overview.xml",
            ),
            demoLayoutRes = R.layout.topic_demo_overview,
        ),
        Topic(
            id = "canvas",
            number = 2,
            buttonLabel = "Canvas",
            title = "Clase Canvas",
            summary = "Canvas es la superficie donde se dibujan lineas, rectangulos, circulos, texto, mapas de bits y rutas.",
            keyPoints = listOf(
                "Metodos comunes: drawLine, drawRect, drawCircle, drawText y drawPath.",
                "Tambien permite transformaciones como rotate, scale y translate.",
                "Se usa normalmente dentro de una View personalizada.",
            ),
            logicFiles = listOf(
                "ui/topic/views/CanvasDemoView.kt",
                "ui/topic/TopicDemoBinder.kt",
            ),
            xmlFiles = listOf(
                "res/layout/topic_demo_canvas.xml",
            ),
            demoLayoutRes = R.layout.topic_demo_canvas,
        ),
        Topic(
            id = "paint",
            number = 3,
            buttonLabel = "Paint",
            title = "Clase Paint",
            summary = "Paint controla la apariencia de cada dibujo: color, grosor, estilo, transparencia y tamano del texto.",
            keyPoints = listOf(
                "Metodos clave: setColor, setStrokeWidth, setTextSize y setStyle.",
                "Paint trabaja junto con Canvas.",
                "Permite pasar de un trazo simple a una interfaz mas clara y expresiva.",
            ),
            logicFiles = listOf(
                "ui/topic/views/PaintDemoView.kt",
                "ui/topic/TopicDemoBinder.kt",
            ),
            xmlFiles = listOf(
                "res/layout/topic_demo_paint.xml",
            ),
            demoLayoutRes = R.layout.topic_demo_paint,
        ),
        Topic(
            id = "path",
            number = 4,
            buttonLabel = "Path",
            title = "Clase Path",
            summary = "Path permite crear rutas, curvas y figuras compuestas que luego Canvas puede dibujar con un Paint.",
            keyPoints = listOf(
                "Sirve para figuras que no son rectangulos ni circulos simples.",
                "Se combina con moveTo, lineTo y quadTo para rutas personalizadas.",
                "Es util para iconos, graficas y trazos organicos.",
            ),
            logicFiles = listOf(
                "ui/topic/views/PathDemoView.kt",
                "ui/topic/TopicDemoBinder.kt",
            ),
            xmlFiles = listOf(
                "res/layout/topic_demo_path.xml",
            ),
            demoLayoutRes = R.layout.topic_demo_path,
        ),
        Topic(
            id = "drawable",
            number = 5,
            buttonLabel = "Drawable",
            title = "Drawable y subclases",
            summary = "Drawable es la base para representar recursos graficos como fondos, iconos, capas, selectores y animaciones.",
            keyPoints = listOf(
                "Se usa en botones, ImageView, fondos y estados visuales.",
                "Las subclases cambian la forma de definir y reutilizar el recurso.",
                "En esta app se muestran varias subclases separadas para compararlas rapido.",
            ),
            logicFiles = listOf(
                "data/TopicRepository.kt",
                "ui/topic/TopicDetailFragment.kt",
            ),
            xmlFiles = listOf(
                "res/layout/topic_demo_drawable.xml",
            ),
            demoLayoutRes = R.layout.topic_demo_drawable,
        ),
        Topic(
            id = "bitmap",
            number = 6,
            buttonLabel = "BitmapDrawable",
            title = "BitmapDrawable",
            summary = "BitmapDrawable muestra imagenes raster como PNG, JPG o WEBP. Es ideal para fotos o imagenes con mucho detalle.",
            keyPoints = listOf(
                "Ofrece buena fidelidad visual.",
                "Puede consumir mas memoria que un vector.",
                "Normalmente requiere variantes por densidad de pantalla.",
            ),
            logicFiles = listOf(
                "ui/topic/TopicDemoBinder.kt",
            ),
            xmlFiles = listOf(
                "res/layout/topic_demo_bitmap.xml",
            ),
            demoLayoutRes = R.layout.topic_demo_bitmap,
        ),
        Topic(
            id = "vector",
            number = 7,
            buttonLabel = "VectorDrawable",
            title = "VectorDrawable",
            summary = "VectorDrawable define graficos escalables en XML. Es una buena opcion para iconos y formas simples.",
            keyPoints = listOf(
                "No pierde calidad al cambiar de tamano.",
                "Reduce la necesidad de multiples imagenes por densidad.",
                "No es la mejor opcion para fotos o ilustraciones complejas.",
            ),
            logicFiles = listOf(
                "ui/topic/TopicDemoBinder.kt",
            ),
            xmlFiles = listOf(
                "res/layout/topic_demo_vector.xml",
                "res/drawable/ic_vector_demo.xml",
            ),
            demoLayoutRes = R.layout.topic_demo_vector,
        ),
        Topic(
            id = "layer",
            number = 8,
            buttonLabel = "LayerDrawable",
            title = "LayerDrawable",
            summary = "LayerDrawable combina varios drawables en capas para construir fondos y composiciones sin usar una imagen pesada.",
            keyPoints = listOf(
                "Cada capa se dibuja en orden.",
                "Sirve para iconos con indicadores, bordes o sombras ligeras.",
                "Demasiadas capas pueden volver dificil el mantenimiento.",
            ),
            logicFiles = listOf(
                "ui/topic/TopicDemoBinder.kt",
            ),
            xmlFiles = listOf(
                "res/layout/topic_demo_layer.xml",
                "res/drawable/layer_badge.xml",
            ),
            demoLayoutRes = R.layout.topic_demo_layer,
        ),
        Topic(
            id = "state_list",
            number = 9,
            buttonLabel = "StateListDrawable",
            title = "StateListDrawable",
            summary = "StateListDrawable cambia la apariencia de un componente segun su estado: presionado, habilitado o seleccionado.",
            keyPoints = listOf(
                "Es clave para botones e interfaces interactivas.",
                "Evita programar cambios visuales manuales en cada toque.",
                "Cada estado importante debe declararse para evitar saltos raros.",
            ),
            logicFiles = listOf(
                "ui/topic/TopicDemoBinder.kt",
            ),
            xmlFiles = listOf(
                "res/layout/topic_demo_state_list.xml",
                "res/drawable/selector_topic_button.xml",
                "res/drawable/bg_state_default.xml",
                "res/drawable/bg_state_pressed.xml",
            ),
            demoLayoutRes = R.layout.topic_demo_state_list,
        ),
        Topic(
            id = "gradient",
            number = 10,
            buttonLabel = "GradientDrawable",
            title = "GradientDrawable",
            summary = "GradientDrawable crea fondos simples con color, gradientes, bordes y esquinas redondeadas desde XML.",
            keyPoints = listOf(
                "Es util para tarjetas, botones y cajas de texto.",
                "Evita exportar imagenes para fondos sencillos.",
                "Se limita a formas basicas como rectangulos, ovalos y lineas.",
            ),
            logicFiles = listOf(
                "ui/topic/TopicDemoBinder.kt",
            ),
            xmlFiles = listOf(
                "res/layout/topic_demo_gradient.xml",
                "res/drawable/gradient_demo.xml",
            ),
            demoLayoutRes = R.layout.topic_demo_gradient,
        ),
        Topic(
            id = "shape",
            number = 11,
            buttonLabel = "ShapeDrawable",
            title = "ShapeDrawable",
            summary = "ShapeDrawable permite dibujar formas simples desde codigo y cambiar su Paint sin necesitar una imagen externa.",
            keyPoints = listOf(
                "Puede usar ovalos, rectangulos y formas redondeadas.",
                "Es bueno para demos pequenos o decoraciones dinamicas.",
                "Ayuda a mostrar la diferencia entre forma y contenido grafico.",
            ),
            logicFiles = listOf(
                "ui/topic/views/ShapeDrawableDemoView.kt",
                "ui/topic/TopicDemoBinder.kt",
            ),
            xmlFiles = listOf(
                "res/layout/topic_demo_shape.xml",
            ),
            demoLayoutRes = R.layout.topic_demo_shape,
        ),
        Topic(
            id = "transition",
            number = 12,
            buttonLabel = "TransitionDrawable",
            title = "TransitionDrawable",
            summary = "TransitionDrawable anima la transicion entre dos drawables, por ejemplo entre dos fondos o estados visuales.",
            keyPoints = listOf(
                "Sirve para cambios suaves entre colores o capas.",
                "Es una forma simple de agregar retroalimentacion visual.",
                "La demo alterna entre dos fondos con un boton.",
            ),
            logicFiles = listOf(
                "ui/topic/TopicDemoBinder.kt",
            ),
            xmlFiles = listOf(
                "res/layout/topic_demo_transition.xml",
                "res/drawable/transition_topic_demo.xml",
                "res/drawable/transition_start.xml",
                "res/drawable/transition_end.xml",
            ),
            demoLayoutRes = R.layout.topic_demo_transition,
        ),
        Topic(
            id = "animation",
            number = 13,
            buttonLabel = "AnimationDrawable",
            title = "AnimationDrawable",
            summary = "AnimationDrawable reproduce una secuencia de drawables como si fueran fotogramas. Es util para animaciones cortas y didacticas.",
            keyPoints = listOf(
                "Se define en XML con un animation-list.",
                "Cada item es un drawable con una duracion.",
                "La demo arranca y detiene la animacion con un boton.",
            ),
            logicFiles = listOf(
                "ui/topic/TopicDemoBinder.kt",
            ),
            xmlFiles = listOf(
                "res/layout/topic_demo_animation.xml",
                "res/drawable/topic_animation.xml",
                "res/drawable/anim_frame_1.xml",
                "res/drawable/anim_frame_2.xml",
                "res/drawable/anim_frame_3.xml",
            ),
            demoLayoutRes = R.layout.topic_demo_animation,
        ),
        Topic(
            id = "colors",
            number = 14,
            buttonLabel = "colors.xml",
            title = "Archivo colors.xml",
            summary = "colors.xml centraliza la paleta de colores de la app para reutilizarla en layouts, drawables y vistas personalizadas.",
            keyPoints = listOf(
                "Evita repetir codigos hexadecimales por todo el proyecto.",
                "Hace mas facil cambiar el estilo general de la app.",
                "En esta demo se muestran los colores principales usados por los ejemplos.",
            ),
            logicFiles = listOf(
                "ui/topic/TopicDemoBinder.kt",
                "ui/topic/views/CanvasDemoView.kt",
                "ui/topic/views/PaintDemoView.kt",
            ),
            xmlFiles = listOf(
                "res/layout/topic_demo_colors.xml",
                "res/values/colors.xml",
            ),
            demoLayoutRes = R.layout.topic_demo_colors,
        ),
    )

    fun all(): List<Topic> = topics

    fun findById(id: String): Topic? = topics.firstOrNull { it.id == id }
}
