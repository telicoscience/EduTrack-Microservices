import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import { getStudentById } from "../api/StudentsApi";

export default function StudentDetailsPage() {
  const { id } = useParams();

  const [student, setStudent] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    async function loadStudent() {
      try {
        const data = await getStudentById(id);
        setStudent(data);
      } catch (error) {
        setError("Student not found.");
      } finally {
        setLoading(false);
      }
    }

    loadStudent();
  }, [id]);

  if (loading) {
    return <p>Loading student details...</p>;
  }

  if (error) {
    return (
      <section>
        <h1>Student Details</h1>
        <p className="error">{error}</p>

        <Link className="button" to="/students">
          Back to Students
        </Link>
      </section>
    );
  }

  return (
    <section>
      <div className="page-header">
        <div>
          <h1>Student Details</h1>
          <p>Detailed information about the selected student.</p>
        </div>

        <Link className="button" to="/students">
          Back to Students
        </Link>
      </div>

      <div className="details-card">
        <div className="details-row">
          <span>ID</span>
          <strong>{student.id}</strong>
        </div>

        <div className="details-row">
          <span>Name</span>
          <strong>{student.name}</strong>
        </div>

        <div className="details-row">
          <span>Status</span>
          <strong className="status-badge">Active</strong>
        </div>
      </div>
    </section>
  );
}