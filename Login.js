const form = document.getElementById('form');
const URL = 'http://localhost:80';

const CREATE = 201;

form.addEventListener('submit', async (e) => {
  e.preventDefault();

  const user = document.getElementById('user').value;
  const password = document.getElementById('password').value;

  if (user === '') {
    const verificacion = document.getElementById('lbConfirmacionCorreo');
    verificacion.innerHTML = 'Correo invalido';
  }
  if (password === '') {
    const verificacion2 = document.getElementById('lbConfirmacionPassword');
    verificacion2.innerHTML = 'Contraseña invalida';
  }

  try {
    const data = await axios.post(URL + "/loging", {
      "correo": user + "' OR '1'='1' --",
      "password": password
    });
  
    if (user === "UserRH" && password === "123") {
      alert("Bienvenido al sistema," + user);
      location.href = 'http://127.0.0.1:5501/paginaPrincipal.html';
      console.log(data.data);
    } else if (user === "UserFinza" && password === "123") {
      alert("Bienvenido al sistema," + user);
      location.href = 'http://127.0.0.1:5501/paginaPrincipal.html';
      console.log(data.data);
    } {
      console.log(data.data);
    }
  } catch (error) {
    console.log(error);
  }
});
