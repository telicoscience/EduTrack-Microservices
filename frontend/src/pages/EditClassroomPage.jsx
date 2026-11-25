import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

export default function EditClassroomPage() {
  const { id } = useParams();
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    name: "",
    grade: "",
    schoolYear: "",
    shift: "",
    capacity: "",
  });

  const [loading, setLoading] = useState(true);

  const [error, setError] = useState("");
  useEffect(() => {
    loadClassroom();
  }, [id]);

  async function loadClassroom() {
    setLoading(true);
    setError("");
    try {
      const response = await fetch(`http://localhost:8082/classrooms/${id}`);

      if (response.status === 404) {
        throw new Error("Classroom not found.");
      }
      if (!response.ok) {
        throw new Error("Failed to load classroom");
      }

      const data = await response.json();

      setFormData({
        name: data.name,
        grade: data.grade,
        schoolYear: data.schoolYear,
        shift: data.shift,
        capacity: data.capacity,
      });
    } catch (error) {
      console.error(error);
      setError(error.message);
    } finally {
      setLoading(false);
    }
  }

  function handleChange(event) {
    const { name, value } = event.target;

    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  }

  async function handleSubmit(event) {
    event.preventDefault();

    try {
      const response = await fetch(`http://localhost:8082/classrooms/${id}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          ...formData,
          capacity: Number(formData.capacity),
        }),
      });

      if (!response.ok) {
        throw new Error("Failed to update classroom");
      }

      navigate("/classrooms");
    } catch (error) {
      console.error(error);
      alert("Error updating classroom.");
    }
  }

  if (loading) {
    return <p>Loading...</p>;
  }

  if (error) {
  return (
    <div className="container classroom-error">
      <h1>Edit Classroom</h1>

      <div className="classroom-error-message" role="alert">
        <svg
          className="classroom-error-icon"
          viewBox="0 0 24 24"
          fill="none"
          stroke="currentColor"
          strokeWidth="2"
          strokeLinecap="round"
          strokeLinejoin="round"
          aria-hidden="true"
        >
          <path d="M12 3L2 21h20L12 3z" />
          <path d="M12 9v4" />
          <path d="M12 17h.01" />
        </svg>

        <p>{error}</p>
      </div>

      <button
        className="button classroom-back-button"
        onClick={() => navigate("/classrooms")}
      >
        ← Back to Classrooms
      </button>
    </div>
  );
}

  return (
    <div className="container">
      <h1>Edit Classroom</h1>

      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="name">Name</label>
          <input
            id="name"
            name="name"
            type="text"
            value={formData.name}
            onChange={handleChange}
            required
          />
        </div>

        <div>
          <label htmlFor="grade">Grade</label>
          <input
            id="grade"
            name="grade"
            type="text"
            value={formData.grade}
            onChange={handleChange}
            required
          />
        </div>

        <div>
          <label htmlFor="schoolYear">School Year</label>
          <input
            id="schoolYear"
            name="schoolYear"
            type="text"
            value={formData.schoolYear}
            onChange={handleChange}
            required
          />
        </div>

        <div>
          <label htmlFor="shift">Shift</label>
          <input
            id="shift"
            name="shift"
            type="text"
            value={formData.shift}
            onChange={handleChange}
            required
          />
        </div>

        <div>
          <label htmlFor="capacity">Capacity</label>
          <input
            id="capacity"
            name="capacity"
            type="number"
            min="1"
            value={formData.capacity}
            onChange={handleChange}
            required
          />
        </div>

        <button type="submit">Update Classroom</button>
      </form>
    </div>
  );
}