# language: es

Característica: Product - Store

  Como usuario de la tienda online
  Quiero validar la autenticación y navegación de la tienda
  Para comprobar el funcionamiento del catálogo y del proceso de compra

  @Test @smoke @regression @compra
  Escenario: Validación del precio de un producto
    Dado estoy en la página de la tienda
    Cuando me logueo con mi usuario: "kellycondori@gmail.com" y contraseña: "H0l@NttD@t@"
    Y navego a la categoría: "Clothes" y subcategoría: "Men"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el título de la página del carrito
    Y vuelvo a validar el cálculo de precios en el carrito

  @test @regression @login
  Esquema del escenario: Validación de autenticación con credenciales inválidas
    Dado estoy en la página de la tienda
    Cuando me logueo con mi usuario: "<usuario>" y contraseña: "<contraseña>"
    Entonces valido que la autenticación sea rechazada
    Y permanezco en la pantalla de inicio de sesión
    Ejemplos:
      | usuario                        | contraseña         |
      | kellycondoriInvalido@gmail.com | H0l@NttD@t@        |
      | kellycondori@gmail.com         | ContraseñaInvalida |

  @regression @categoria
  Escenario: Validar búsqueda de una categoría inexistente
    Dado estoy en la página de la tienda
    Cuando busco la categoría "Autos"
    Entonces valido el título de resultados de búsqueda
    Y valido el mensaje "No se han encontrado coincidencias con tu búsqueda"
    Y no debo continuar con el flujo de compra
