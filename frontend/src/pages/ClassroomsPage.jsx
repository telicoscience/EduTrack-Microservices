import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getClassrooms } from "../services/classroomService";

export default function ClassroomsPage() {
  const [classrooms, setClassrooms] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  async function loadClassrooms() {
    try {
      setLoading(true);
      setError("");
      const data = await getClassrooms();
      setClassrooms(data);
    } catch {
      setError("Could not load classrooms.");
    } finally {
      setLoading(false);
    }
  }

  useEffect(() => {
    loadClassrooms();
  }, []);

  if (loading) {
    return <p>Loading classrooms...</p>;
  }

  return (
    <section>
      <div className="page-header">
        <div>
          <h1>Classrooms</h1>
          <p>Manage classrooms registered in the EduTrack system.</p>
        </div>

        <button className="button" type="button" onClick={loadClassrooms}>
          Refresh
        </button>
      </div>

      {error && <p className="error">{error}</p>}

      {!error && (
        <div className="table-container">
          <table className="students-table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Grade</th>
                <th>School Year</th>
                <th>Shift</th>
                <th>Capacity</th>
                <th className="actions-column">Actions</th>
              </tr>
            </thead>

            <tbody>
              {classrooms.map((classroom) => (
                <tr key={classroom.id}>
                  <td>{classroom.id}</td>
                  <td>{classroom.name}</td>
                  <td>{classroom.grade}</td>
                  <td>{classroom.schoolYear}</td>
                  <td>{classroom.shift}</td>
                  <td>{classroom.capacity}</td>
                  <td className="actions-column">
                    <Link className="table-button" to={`/classrooms/${classroom.id}`}>
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
