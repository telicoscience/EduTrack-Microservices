import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getStudents } from "../api/StudentsApi";

export default function StudentsPage() {
  const [students, setStudents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    async function loadStudents() {
      try {
        const data = await getStudents();
        setStudents(data);
      } catch {
        setError("Could not load students.");
      } finally {
        setLoading(false);
      }
    }

    loadStudents();
  }, []);

  if (loading) {
    return <p>Loading students...</p>;
  }

  if (error) {
    return <p className="error">{error}</p>;
  }
 
return (
  <section>
    <div className="page-header">
      <div>
        <h1>Students</h1>
        <p>Manage students registered in the EduTrack system.</p>
      </div>

      <Link className="button" to="/students/new">
        Add Student
      </Link>
    </div>

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
  </section>
);
 
 }
