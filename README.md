# PROYECTO FINAL DE ARGENTINA PROGRAMA 
# EDICIÓN 2021/2022 | MÓDULO "YO PROGRAMO" 
# by MARIANO OSCAR ALMIRÓN.

# **********   DOCUMENTACIÓN DE LA API    ***********
 
 Sistema Backend escrito en lenguaje Java, utilizando Framework Spring.
 
 # USUARIO DE PRUEBA: nombreUsuario: "admin" , password: "zaratustraenBaton"
 # USUARIOS DE PRUEBA ALTERNATIVOS: nombreUsuario:"user" , password: "constantinopla"
						
 
 # ENDPOINTS
 LINK DEL SERVIDOR EN VIVO: https://projectam0.netlify.app
 
 ENTIDADES: Education, Experiences, Skill,Person, Project.
 
 EL SISTEMA CUENTA CON AUTENTICACIÓN BASADA EN TOKEN (JsonWebToken).
 
 #  *** OPEN ***
   
    LOGIN:
    https://projectam0.netlify.app/login
    
    { 
       "nombreUsuario": "admin",
       "password": "zaratustraenBaton"
    }

	O USUARIOS ALTERNATIVOS USERS

	{ 
       "nombreUsuario": "user",
       "password": "constantinopla"
    }


 # *** REGISTRO***

      EN UN FUTURO PODRIA SER IMPLEMENTADO Y DAR PERMISOS DIFERENCIADOS A LOS USUARIOS Y/O ADMINISTRADORES
 
 # *** LOCK ***
 
   # METHOD GET 
     All
        
         https://projectam0.netlify.app/educat/list
         https://projectam0.netlify.app/expjob/list
         https://projectam0.netlify.app/sh&ss/list
         https://projectam0.netlify.app/proje/list

     One
         
         https://projectam0.netlify.app/educat/detail/id
         https://projectam0.netlify.app/expjob/detail/id
         https://projectam0.netlify.app/sh&ss/detail/id
         https://projectam0.netlify.app/proje/detail/id
         
   # METHOD POST
     
         https://projectam0.netlify.app/person
         
         {
           "nombre": "...",
           "apellido": "...",
           "imagen" : "...",
           "descPers" : "...",
           "telefono" : "number of WhatsApp"
         }
     
         
        https://projectam0.netlify.app/educat
         
         {
          "nombreEduc": "...",
          "fechaInicio": "...",
          "fechaFinal": "...", 
          "descEduc" : "..."
         }
         
         
         https://projectam0.netlify.app/expjob
         
         {
          "nombreExp": "...",
          "fechaInicio": "...",
          "fechaFinal": "...",
          "descExp": "..."
         }
         
         
         https://projectam0.netlify.app/sh&ss
         
        {
         "nombre": "...",
         "imagen": "link_de_una_imagen",
	      "porcentaje": "...",
	      "color": "..."
        }
         
         
         https://projectam0.netlify.app/proje
         
         {
          "nombreProj": "...",
	       "descProj" : "...",
          "imagenProj": "link_de_una_imagen"
          
         }
         
         

   
   # METHOD PUT 
     One
         
         https://projectam0.netlify.app/editpers/id
         https://projectam0.netlify.app/editeducat/id
         https://projectam0.netlify.app/editexp/id
         https://projectam0.netlify.app/sh&ss/update
         https://projectam0.netlify.app/editproj/id
   
  # METHOD DELETE
     One

	 https://projectam0.netlify.app/educat/delete/id
         https://projectam0.netlify.app/expjob/delete/id
         https://projectam0.netlify.app/sh&ss/delete/id
         https://projectam0.netlify.app/proje/delete/id 

    
  PARA EJECUTAR LAS PETICIONES EL USUARIO DEBE ESTAR LOGUEADO, 
  DE LO CONTRARIO NO PODRA OBSERVAR LOS BOTONES DE EDICIONES.
  
  ESTE PROYECTO SE ENCUENTRA EN ETAPA DE FINALIZACIÓN.

  
  
 
 
