import { useState } from "react";
import { Link } from "react-router-dom";
import { searchStudentsByName } from "../api/StudentsApi";

export default function SearchStudentsPage() {
  const [name, setName] = useState("");
  const [students, setStudents] = useState([]);
  const [searched, setSearched] = useState(false);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  async function handleSubmit(event) {
    event.preventDefault();

    if (!name.trim()) {
      setError("Type a student name.");
      return;
    }

    try {
      setLoading(true);
      setError("");
      setSearched(true);

      const data = await searchStudentsByName(name);
      setStudents(data);
    } catch (error) {
      setError("Could not search students.");
      setStudents([]);
    } finally {
      setLoading(false);
    }
  }

  return (
    <section>
      <div className="page-header">
        <div>
          <h1>Search Students</h1>
          <p>Find students by name using the EduTrack REST API.</p>
        </div>
      </div>

      <form className="search-form" onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Type a student name..."
          value={name}
          onChange={(event) => setName(event.target.value)}
        />

        <button type="submit" className="button">
          Search
        </button>
      </form>

      {loading && <p>Searching...</p>}

      {error && <p className="error">{error}</p>}

      {searched && !loading && students.length === 0 && !error && (
        <p>No students found.</p>
      )}

      {students.length > 0 && (
        <div className="table-container">
          <table className="students-table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Student Name</th>
                <th>Status</th>
                <th className="actions-column">Actions</th>
              </tr>
            </thead>

            <tbody>
              {students.map((student) => (
                <tr key={student.id}>
                  <td>{student.id}</td>
                  <td>{student.name}</td>
                  <td>
                    <span className="status-badge">Active</span>
                  </td>
                  <td className="actions-column">
                    <Link className="table-button" to={`/students/${student.id}`}>
                      View Details
                    </Link>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </section>
  );
}