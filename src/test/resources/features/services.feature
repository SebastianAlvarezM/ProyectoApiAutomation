@services
  Feature: Make request to service

    #(Hacer una solicitud al método Obtener una imágen de un gato)
@GetCats
Scenario: Make request to method Get a random image for consult cats
  Given I makes the connection to the api
  When Execute the method GET with the resource api "image"
  Then See that the is returned 200

  #(Solicitar mas de 10 imagenes de gatos con la contraseña)
@GetMoreTenCats
Scenario: Make request to method Get more a ten images of cats
  Given I makes the connection to the api
  When Execute the method GET with the resource api "images"
  Then See that the is returned 200

@DeleteImage
Scenario: Make request to method DELETE for delete an image
  Given I makes the connection to the api
  When Execute the method DELETE with the resource api "image"
  Then See that the is returned 200

@GetFaultStatus
Scenario: Make request to method Get with fault in URL
  Given I makes the connection to the api
  When Execute the method GET with the resource api "Image"
  Then See that the is returned 404

@PostImage
Scenario: Make request to method POST Upload image
  Given I makes the connection to the api
  When Execute the method POST with the resource api "images"
  Then See that the is returned 200


