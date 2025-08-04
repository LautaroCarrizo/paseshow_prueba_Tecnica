import { useEffect, useState } from "react";
import axios from "axios";

// 🔍 Tipo basado en tu entidad de backend
interface Ticket {
  id: number;
  evento: string;
  costo: number;
  fechaVigencia: string;
  cliente: {
    id: number;
    nombre: string;
    apellido: string;
  };
}

export default function Tickets() {
  const [tickets, setTickets] = useState<Ticket[]>([]);
  const [error, setError] = useState<string | null>(null);

useEffect(() => {
  axios
    .get<Ticket[]>("http://localhost:8081/api/tickets", {
      auth: {
        username: "lauti",
        password: "f45cd14d-a3a7-4cfd-b2be-d4f316487ea9"
      }
    })
    .then((res) => setTickets(res.data))
    .catch((err) => {
      console.error(err);
      setError("No se pudieron cargar los tickets");
    });
}, []);

  return (
    <div style={{ padding: "20px" }}>
      <h2>Lista de tickets</h2>
      {error && <p style={{ color: "red" }}>{error}</p>}
      <ul>
        {tickets.map((ticket) => (
          <li key={ticket.id}>
            <strong>Evento:</strong> {ticket.evento} | 
            <strong> Costo:</strong> ${ticket.costo} | 
            <strong> Fecha:</strong> {ticket.fechaVigencia} | 
            <strong> Cliente:</strong> {ticket.cliente.nombre} {ticket.cliente.apellido}
          </li>
        ))}
      </ul>
    </div>
  );
}
