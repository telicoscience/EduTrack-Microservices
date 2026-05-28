import { useEffect, useState } from "react";
import "./App.css";

const API_URL = "http://localhost:8081/students";

function App() {
  const [students, setStudents] = useState([]);
  const [name, setName] = useState("");
  const [search, setSearch] = useState("");

  async function loadStudents() {
    const response = await fetch(API_URL);
    const data = await response.json();
    setStudents(data);
  }

  async function createStudent(event) {
    event.preventDefault();

    const response = await fetch(API_URL, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ name }),
    });

    if (!response.ok) {
      alert("Nome inválido. Preencha corretamente.");
      return;
    }

    const createdStudent = await response.json();
    setStudents([...students, createdStudent]);
    setName("");
  }

  async function searchStudent() {
    if (!search.trim()) {
      loadStudents();
      return;
    }

    const response = await fetch(`${API_URL}/search?name=${search}`);
    const data = await response.json();
    setStudents(data);
  }

  useEffect(() => {
    loadStudents();
  }, []);

  return (
    <main className="page">
      <section className="hero">
        <div>
          <p className="eyebrow">EduTrack Microservices</p>
          <h1>Student Service Dashboard</h1>
          <p className="subtitle">
            Interface simples consumindo uma API Java Spring Boot.
          </p>
        </div>

        <div className="status-card">
          <span>Alunos carregados</span>
          <strong>{students.length}</strong>
        </div>
      </section>

      <section className="grid">
        <form className="card" onSubmit={createStudent}>
          <h2>Criar aluno</h2>
          <input
            type="text"
            placeholder="Nome do aluno"
            value={name}
            onChange={(event) => setName(event.target.value)}
          />
          <button type="submit">Criar</button>
        </form>

        <div className="card">
          <h2>Buscar aluno</h2>
          <input
            type="text"
            placeholder="Buscar por nome"
            value={search}
            onChange={(event) => setSearch(event.target.value)}
          />
          <button onClick={searchStudent}>Buscar</button>
          <button className="secondary" onClick={loadStudents}>
            Recarregar
          </button>
        </div>
      </section>

      <section className="card">
        <h2>Alunos</h2>

        <div className="students-list">
          {students.map((student) => (
            <div className="student-item" key={student.id}>
              <span>#{student.id}</span>
              <strong>{student.name}</strong>
            </div>
          ))}
        </div>
      </section>
    </main>
  );
}

export default App;