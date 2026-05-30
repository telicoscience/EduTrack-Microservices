import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getStudents } from "../api/StudentsApi";

export default function Dashboard() {
  const [studentsCount, setStudentsCount] = useState(0);
  const [apiStatus, setApiStatus] = useState("Checking...");
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    async function loadDashboardData() {
      try {
        const students = await getStudents();

        setStudentsCount(students.length);
        setApiStatus("Online");
      } catch {
        setApiStatus("Offline");
      } finally {
        setLoading(false);
      }
    }

    loadDashboardData();
  }, []);

  return (
    <section>
      <h1>EduTrack Microservices</h1>
      <p>
        Student management system built with Spring Boot, React, Vite and REST API.
      </p>

      <div className="dashboard-grid">
        <div className="card">
          <h2>Total Students</h2>
          <p className="metric">{loading ? "..." : studentsCount}</p>
        </div>

        <div className="card">
          <h2>API Status</h2>
          <p className={`metric ${apiStatus === "Online" ? "success" : "error"}`}>
            {apiStatus}
          </p>
        </div>

        <div className="card">
          <h2>Backend</h2>
          <p className="metric">:8081</p>
        </div>

        <div className="card">
          <h2>Frontend</h2>
          <p className="metric">:5173</p>
        </div>
      </div>

      <div className="panel">
        <h2>Quick Actions</h2>

        <div className="actions">
          <Link className="button" to="/students">
            View Students
          </Link>

          <Link className="button" to="/students/new">
            Create Student
          </Link>

          <Link className="button" to="/students/search">
            Search Student
          </Link>
        </div>
      </div>

      <div className="panel">
        <h2>Technical Stack</h2>
        <p>Spring Boot | React | Vite | React Router | REST API</p>
      </div>
    </section>
  );
}
