import { useEffect, useState } from "react";

import axios from "axios";

interface Cliente {
  id: number;
  nombre: string;
  apellido: string;
  dni: string;
  fechaNacimiento: string;
}
export default function Clientes() {
  const [clientes, setClientes] = useState<Cliente[]>([]);
  const [error, setError] = useState<string | null>(null);

 useEffect(() => {
    axios
      .get<Cliente[]>("http://localhost:8081/api/clientes", {
        auth: {
          username: "lauti",
          password: "f45cd14d-a3a7-4cfd-b2be-d4f316487ea9"
        }
      })
      .then((res) => setClientes(res.data))
      .catch((err) => {
        console.error(err);
        setError("No se pudieron cargar los clientes");
      });
  }, []);

  return (
    <div>
      <h2>Lista de Clientes</h2>
      {error && <p style={{ color: "red" }}>{error}</p>}
      <ul>
        {clientes.map((cliente) => (
          <li key={cliente.id}>
            {cliente.nombre} {cliente.apellido} - DNI: {cliente.dni}
          </li>
        ))}
      </ul>
    </div>
  );
}
