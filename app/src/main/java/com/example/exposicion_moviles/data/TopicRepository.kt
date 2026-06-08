package com.example.exposicion_moviles.data

import com.example.exposicion_moviles.R

object TopicRepository {
    const val ARG_TOPIC_ID = "topicId"

    private val topics = listOf(
        Topic(
            id = "canvas",
            number = 2,
            buttonLabel = "Canvas",
            title = "Clase Canvas",
            summary = "Canvas se aplica cuando necesitas dibujar algo propio dentro de la app, por ejemplo un mini tablero, un grafico o una firma digital.",
            keyPoints = listOf(
                "Pantallas de estadisticas con barras, lineas o marcadores personalizados.",
                "Vistas para dibujar rutas en mapas o bocetos rapidos.",
                "Componentes como firmas, medidores o pizarras de notas.",
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
            summary = "Paint se usa para decidir como se vera un elemento dibujado: su color, grosor, relleno y texto, por ejemplo en indicadores o etiquetas dentro de la app.",
            keyPoints = listOf(
                "Cambiar el color de alertas, progreso o estados activos.",
                "Definir grosor en lineas de graficas o contornos de tarjetas.",
                "Personalizar titulos y marcas dentro de componentes dibujados a mano.",
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
            summary = "Path sirve cuando la app necesita figuras no tan simples, como flechas, rutas, ondas o iconos hechos a medida.",
            keyPoints = listOf(
                "Flechas o conectores en tutoriales paso a paso.",
                "Lineas curvas en mapas, seguimiento de pedidos o recorrido de usuario.",
                "Formas personalizadas en dashboards o encabezados decorativos.",
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
            id = "bitmap",
            number = 6,
            buttonLabel = "BitmapDrawable",
            title = "BitmapDrawable",
            summary = "BitmapDrawable se usa cuando la app muestra imagenes reales como fotos de producto, banners, miniaturas o portadas descargadas.",
            keyPoints = listOf(
                "Galerias, perfiles de usuario o catalogos con fotografias.",
                "Banners promocionales con arte final ya exportado.",
                "Miniaturas de video, noticias o publicaciones sociales.",
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
            summary = "VectorDrawable se aplica en iconos de menu, barras de navegacion y botones donde se necesita que el diseno se vea nitido en cualquier tamano.",
            keyPoints = listOf(
                "Iconos de inicio, buscar, ajustes o favoritos.",
                "Logotipos simples que deben escalar sin perder calidad.",
                "Elementos graficos pequenos que se repiten en muchas pantallas.",
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
            summary = "LayerDrawable se usa para combinar varias capas en un mismo recurso, por ejemplo una tarjeta con fondo, borde e indicador de notificacion.",
            keyPoints = listOf(
                "Badges sobre iconos de mensajes o avisos.",
                "Tarjetas con sombra, borde e ilustracion superpuesta.",
                "Estados premium, nuevos o destacados sin exportar una imagen distinta por cada caso.",
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
            summary = "StateListDrawable se aplica en botones y controles que deben cambiar visualmente al presionarse, seleccionarse o deshabilitarse.",
            keyPoints = listOf(
                "Botones de enviar, comprar o iniciar sesion con respuesta visual al toque.",
                "Pestanas o menus que marcan la opcion actual.",
                "Switches y filtros que necesitan mostrar si estan activos o inactivos.",
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
            summary = "GradientDrawable se usa para crear fondos modernos en botones, encabezados, tarjetas o llamadas a la accion sin depender de imagenes externas.",
            keyPoints = listOf(
                "Botones principales con degradado para resaltar acciones.",
                "Encabezados o banners con color mas llamativo.",
                "Tarjetas promocionales con esquinas redondeadas y borde integrado.",
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
            summary = "ShapeDrawable se aplica cuando la app necesita crear formas desde codigo, por ejemplo chips, marcadores o decoraciones dinamicas segun datos del usuario.",
            keyPoints = listOf(
                "Etiquetas de categoria generadas al vuelo.",
                "Marcadores de estado como disponible, ocupado o completado.",
                "Decoraciones simples que cambian segun el tema o los datos cargados.",
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
            summary = "TransitionDrawable sirve para suavizar un cambio visual, por ejemplo cuando una tarjeta cambia de estado o un panel confirma una accion.",
            keyPoints = listOf(
                "Transicion de pendiente a completado en tareas o pedidos.",
                "Cambio suave de color en favoritos, likes o seleccionados.",
                "Feedback visual despues de enviar un formulario o activar una opcion.",
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
            summary = "AnimationDrawable se usa para animaciones cortas cuadro por cuadro, como un loader, un icono que palpita o una reaccion visual al tocar algo.",
            keyPoints = listOf(
                "Indicadores de carga o espera en procesos breves.",
                "Mascotas, stickers o iconos con movimiento simple.",
                "Efectos visuales pequenos para hacer la interfaz mas viva.",
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
            summary = "colors.xml se aplica para mantener una identidad visual consistente en toda la app, por ejemplo en botones, tarjetas, fondos e indicadores.",
            keyPoints = listOf(
                "Definir el color principal de marca una sola vez.",
                "Reutilizar colores de exito, alerta o texto en todas las pantallas.",
                "Cambiar la apariencia global sin editar archivo por archivo.",
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

